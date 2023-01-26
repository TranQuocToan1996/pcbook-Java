package com.gitlab.techschool.pcbook.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

import com.gitlab.techschool.pcbook.pb.CreateLaptopRequest;
import com.gitlab.techschool.pcbook.pb.CreateLaptopResponse;
import com.gitlab.techschool.pcbook.pb.Laptop;
import com.gitlab.techschool.pcbook.pb.LaptopServiceGrpc;
import com.gitlab.techschool.pcbook.pb.RateLaptopRequest;
import com.gitlab.techschool.pcbook.pb.RateLaptopResponse;
import com.gitlab.techschool.pcbook.pb.SearchLaptopRequest;
import com.gitlab.techschool.pcbook.pb.SearchLaptopResponse;
import com.gitlab.techschool.pcbook.pb.UploadImageRequest;
import com.gitlab.techschool.pcbook.pb.UploadImageResponse;
import com.google.protobuf.ByteString;

import io.grpc.Context;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class LaptopService extends LaptopServiceGrpc.LaptopServiceImplBase {
    private static final Logger logger = Logger
            .getLogger(LaptopService.class.getName());

    private LaptopStore laptopStore;
    private ImageStore imageStore;
    private RatingStore ratingStore;

    public LaptopService(LaptopStore laptopStore,
            ImageStore imageStore, RatingStore ratingStore) {
        this.laptopStore = laptopStore;
        this.imageStore = imageStore;
        this.ratingStore = ratingStore;
    }

    @Override
    public void createLaptop(CreateLaptopRequest request, StreamObserver<CreateLaptopResponse> responseObserver) {
        Laptop laptop = request.getLaptop();

        String id = laptop.getId();
        logger.info("got a create-laptop request with ID: " + id);

        UUID uuid;
        if (id.isEmpty()) {
            uuid = UUID.randomUUID();
        } else {
            try {
                uuid = UUID.fromString(id);
            } catch (IllegalArgumentException e) {
                responseObserver.onError(
                        Status.INVALID_ARGUMENT
                                .withDescription(e.getMessage())
                                .asRuntimeException());
                return;
            }
        }

        if (Context.current().isCancelled()) {
            logger.info("request is cancelled");
            responseObserver.onError(
                    Status.CANCELLED
                            .withDescription("request is cancelled")
                            .asRuntimeException());
            return;
        }

        Laptop other = laptop.toBuilder().setId(uuid.toString()).build();
        try {
            laptopStore.Save(other);
        } catch (AlreadyExistsException e) {
            responseObserver.onError(
                    Status.ALREADY_EXISTS
                            .withDescription(e.getMessage())
                            .asRuntimeException());
            return;
        } catch (Exception e) {
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription(e.getMessage())
                            .asRuntimeException());
            return;
        }

        CreateLaptopResponse response = CreateLaptopResponse
                .newBuilder()
                .setId(other.getId())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

        logger.info("saved laptop with ID: " + other.getId());
    }

    @Override
    public void searchLaptop(SearchLaptopRequest request,
            StreamObserver<SearchLaptopResponse> responseObserver) {
        var filter = request.getFilter();
        logger.info("got a search laptop request with filer" + filter);
        laptopStore.Search(Context.current(), filter, new LaptopStream() {
            @Override
            public void Send(Laptop laptop) {
                logger.info("found laptop with id " + laptop.getId());
                var resp = SearchLaptopResponse.newBuilder().setLaptop(laptop).build();
                responseObserver.onNext(resp);
            }
        });

        responseObserver.onCompleted();
        logger.info("done streaming search laptop");
    }

    @Override
    public StreamObserver<UploadImageRequest> uploadImage(StreamObserver<UploadImageResponse> responseObserver) {
        return new StreamObserver<UploadImageRequest>() {
            public static final int maxImageChunk = 1 << 10; // 1 kB
            private static final int maxImageSize = 1 << 20; // 1 Mb
            private String laptopID;
            private String imageType;
            private ByteArrayOutputStream imageByte;

            @Override
            public void onNext(UploadImageRequest req) {
                if (req.getDataCase() == UploadImageRequest.DataCase.INFO) {
                    var info = req.getInfo();
                    logger.info("receive image metadata" + info);

                    laptopID = info.getLaptopId();
                    imageType = info.getImageType();
                    imageByte = new ByteArrayOutputStream();

                    // Check laptop with ID is in the store
                    if (laptopStore.Find(laptopID) == null) {
                        logger.info("not found laptopID in store with id " + laptopID);
                        responseObserver.onError(Status.NOT_FOUND
                                .withDescription("not found laptopID in store with id " + laptopID)
                                .asRuntimeException());
                        return;
                    }

                    return;
                }

                ByteString imageChunk = req.getChunkData();
                logger.info("receive image byte string with size " + imageChunk.size());
                if (imageByte == null) {
                    logger.info("got no image byte" + imageChunk.size());
                    responseObserver.onError(Status.INVALID_ARGUMENT
                            .withDescription("[got no image byte]")
                            .asRuntimeException());
                    return;
                }

                if (imageChunk.size() > maxImageChunk) {
                    logger.info("chunk_size " + imageChunk.size() + " exceed max size " + maxImageChunk);
                    responseObserver.onError(Status.INVALID_ARGUMENT
                            .withDescription("chunk_size " + imageChunk.size() + " exceed max size "
                                    + maxImageChunk)
                            .asRuntimeException());
                    return;
                }

                if (imageChunk.size() + imageByte.size() > maxImageSize) {
                    logger.info("chunk_size " + imageChunk.size() + " exceed max size " + maxImageChunk);
                    responseObserver.onError(Status.INVALID_ARGUMENT
                            .withDescription("Image too big with exceed max size "
                                    + maxImageSize)
                            .asRuntimeException());
                    return;
                }

                try {
                    imageChunk.writeTo(imageByte);
                } catch (IOException e) {
                    responseObserver.onError(Status.INTERNAL
                            .withDescription("[fail to write chunk data to image stream]" + e.getMessage())
                            .asRuntimeException());
                    return;
                }
            }

            @Override
            public void onCompleted() {
                String imageID = "";
                int size = imageByte.size();
                try {
                    imageID = imageStore.Save(laptopID, imageType, imageByte);
                } catch (IOException e) {
                    responseObserver.onError(Status.INTERNAL
                            .withDescription("[fail to save image after receive all chunks of image]" + e.getMessage())
                            .asRuntimeException());
                    return;
                }

                var completeResp = UploadImageResponse.newBuilder()
                        .setId(imageID)
                        .setSize(size)
                        .build();

                logger.info("saved image with imageID" + imageID);

                responseObserver.onNext(completeResp);
                responseObserver.onCompleted();
            }

            @Override
            public void onError(Throwable t) {
                logger.warning("[onError]" + t.getMessage());
            }
        };
    }

    @Override
    public StreamObserver<RateLaptopRequest> rateLaptop(
            StreamObserver<RateLaptopResponse> responseObserver) {
        return new StreamObserver<RateLaptopRequest>() {
            @Override
            public void onCompleted() {
                logger.info("complete rating");
                responseObserver.onCompleted();
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace(System.out);
                logger.warning(t.getMessage());
            }

            @Override
            public void onNext(RateLaptopRequest req) {
                String laptopID = req.getLaptopId();
                double score = req.getScore();
                logger.info("receive rate laptop req with laptop_id" +
                        laptopID + " and socore" + score);
                Laptop found = laptopStore.Find(laptopID);
                if (found == null) {
                    responseObserver.onError(Status.INTERNAL
                            .withDescription("[laptopID doesnt exist]")
                            .asRuntimeException());
                    return;
                }

                Rating rating = ratingStore.Add(laptopID, score);
                RateLaptopResponse resp = RateLaptopResponse.newBuilder()
                        .setLaptopId(laptopID)
                        .setRatedCount(rating.getCount())
                        .setAverageScore(rating.getSum() / rating.getCount())
                        .build();

                responseObserver.onNext(resp);
            }
        };
    }

}

package com.gitlab.techschool.pcbook.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gitlab.techschool.pcbook.pb.CreateLaptopRequest;
import com.gitlab.techschool.pcbook.pb.CreateLaptopResponse;
import com.gitlab.techschool.pcbook.pb.Filter;
import com.gitlab.techschool.pcbook.pb.ImageInfo;
import com.gitlab.techschool.pcbook.pb.Laptop;
import com.gitlab.techschool.pcbook.pb.LaptopServiceGrpc;
import com.gitlab.techschool.pcbook.pb.LaptopServiceGrpc.LaptopServiceBlockingStub;
import com.gitlab.techschool.pcbook.pb.SearchLaptopRequest;
import com.gitlab.techschool.pcbook.pb.SearchLaptopResponse;
import com.gitlab.techschool.pcbook.pb.UploadImageRequest;
import com.gitlab.techschool.pcbook.pb.UploadImageResponse;
import com.gitlab.techschool.pcbook.sample.Generator;
import com.google.protobuf.ByteString;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class LaptopClient {
    private static final Logger logger = Logger.getLogger(LaptopClient.class.getName());

    private final ManagedChannel channel;
    private final LaptopServiceBlockingStub blockingStub;
    private final LaptopServiceGrpc.LaptopServiceStub asyncStub;

    public LaptopClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();

        // https://grpc.io/docs/languages/java/basics/
        // a blocking/synchronous stub: this means that the RPC call waits for the
        // server to respond, and will either return a response or raise an exception.
        blockingStub = LaptopServiceGrpc.newBlockingStub(channel);

        // a non-blocking/asynchronous stub that makes non-blocking calls to the server,
        // where the response is returned asynchronously. You can make certain types of
        // streaming call only using the asynchronous stub.
        asyncStub = LaptopServiceGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void createLaptop(Laptop laptop) {
        CreateLaptopRequest request = CreateLaptopRequest.newBuilder().setLaptop(laptop).build();
        CreateLaptopResponse response = CreateLaptopResponse.getDefaultInstance();

        try {
            response = blockingStub.withDeadlineAfter(5, TimeUnit.SECONDS).createLaptop(request);
        } catch (StatusRuntimeException e) {
            if (e.getStatus().getCode() == Status.Code.ALREADY_EXISTS) {
                // not a big deal
                logger.info("laptop ID already exists");
                return;
            }
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return;
        }

        logger.info("laptop created with ID: " + response.getId());
    }

    private void SearchLaptop(Filter filter) {
        logger.info("starting search foir laptop");
        var req = SearchLaptopRequest.newBuilder()
                .setFilter(filter)
                .build();

        try {
            Iterator<SearchLaptopResponse> iterator = blockingStub
                    .withDeadlineAfter(5, TimeUnit.SECONDS)
                    .searchLaptop(req);

            while (iterator.hasNext()) {
                var res = iterator.next();
                var laptop = res.getLaptop();
                logger.info("found laptop with id" + laptop.getId());
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "request search laptop fail");
        }
        logger.info("search complete");
    }

    public void uploadImage(String laptopID, String imagePath) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<UploadImageRequest> requestObserver = asyncStub.withDeadlineAfter(5, TimeUnit.SECONDS)
                .uploadImage(new StreamObserver<UploadImageResponse>() {
                    @Override
                    public void onCompleted() {
                        logger.info("[upload done]");
                        latch.countDown();
                    }

                    @Override
                    public void onError(Throwable t) {
                        logger.severe("[upload fail]" + t.getMessage());
                        latch.countDown();
                    }

                    @Override
                    public void onNext(UploadImageResponse resp) {
                        logger.info("[got upload resp]" + resp);

                    }
                });
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(imagePath);
        } catch (FileNotFoundException e) {
            logger.severe("cant open image file" + e.getMessage());
            e.printStackTrace();
            return;
        }

        var imageType = imagePath.substring(imagePath.lastIndexOf("."));
        var imageInfo = ImageInfo.newBuilder().setImageType(imageType)
                .setLaptopId(laptopID)
                .build();
        var firstReqMetaData = UploadImageRequest.newBuilder()
                .setInfo(imageInfo).build();
        try {
            requestObserver.onNext(firstReqMetaData);

            logger.info("send image info " + imageInfo);

            byte[] buffer = new byte[1024];

            while (true) {
                int readBytes = fileInputStream.read(buffer);

                if (readBytes <= 0) /* EOF */ {
                    logger.info("EOF: no more data to read");
                    break;
                }

                if (latch.getCount() == 0) {
                    logger.info("latch count is 0");
                    return;
                }

                var requestChunkData = UploadImageRequest.newBuilder()
                        .setChunkData(ByteString.copyFrom(buffer, 0, readBytes))
                        .build();
                requestObserver.onNext(requestChunkData);
                logger.info("sending chunk with size " + readBytes);
            }
        } catch (Exception e) {
            logger.severe("cant read image file" + e.getMessage());
            e.printStackTrace();
            requestObserver.onError(e);
            return;
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                logger.severe("can be leak when close image " + e.getMessage());
                e.printStackTrace();
            }
        }

        requestObserver.onCompleted();

        if (!latch.await(1, TimeUnit.MINUTES)) {
            logger.warning("upload cant finish in 1 min");
        }


    }

    public static void main(String[] args) throws InterruptedException {
        LaptopClient client = new LaptopClient("0.0.0.0", 8080);

        Generator generator = new Generator();

        try {
            /*
             * Test code for unary - blocking stub client
             * for (int i = 0; i < 10; i++) {
             * var laptop = generator.NewLaptop();
             * client.createLaptop(laptop);
             * }
             * 
             * var minRam = Memory.newBuilder()
             * .setValue(8)
             * .setUnit(Unit.GIGABYTE)
             * .build();
             * 
             * var filter = Filter.newBuilder()
             * .setMaxPriceUsd(3000)
             * .setMinCpuCores(4)
             * .setMinCpuGhz(2.5)
             * .setMinRam(minRam)
             * .build();
             * client.SearchLaptop(filter);
             */

            // for client streaming to server - async stub
            var laptop = generator.NewLaptop();
            client.createLaptop(laptop);
            client.uploadImage(laptop.getId(), "tmp/laptop.png");

        } finally {
            client.shutdown();
        }
    }

}

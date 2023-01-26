package com.gitlab.techschool.pcbook.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLException;

import com.gitlab.techschool.pcbook.pb.CreateLaptopRequest;
import com.gitlab.techschool.pcbook.pb.CreateLaptopResponse;
import com.gitlab.techschool.pcbook.pb.Filter;
import com.gitlab.techschool.pcbook.pb.ImageInfo;
import com.gitlab.techschool.pcbook.pb.Laptop;
import com.gitlab.techschool.pcbook.pb.LaptopServiceGrpc;
import com.gitlab.techschool.pcbook.pb.LaptopServiceGrpc.LaptopServiceBlockingStub;
import com.gitlab.techschool.pcbook.pb.Memory;
import com.gitlab.techschool.pcbook.pb.Memory.Unit;
import com.gitlab.techschool.pcbook.pb.RateLaptopRequest;
import com.gitlab.techschool.pcbook.pb.RateLaptopResponse;
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
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;
import io.netty.handler.ssl.SslContext;

public class LaptopClient {
    private static final Logger logger = Logger.getLogger(LaptopClient.class.getName());

    private final ManagedChannel channel;

    // https://grpc.io/docs/languages/java/basics/
    // a blocking/synchronous stub: this means that the RPC call waits for the
    // server to respond, and will either return a response or raise an exception.
    private final LaptopServiceBlockingStub blockingStub;

    // a non-blocking/asynchronous stub that makes non-blocking calls to the server,
    // where the response is returned asynchronously. You can make certain types of
    // streaming call only using the asynchronous stub.
    private final LaptopServiceGrpc.LaptopServiceStub asyncStub;

    public LaptopClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();

        blockingStub = LaptopServiceGrpc.newBlockingStub(channel);
        asyncStub = LaptopServiceGrpc.newStub(channel);
    }

    public LaptopClient(String host, int port, SslContext sslContext) {
        channel = NettyChannelBuilder.forAddress(host, port)
                .sslContext(sslContext)
                .build();

        blockingStub = LaptopServiceGrpc.newBlockingStub(channel);
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

    public void rateLaptop(String[] lapTopIDs, double[] scores) {
        var latch = new CountDownLatch(1);
        StreamObserver<RateLaptopRequest> rObserver = asyncStub.withDeadlineAfter(5, TimeUnit.SECONDS)
                .rateLaptop(new StreamObserver<RateLaptopResponse>() {
                    @Override
                    public void onCompleted() {
                        logger.info("rating laptop completed");
                        latch.countDown();
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace(System.out);
                        logger.severe(t.getMessage());
                        latch.countDown();
                    }

                    @Override
                    public void onNext(RateLaptopResponse resp) {
                        logger.info("sending laptopID" + resp.getLaptopId() +
                                "rate count" + resp.getRatedCount() +
                                "average count" + resp.getAverageScore());
                    }
                });
        int n = lapTopIDs.length;
        try {
            for (var i = 0; i < n; i++) {
                RateLaptopRequest request = RateLaptopRequest.newBuilder()
                        .setLaptopId(lapTopIDs[i])
                        .setScore(scores[i])
                        .build();
                rObserver.onNext(request);
                logger.info("send req" + request);
            }
        } catch (Exception e) {
            rObserver.onError(e);
            return;
        }

        rObserver.onCompleted();
        try {
            if (!latch.await(1, TimeUnit.MINUTES)) {
                logger.severe("rating timeout");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            logger.severe("rating latch error" + e.getMessage());
        }
    }

    public static void testSearchLaptop(LaptopClient client, Generator generator) {
        for (int i = 0; i < 10; i++) {
            var laptop = generator.NewLaptop();
            client.createLaptop(laptop);
        }

        var minRam = Memory.newBuilder()
                .setValue(8)
                .setUnit(Unit.GIGABYTE)
                .build();

        var filter = Filter.newBuilder()
                .setMaxPriceUsd(3000)
                .setMinCpuCores(4)
                .setMinCpuGhz(2.5)
                .setMinRam(minRam)
                .build();
        client.SearchLaptop(filter);
    }

    public static void testUploadImage(LaptopClient client, Generator generator) throws InterruptedException {

        // for client streaming to server - async stub
        var laptop = generator.NewLaptop();
        client.createLaptop(laptop);
        client.uploadImage(laptop.getId(), "tmp/laptop.png");

    }

    public static void testRateLaptop(LaptopClient client, Generator generator) throws InterruptedException {
        int n = 3;
        String[] laptopIDs = new String[n];
        for (var i = 0; i < n; i++) {
            var laptop = generator.NewLaptop();
            laptopIDs[i] = laptop.getId();
            client.createLaptop(laptop);
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            logger.info("rate laptop (y/n)");
            String answer = scanner.nextLine();
            if (answer.toLowerCase().trim().equals("n")) {
                break;
            }

            if (!answer.toLowerCase().trim().equals("y")) {
                logger.info("must y or n");
                continue;
            }

            double[] scores = new double[n];
            for (var i = 0; i < n; i++) {
                scores[i] = generator.NewLaptopScore();
            }

            client.rateLaptop(laptopIDs, scores);
        }

        scanner.close();
    }

    public static SslContext loadTLSCredentials() throws SSLException {
        File serverCaCertFile = new File("cert/ca-cert.pem");
        File clientCertFile = new File("cert/client-cert.pem");
        File clientKeyFile = new File("cert/client-key.pem");

        return GrpcSslContexts.forClient()
        .keyManager(clientCertFile, clientKeyFile)
                .trustManager(serverCaCertFile)
                .build();
    }

    public static void main(String[] args) throws InterruptedException, SSLException {
        SslContext sslContext = LaptopClient.loadTLSCredentials();
        LaptopClient client = new LaptopClient("0.0.0.0", 8080, sslContext);

        Generator generator = new Generator();

        try {
            testRateLaptop(client, generator);
        } finally {
            client.shutdown();
        }
    }

}

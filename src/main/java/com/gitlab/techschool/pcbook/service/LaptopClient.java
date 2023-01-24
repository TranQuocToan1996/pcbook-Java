package com.gitlab.techschool.pcbook.service;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gitlab.techschool.pcbook.pb.CreateLaptopRequest;
import com.gitlab.techschool.pcbook.pb.CreateLaptopResponse;
import com.gitlab.techschool.pcbook.pb.Filter;
import com.gitlab.techschool.pcbook.pb.Laptop;
import com.gitlab.techschool.pcbook.pb.LaptopServiceGrpc;
import com.gitlab.techschool.pcbook.pb.LaptopServiceGrpc.LaptopServiceBlockingStub;
import com.gitlab.techschool.pcbook.pb.Memory;
import com.gitlab.techschool.pcbook.pb.Memory.Unit;
import com.gitlab.techschool.pcbook.pb.SearchLaptopRequest;
import com.gitlab.techschool.pcbook.pb.SearchLaptopResponse;
import com.gitlab.techschool.pcbook.sample.Generator;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;

public class LaptopClient {
    private static final Logger logger = Logger.getLogger(LaptopClient.class.getName());

    private final ManagedChannel channel;
    private final LaptopServiceBlockingStub blockingStub;

    public LaptopClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();

        // https://grpc.io/docs/languages/java/basics/
        // a blocking/synchronous stub: this means that the RPC call waits for the
        // server to respond, and will either return a response or raise an exception.

        // a non-blocking/asynchronous stub that makes non-blocking calls to the server,
        // where the response is returned asynchronously. You can make certain types of
        // streaming call only using the asynchronous stub.
        blockingStub = LaptopServiceGrpc.newBlockingStub(channel);
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

    public static void main(String[] args) throws InterruptedException {
        LaptopClient client = new LaptopClient("0.0.0.0", 8080);

        Generator generator = new Generator();

        try {
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
        } finally {
            client.shutdown();
        }
    }

}

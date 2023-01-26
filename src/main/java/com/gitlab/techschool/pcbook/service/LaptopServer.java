package com.gitlab.techschool.pcbook.service;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.net.ssl.SSLException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;
import io.netty.handler.ssl.ClientAuth;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;

public class LaptopServer {
    private static final Logger logger = Logger.getLogger(LaptopServer.class.getName());

    private final int port;
    private final Server server;

    public LaptopServer(int port,
            LaptopStore laptopStore, ImageStore imageStore, RatingStore ratingStore) {
        this(ServerBuilder.forPort(port), port, laptopStore, imageStore, ratingStore);
    }

    public LaptopServer(int port,
            LaptopStore laptopStore, ImageStore imageStore, RatingStore ratingStore,
            SslContext sslContext) {
        this(NettyServerBuilder
                .forPort(port)
                .sslContext(sslContext), port, laptopStore, imageStore, ratingStore);
    }

    public LaptopServer(ServerBuilder serverBuilder, int port,
            LaptopStore laptopStore, ImageStore imageStore, RatingStore ratingStore) {
        this.port = port;
        LaptopService laptopService = new LaptopService(laptopStore, imageStore, ratingStore);
        server = serverBuilder.addService(laptopService)
                .addService(ProtoReflectionService.newInstance())
                .build();
    }

    public void start() throws IOException {
        server.start();
        logger.info("server started on port " + port);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("shut down gRPC server because JVM shuts down");
                try {
                    LaptopServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("server shut down");
            }
        });
    }

    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    public static SslContext loadTLSCredentials() throws SSLException {
        File serverCertFile = new File("cert/server-cert.pem");
        File serverKeyFile = new File("cert/server-key.pem");
        File clientCaCertFile = new File("cert/ca-cert.pem");

        // mutual both server and client
        var ctxBuilder = SslContextBuilder.forServer(serverCertFile, serverKeyFile)
                // .clientAuth(ClientAuth.NONE); // no client Auth
                .clientAuth(ClientAuth.REQUIRE)
                .trustManager(clientCaCertFile);// Mutual

        return GrpcSslContexts.configure(ctxBuilder).build();
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        final String imageFolder = "img";
        InMemoryLaptopStore laptopStore = new InMemoryLaptopStore();
        InMemoryRatingStore ratingStore = new InMemoryRatingStore();
        DiskImageStore imageStore = new DiskImageStore(imageFolder);

        SslContext sslContext = LaptopServer.loadTLSCredentials();

        LaptopServer server = new LaptopServer(8080,
                laptopStore, imageStore, ratingStore, sslContext);
        server.start();
        server.blockUntilShutdown();
    }
}

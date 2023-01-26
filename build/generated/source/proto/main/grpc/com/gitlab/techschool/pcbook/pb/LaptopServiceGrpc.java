package com.gitlab.techschool.pcbook.pb;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: laptop_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LaptopServiceGrpc {

  private LaptopServiceGrpc() {}

  public static final String SERVICE_NAME = "pb.LaptopService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.gitlab.techschool.pcbook.pb.CreateLaptopRequest,
      com.gitlab.techschool.pcbook.pb.CreateLaptopResponse> getCreateLaptopMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateLaptop",
      requestType = com.gitlab.techschool.pcbook.pb.CreateLaptopRequest.class,
      responseType = com.gitlab.techschool.pcbook.pb.CreateLaptopResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gitlab.techschool.pcbook.pb.CreateLaptopRequest,
      com.gitlab.techschool.pcbook.pb.CreateLaptopResponse> getCreateLaptopMethod() {
    io.grpc.MethodDescriptor<com.gitlab.techschool.pcbook.pb.CreateLaptopRequest, com.gitlab.techschool.pcbook.pb.CreateLaptopResponse> getCreateLaptopMethod;
    if ((getCreateLaptopMethod = LaptopServiceGrpc.getCreateLaptopMethod) == null) {
      synchronized (LaptopServiceGrpc.class) {
        if ((getCreateLaptopMethod = LaptopServiceGrpc.getCreateLaptopMethod) == null) {
          LaptopServiceGrpc.getCreateLaptopMethod = getCreateLaptopMethod =
              io.grpc.MethodDescriptor.<com.gitlab.techschool.pcbook.pb.CreateLaptopRequest, com.gitlab.techschool.pcbook.pb.CreateLaptopResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateLaptop"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gitlab.techschool.pcbook.pb.CreateLaptopRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gitlab.techschool.pcbook.pb.CreateLaptopResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LaptopServiceMethodDescriptorSupplier("CreateLaptop"))
              .build();
        }
      }
    }
    return getCreateLaptopMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gitlab.techschool.pcbook.pb.SearchLaptopRequest,
      com.gitlab.techschool.pcbook.pb.SearchLaptopResponse> getSearchLaptopMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchLaptop",
      requestType = com.gitlab.techschool.pcbook.pb.SearchLaptopRequest.class,
      responseType = com.gitlab.techschool.pcbook.pb.SearchLaptopResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.gitlab.techschool.pcbook.pb.SearchLaptopRequest,
      com.gitlab.techschool.pcbook.pb.SearchLaptopResponse> getSearchLaptopMethod() {
    io.grpc.MethodDescriptor<com.gitlab.techschool.pcbook.pb.SearchLaptopRequest, com.gitlab.techschool.pcbook.pb.SearchLaptopResponse> getSearchLaptopMethod;
    if ((getSearchLaptopMethod = LaptopServiceGrpc.getSearchLaptopMethod) == null) {
      synchronized (LaptopServiceGrpc.class) {
        if ((getSearchLaptopMethod = LaptopServiceGrpc.getSearchLaptopMethod) == null) {
          LaptopServiceGrpc.getSearchLaptopMethod = getSearchLaptopMethod =
              io.grpc.MethodDescriptor.<com.gitlab.techschool.pcbook.pb.SearchLaptopRequest, com.gitlab.techschool.pcbook.pb.SearchLaptopResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchLaptop"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gitlab.techschool.pcbook.pb.SearchLaptopRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gitlab.techschool.pcbook.pb.SearchLaptopResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LaptopServiceMethodDescriptorSupplier("SearchLaptop"))
              .build();
        }
      }
    }
    return getSearchLaptopMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gitlab.techschool.pcbook.pb.UploadImageRequest,
      com.gitlab.techschool.pcbook.pb.UploadImageResponse> getUploadImageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UploadImage",
      requestType = com.gitlab.techschool.pcbook.pb.UploadImageRequest.class,
      responseType = com.gitlab.techschool.pcbook.pb.UploadImageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.gitlab.techschool.pcbook.pb.UploadImageRequest,
      com.gitlab.techschool.pcbook.pb.UploadImageResponse> getUploadImageMethod() {
    io.grpc.MethodDescriptor<com.gitlab.techschool.pcbook.pb.UploadImageRequest, com.gitlab.techschool.pcbook.pb.UploadImageResponse> getUploadImageMethod;
    if ((getUploadImageMethod = LaptopServiceGrpc.getUploadImageMethod) == null) {
      synchronized (LaptopServiceGrpc.class) {
        if ((getUploadImageMethod = LaptopServiceGrpc.getUploadImageMethod) == null) {
          LaptopServiceGrpc.getUploadImageMethod = getUploadImageMethod =
              io.grpc.MethodDescriptor.<com.gitlab.techschool.pcbook.pb.UploadImageRequest, com.gitlab.techschool.pcbook.pb.UploadImageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UploadImage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gitlab.techschool.pcbook.pb.UploadImageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gitlab.techschool.pcbook.pb.UploadImageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LaptopServiceMethodDescriptorSupplier("UploadImage"))
              .build();
        }
      }
    }
    return getUploadImageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gitlab.techschool.pcbook.pb.RateLaptopRequest,
      com.gitlab.techschool.pcbook.pb.RateLaptopResponse> getRateLaptopMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RateLaptop",
      requestType = com.gitlab.techschool.pcbook.pb.RateLaptopRequest.class,
      responseType = com.gitlab.techschool.pcbook.pb.RateLaptopResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.gitlab.techschool.pcbook.pb.RateLaptopRequest,
      com.gitlab.techschool.pcbook.pb.RateLaptopResponse> getRateLaptopMethod() {
    io.grpc.MethodDescriptor<com.gitlab.techschool.pcbook.pb.RateLaptopRequest, com.gitlab.techschool.pcbook.pb.RateLaptopResponse> getRateLaptopMethod;
    if ((getRateLaptopMethod = LaptopServiceGrpc.getRateLaptopMethod) == null) {
      synchronized (LaptopServiceGrpc.class) {
        if ((getRateLaptopMethod = LaptopServiceGrpc.getRateLaptopMethod) == null) {
          LaptopServiceGrpc.getRateLaptopMethod = getRateLaptopMethod =
              io.grpc.MethodDescriptor.<com.gitlab.techschool.pcbook.pb.RateLaptopRequest, com.gitlab.techschool.pcbook.pb.RateLaptopResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RateLaptop"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gitlab.techschool.pcbook.pb.RateLaptopRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gitlab.techschool.pcbook.pb.RateLaptopResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LaptopServiceMethodDescriptorSupplier("RateLaptop"))
              .build();
        }
      }
    }
    return getRateLaptopMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LaptopServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LaptopServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LaptopServiceStub>() {
        @java.lang.Override
        public LaptopServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LaptopServiceStub(channel, callOptions);
        }
      };
    return LaptopServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LaptopServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LaptopServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LaptopServiceBlockingStub>() {
        @java.lang.Override
        public LaptopServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LaptopServiceBlockingStub(channel, callOptions);
        }
      };
    return LaptopServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LaptopServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LaptopServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LaptopServiceFutureStub>() {
        @java.lang.Override
        public LaptopServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LaptopServiceFutureStub(channel, callOptions);
        }
      };
    return LaptopServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class LaptopServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createLaptop(com.gitlab.techschool.pcbook.pb.CreateLaptopRequest request,
        io.grpc.stub.StreamObserver<com.gitlab.techschool.pcbook.pb.CreateLaptopResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateLaptopMethod(), responseObserver);
    }

    /**
     */
    public void searchLaptop(com.gitlab.techschool.pcbook.pb.SearchLaptopRequest request,
        io.grpc.stub.StreamObserver<com.gitlab.techschool.pcbook.pb.SearchLaptopResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchLaptopMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.gitlab.techschool.pcbook.pb.UploadImageRequest> uploadImage(
        io.grpc.stub.StreamObserver<com.gitlab.techschool.pcbook.pb.UploadImageResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getUploadImageMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.gitlab.techschool.pcbook.pb.RateLaptopRequest> rateLaptop(
        io.grpc.stub.StreamObserver<com.gitlab.techschool.pcbook.pb.RateLaptopResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getRateLaptopMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateLaptopMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.gitlab.techschool.pcbook.pb.CreateLaptopRequest,
                com.gitlab.techschool.pcbook.pb.CreateLaptopResponse>(
                  this, METHODID_CREATE_LAPTOP)))
          .addMethod(
            getSearchLaptopMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.gitlab.techschool.pcbook.pb.SearchLaptopRequest,
                com.gitlab.techschool.pcbook.pb.SearchLaptopResponse>(
                  this, METHODID_SEARCH_LAPTOP)))
          .addMethod(
            getUploadImageMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                com.gitlab.techschool.pcbook.pb.UploadImageRequest,
                com.gitlab.techschool.pcbook.pb.UploadImageResponse>(
                  this, METHODID_UPLOAD_IMAGE)))
          .addMethod(
            getRateLaptopMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.gitlab.techschool.pcbook.pb.RateLaptopRequest,
                com.gitlab.techschool.pcbook.pb.RateLaptopResponse>(
                  this, METHODID_RATE_LAPTOP)))
          .build();
    }
  }

  /**
   */
  public static final class LaptopServiceStub extends io.grpc.stub.AbstractAsyncStub<LaptopServiceStub> {
    private LaptopServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LaptopServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LaptopServiceStub(channel, callOptions);
    }

    /**
     */
    public void createLaptop(com.gitlab.techschool.pcbook.pb.CreateLaptopRequest request,
        io.grpc.stub.StreamObserver<com.gitlab.techschool.pcbook.pb.CreateLaptopResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateLaptopMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchLaptop(com.gitlab.techschool.pcbook.pb.SearchLaptopRequest request,
        io.grpc.stub.StreamObserver<com.gitlab.techschool.pcbook.pb.SearchLaptopResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSearchLaptopMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.gitlab.techschool.pcbook.pb.UploadImageRequest> uploadImage(
        io.grpc.stub.StreamObserver<com.gitlab.techschool.pcbook.pb.UploadImageResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getUploadImageMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.gitlab.techschool.pcbook.pb.RateLaptopRequest> rateLaptop(
        io.grpc.stub.StreamObserver<com.gitlab.techschool.pcbook.pb.RateLaptopResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getRateLaptopMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class LaptopServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<LaptopServiceBlockingStub> {
    private LaptopServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LaptopServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LaptopServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.gitlab.techschool.pcbook.pb.CreateLaptopResponse createLaptop(com.gitlab.techschool.pcbook.pb.CreateLaptopRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateLaptopMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.gitlab.techschool.pcbook.pb.SearchLaptopResponse> searchLaptop(
        com.gitlab.techschool.pcbook.pb.SearchLaptopRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSearchLaptopMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LaptopServiceFutureStub extends io.grpc.stub.AbstractFutureStub<LaptopServiceFutureStub> {
    private LaptopServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LaptopServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LaptopServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gitlab.techschool.pcbook.pb.CreateLaptopResponse> createLaptop(
        com.gitlab.techschool.pcbook.pb.CreateLaptopRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateLaptopMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_LAPTOP = 0;
  private static final int METHODID_SEARCH_LAPTOP = 1;
  private static final int METHODID_UPLOAD_IMAGE = 2;
  private static final int METHODID_RATE_LAPTOP = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LaptopServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LaptopServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_LAPTOP:
          serviceImpl.createLaptop((com.gitlab.techschool.pcbook.pb.CreateLaptopRequest) request,
              (io.grpc.stub.StreamObserver<com.gitlab.techschool.pcbook.pb.CreateLaptopResponse>) responseObserver);
          break;
        case METHODID_SEARCH_LAPTOP:
          serviceImpl.searchLaptop((com.gitlab.techschool.pcbook.pb.SearchLaptopRequest) request,
              (io.grpc.stub.StreamObserver<com.gitlab.techschool.pcbook.pb.SearchLaptopResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPLOAD_IMAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.uploadImage(
              (io.grpc.stub.StreamObserver<com.gitlab.techschool.pcbook.pb.UploadImageResponse>) responseObserver);
        case METHODID_RATE_LAPTOP:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.rateLaptop(
              (io.grpc.stub.StreamObserver<com.gitlab.techschool.pcbook.pb.RateLaptopResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LaptopServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LaptopServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.gitlab.techschool.pcbook.pb.LaptopServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LaptopService");
    }
  }

  private static final class LaptopServiceFileDescriptorSupplier
      extends LaptopServiceBaseDescriptorSupplier {
    LaptopServiceFileDescriptorSupplier() {}
  }

  private static final class LaptopServiceMethodDescriptorSupplier
      extends LaptopServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LaptopServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LaptopServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LaptopServiceFileDescriptorSupplier())
              .addMethod(getCreateLaptopMethod())
              .addMethod(getSearchLaptopMethod())
              .addMethod(getUploadImageMethod())
              .addMethod(getRateLaptopMethod())
              .build();
        }
      }
    }
    return result;
  }
}

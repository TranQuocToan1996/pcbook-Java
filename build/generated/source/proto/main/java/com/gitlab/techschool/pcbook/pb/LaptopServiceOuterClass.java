// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: laptop_service.proto

package com.gitlab.techschool.pcbook.pb;

public final class LaptopServiceOuterClass {
  private LaptopServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pb_CreateLaptopRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pb_CreateLaptopRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pb_CreateLaptopResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pb_CreateLaptopResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pb_SearchLaptopRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pb_SearchLaptopRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pb_SearchLaptopResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pb_SearchLaptopResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024laptop_service.proto\022\002pb\032\024laptop_messa" +
      "ge.proto\032\024filter_message.proto\"1\n\023Create" +
      "LaptopRequest\022\032\n\006laptop\030\001 \001(\0132\n.pb.Lapto" +
      "p\"\"\n\024CreateLaptopResponse\022\n\n\002id\030\001 \001(\t\"1\n" +
      "\023SearchLaptopRequest\022\032\n\006filter\030\001 \001(\0132\n.p" +
      "b.Filter\"2\n\024SearchLaptopResponse\022\032\n\006lapt" +
      "op\030\001 \001(\0132\n.pb.Laptop2\233\001\n\rLaptopService\022C" +
      "\n\014CreateLaptop\022\027.pb.CreateLaptopRequest\032" +
      "\030.pb.CreateLaptopResponse\"\000\022E\n\014SearchLap" +
      "top\022\027.pb.SearchLaptopRequest\032\030.pb.Search" +
      "LaptopResponse\"\0000\001BC\n\037com.gitlab.techsch" +
      "ool.pcbook.pbP\001Z\036github.com/TranQuocToan" +
      "1996/pbb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.gitlab.techschool.pcbook.pb.LaptopMessage.getDescriptor(),
          com.gitlab.techschool.pcbook.pb.FilterMessage.getDescriptor(),
        });
    internal_static_pb_CreateLaptopRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_pb_CreateLaptopRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pb_CreateLaptopRequest_descriptor,
        new java.lang.String[] { "Laptop", });
    internal_static_pb_CreateLaptopResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_pb_CreateLaptopResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pb_CreateLaptopResponse_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_pb_SearchLaptopRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_pb_SearchLaptopRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pb_SearchLaptopRequest_descriptor,
        new java.lang.String[] { "Filter", });
    internal_static_pb_SearchLaptopResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_pb_SearchLaptopResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pb_SearchLaptopResponse_descriptor,
        new java.lang.String[] { "Laptop", });
    com.gitlab.techschool.pcbook.pb.LaptopMessage.getDescriptor();
    com.gitlab.techschool.pcbook.pb.FilterMessage.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}

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
    internal_static_techschool_pcbook_CreateLaptopRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_techschool_pcbook_CreateLaptopRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_techschool_pcbook_CreateLaptopResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_techschool_pcbook_CreateLaptopResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024laptop_service.proto\022\021techschool.pcboo" +
      "k\032\024laptop_message.proto\"@\n\023CreateLaptopR" +
      "equest\022)\n\006laptop\030\001 \001(\0132\031.techschool.pcbo" +
      "ok.Laptop\"\"\n\024CreateLaptopResponse\022\n\n\002id\030" +
      "\001 \001(\t2r\n\rLaptopService\022a\n\014CreateLaptop\022&" +
      ".techschool.pcbook.CreateLaptopRequest\032\'" +
      ".techschool.pcbook.CreateLaptopResponse\"" +
      "\000B\'\n\037com.gitlab.techschool.pcbook.pbP\001Z\002" +
      "pbb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.gitlab.techschool.pcbook.pb.LaptopMessage.getDescriptor(),
        });
    internal_static_techschool_pcbook_CreateLaptopRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_techschool_pcbook_CreateLaptopRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_techschool_pcbook_CreateLaptopRequest_descriptor,
        new java.lang.String[] { "Laptop", });
    internal_static_techschool_pcbook_CreateLaptopResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_techschool_pcbook_CreateLaptopResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_techschool_pcbook_CreateLaptopResponse_descriptor,
        new java.lang.String[] { "Id", });
    com.gitlab.techschool.pcbook.pb.LaptopMessage.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
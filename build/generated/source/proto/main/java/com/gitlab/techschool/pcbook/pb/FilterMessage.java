// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: filter_message.proto

package com.gitlab.techschool.pcbook.pb;

public final class FilterMessage {
  private FilterMessage() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pb_Filter_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pb_Filter_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024filter_message.proto\022\002pb\032\024memory_messa" +
      "ge.proto\"h\n\006Filter\022\025\n\rmax_price_usd\030\001 \001(" +
      "\001\022\025\n\rmin_cpu_cores\030\002 \001(\r\022\023\n\013min_cpu_ghz\030" +
      "\003 \001(\001\022\033\n\007min_ram\030\004 \001(\0132\n.pb.MemoryBC\n\037co" +
      "m.gitlab.techschool.pcbook.pbP\001Z\036github." +
      "com/TranQuocToan1996/pbb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.gitlab.techschool.pcbook.pb.MemoryMessage.getDescriptor(),
        });
    internal_static_pb_Filter_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_pb_Filter_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pb_Filter_descriptor,
        new java.lang.String[] { "MaxPriceUsd", "MinCpuCores", "MinCpuGhz", "MinRam", });
    com.gitlab.techschool.pcbook.pb.MemoryMessage.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}

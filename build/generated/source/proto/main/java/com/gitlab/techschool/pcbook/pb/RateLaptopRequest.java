// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: laptop_service.proto

package com.gitlab.techschool.pcbook.pb;

/**
 * Protobuf type {@code pb.RateLaptopRequest}
 */
public final class RateLaptopRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:pb.RateLaptopRequest)
    RateLaptopRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RateLaptopRequest.newBuilder() to construct.
  private RateLaptopRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RateLaptopRequest() {
    laptopId_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RateLaptopRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.gitlab.techschool.pcbook.pb.LaptopServiceOuterClass.internal_static_pb_RateLaptopRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.gitlab.techschool.pcbook.pb.LaptopServiceOuterClass.internal_static_pb_RateLaptopRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.gitlab.techschool.pcbook.pb.RateLaptopRequest.class, com.gitlab.techschool.pcbook.pb.RateLaptopRequest.Builder.class);
  }

  public static final int LAPTOP_ID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object laptopId_ = "";
  /**
   * <code>string laptop_id = 1;</code>
   * @return The laptopId.
   */
  @java.lang.Override
  public java.lang.String getLaptopId() {
    java.lang.Object ref = laptopId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      laptopId_ = s;
      return s;
    }
  }
  /**
   * <code>string laptop_id = 1;</code>
   * @return The bytes for laptopId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getLaptopIdBytes() {
    java.lang.Object ref = laptopId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      laptopId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SCORE_FIELD_NUMBER = 2;
  private double score_ = 0D;
  /**
   * <code>double score = 2;</code>
   * @return The score.
   */
  @java.lang.Override
  public double getScore() {
    return score_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(laptopId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, laptopId_);
    }
    if (java.lang.Double.doubleToRawLongBits(score_) != 0) {
      output.writeDouble(2, score_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(laptopId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, laptopId_);
    }
    if (java.lang.Double.doubleToRawLongBits(score_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, score_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.gitlab.techschool.pcbook.pb.RateLaptopRequest)) {
      return super.equals(obj);
    }
    com.gitlab.techschool.pcbook.pb.RateLaptopRequest other = (com.gitlab.techschool.pcbook.pb.RateLaptopRequest) obj;

    if (!getLaptopId()
        .equals(other.getLaptopId())) return false;
    if (java.lang.Double.doubleToLongBits(getScore())
        != java.lang.Double.doubleToLongBits(
            other.getScore())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + LAPTOP_ID_FIELD_NUMBER;
    hash = (53 * hash) + getLaptopId().hashCode();
    hash = (37 * hash) + SCORE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getScore()));
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.gitlab.techschool.pcbook.pb.RateLaptopRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.gitlab.techschool.pcbook.pb.RateLaptopRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.gitlab.techschool.pcbook.pb.RateLaptopRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.gitlab.techschool.pcbook.pb.RateLaptopRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.gitlab.techschool.pcbook.pb.RateLaptopRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.gitlab.techschool.pcbook.pb.RateLaptopRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.gitlab.techschool.pcbook.pb.RateLaptopRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.gitlab.techschool.pcbook.pb.RateLaptopRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.gitlab.techschool.pcbook.pb.RateLaptopRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.gitlab.techschool.pcbook.pb.RateLaptopRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.gitlab.techschool.pcbook.pb.RateLaptopRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.gitlab.techschool.pcbook.pb.RateLaptopRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.gitlab.techschool.pcbook.pb.RateLaptopRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code pb.RateLaptopRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:pb.RateLaptopRequest)
      com.gitlab.techschool.pcbook.pb.RateLaptopRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.gitlab.techschool.pcbook.pb.LaptopServiceOuterClass.internal_static_pb_RateLaptopRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.gitlab.techschool.pcbook.pb.LaptopServiceOuterClass.internal_static_pb_RateLaptopRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.gitlab.techschool.pcbook.pb.RateLaptopRequest.class, com.gitlab.techschool.pcbook.pb.RateLaptopRequest.Builder.class);
    }

    // Construct using com.gitlab.techschool.pcbook.pb.RateLaptopRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      laptopId_ = "";
      score_ = 0D;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.gitlab.techschool.pcbook.pb.LaptopServiceOuterClass.internal_static_pb_RateLaptopRequest_descriptor;
    }

    @java.lang.Override
    public com.gitlab.techschool.pcbook.pb.RateLaptopRequest getDefaultInstanceForType() {
      return com.gitlab.techschool.pcbook.pb.RateLaptopRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.gitlab.techschool.pcbook.pb.RateLaptopRequest build() {
      com.gitlab.techschool.pcbook.pb.RateLaptopRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.gitlab.techschool.pcbook.pb.RateLaptopRequest buildPartial() {
      com.gitlab.techschool.pcbook.pb.RateLaptopRequest result = new com.gitlab.techschool.pcbook.pb.RateLaptopRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.gitlab.techschool.pcbook.pb.RateLaptopRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.laptopId_ = laptopId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.score_ = score_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.gitlab.techschool.pcbook.pb.RateLaptopRequest) {
        return mergeFrom((com.gitlab.techschool.pcbook.pb.RateLaptopRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.gitlab.techschool.pcbook.pb.RateLaptopRequest other) {
      if (other == com.gitlab.techschool.pcbook.pb.RateLaptopRequest.getDefaultInstance()) return this;
      if (!other.getLaptopId().isEmpty()) {
        laptopId_ = other.laptopId_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.getScore() != 0D) {
        setScore(other.getScore());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              laptopId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 17: {
              score_ = input.readDouble();
              bitField0_ |= 0x00000002;
              break;
            } // case 17
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object laptopId_ = "";
    /**
     * <code>string laptop_id = 1;</code>
     * @return The laptopId.
     */
    public java.lang.String getLaptopId() {
      java.lang.Object ref = laptopId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        laptopId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string laptop_id = 1;</code>
     * @return The bytes for laptopId.
     */
    public com.google.protobuf.ByteString
        getLaptopIdBytes() {
      java.lang.Object ref = laptopId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        laptopId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string laptop_id = 1;</code>
     * @param value The laptopId to set.
     * @return This builder for chaining.
     */
    public Builder setLaptopId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      laptopId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string laptop_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearLaptopId() {
      laptopId_ = getDefaultInstance().getLaptopId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string laptop_id = 1;</code>
     * @param value The bytes for laptopId to set.
     * @return This builder for chaining.
     */
    public Builder setLaptopIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      laptopId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private double score_ ;
    /**
     * <code>double score = 2;</code>
     * @return The score.
     */
    @java.lang.Override
    public double getScore() {
      return score_;
    }
    /**
     * <code>double score = 2;</code>
     * @param value The score to set.
     * @return This builder for chaining.
     */
    public Builder setScore(double value) {
      
      score_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>double score = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearScore() {
      bitField0_ = (bitField0_ & ~0x00000002);
      score_ = 0D;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:pb.RateLaptopRequest)
  }

  // @@protoc_insertion_point(class_scope:pb.RateLaptopRequest)
  private static final com.gitlab.techschool.pcbook.pb.RateLaptopRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.gitlab.techschool.pcbook.pb.RateLaptopRequest();
  }

  public static com.gitlab.techschool.pcbook.pb.RateLaptopRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RateLaptopRequest>
      PARSER = new com.google.protobuf.AbstractParser<RateLaptopRequest>() {
    @java.lang.Override
    public RateLaptopRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<RateLaptopRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RateLaptopRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.gitlab.techschool.pcbook.pb.RateLaptopRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


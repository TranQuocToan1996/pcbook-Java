// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: screen_message.proto

package com.gitlab.techschool.pcbook.pb;

public interface ScreenOrBuilder extends
    // @@protoc_insertion_point(interface_extends:pb.Screen)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>float size_inch = 1;</code>
   * @return The sizeInch.
   */
  float getSizeInch();

  /**
   * <code>.pb.Screen.Resolution resolution = 2;</code>
   * @return Whether the resolution field is set.
   */
  boolean hasResolution();
  /**
   * <code>.pb.Screen.Resolution resolution = 2;</code>
   * @return The resolution.
   */
  com.gitlab.techschool.pcbook.pb.Screen.Resolution getResolution();
  /**
   * <code>.pb.Screen.Resolution resolution = 2;</code>
   */
  com.gitlab.techschool.pcbook.pb.Screen.ResolutionOrBuilder getResolutionOrBuilder();

  /**
   * <code>.pb.Screen.Panel panel = 3;</code>
   * @return The enum numeric value on the wire for panel.
   */
  int getPanelValue();
  /**
   * <code>.pb.Screen.Panel panel = 3;</code>
   * @return The panel.
   */
  com.gitlab.techschool.pcbook.pb.Screen.Panel getPanel();

  /**
   * <code>bool multitouch = 4;</code>
   * @return The multitouch.
   */
  boolean getMultitouch();
}

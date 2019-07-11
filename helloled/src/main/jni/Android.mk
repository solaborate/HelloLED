# TOP_PATH refers to the project root dir
TOP_PATH := $(call my-dir)
APP_ABI := x86 x86_64 armeabi-v7a arm64-v8a
# Build  "LED controller" library
include $(CLEAR_VARS)
LOCAL_PATH := $(TOP_PATH)/leds
LOCAL_MODULE    := LedsJNI
LOCAL_SRC_FILES := LedsJNI.cpp
LOCAL_C_INCLUDES := $(LOCAL_PATH)
include $(BUILD_SHARED_LIBRARY)

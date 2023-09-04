LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

$(call import-add-path,$(LOCAL_PATH))

LOCAL_MODULE    := hello-jni
LOCAL_SRC_FILES := hello-jni.cpp

include $(BUILD_SHARED_LIBRARY)

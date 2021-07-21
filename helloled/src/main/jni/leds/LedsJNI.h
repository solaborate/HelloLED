#include <jni.h>
//#include <JNIHelp.h>
#ifndef _Included_com_android_LedsFrameDate
#define _Included_com_android_LedsFrameDate
#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT void JNICALL Java_com_solaborate_helloled_LedsFrameData_writeArray(JNIEnv *, jclass , jbyteArray, jint, jstring);
JNIEXPORT void JNICALL Java_com_solaborate_helloled_LedsFrameData_writeDirect(JNIEnv *, jclass, jobject, jint, jstring);
#ifdef __cplusplus
}
#endif
#endif

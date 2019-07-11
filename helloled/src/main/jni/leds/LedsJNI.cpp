#include <jni.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>//for open
#include <termios.h>
#include <unistd.h>
#include "LedsJNI.h"
#include <stdlib.h> // pulls in declaration of malloc, free

void Java_com_solaborate_helloled_LedsFrameData_writeArray(JNIEnv *env, jobject clazz, jbyteArray buffer, jint length)
{
    int fd, i;
    const char *filename = "/dev/leds_3731";

    //ALOGD("[zhg]--android_hardware_WellDoLedsFrame_SetCard-----,card = %s, count = %d", card, count);

    fd = open(filename, O_WRONLY);
    if (fd < 0)
    {
        //ALOGD(" zhg++ error, can't open %s\n", filename);
        printf("zhg++, writeArray open dev err\n");
        return ;
    }

    jbyte* buf = (jbyte *)malloc(length);
    if (!buf) {
        //   jniThrowException(env, "java/lang/OutOfMemoryError", NULL);
        return;
    }
    env->GetByteArrayRegion(buffer, 0, length, buf);
    //for (i = 0; i < length ; i++){
    //	ALOGD("[zhg]--%s,buf[%d] = 0x%x", __func__, i, *(buf+i));
    //}

    jint ret = write(fd, buf, length);
    free(buf);
    //if (ret < 0)
    //    jniThrowException(env, "java/io/IOException", NULL);
    close(fd);
}

void Java_com_solaborate_helloled_LedsFrameData_writeDirect(JNIEnv *env, jobject clazz, jobject buffer, jint length)
{
    int fd, i;
    const char *filename = "/dev/leds_3731";

    //ALOGD("[zhg]--android_hardware_WellDoLedsFrame_SetCard-----,card = %s, count = %d", card, count);

    fd = open(filename, O_WRONLY);
    if (fd < 0)
    {
        //ALOGD(" zhg++ error, can't open %s\n", filename);
        printf("zhg++, writeDirect open dev err\n");
        return ;
    }

    jbyte* buf = (jbyte *)env->GetDirectBufferAddress(buffer);
    if (!buf) {
        //jniThrowException(env, "java/lang/IllegalArgumentException", "ByteBuffer not direct");
        return;
    }
    int ret = write(fd, buf, length);
    free(buf);
    //if (ret < 0)
    //    jniThrowException(env, "java/io/IOException", NULL);
    close(fd);
}


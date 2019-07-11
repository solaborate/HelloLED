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

    fd = open(filename, O_WRONLY);
    if (fd < 0)
    {
        printf("HelloLED++, writeArray open dev err\n");
        return ;
    }

    jbyte* buf = (jbyte *)malloc(length);
    if (!buf) {
        return;
    }
    env->GetByteArrayRegion(buffer, 0, length, buf);

    jint ret = write(fd, buf, length);
    free(buf);
    close(fd);
}

void Java_com_solaborate_helloled_LedsFrameData_writeDirect(JNIEnv *env, jobject clazz, jobject buffer, jint length)
{
    int fd, i;
    const char *filename = "/dev/leds_3731";

    fd = open(filename, O_WRONLY);
    if (fd < 0)
    {
        printf("HelloLED++, writeDirect open dev err\n");
        return ;
    }

    jbyte* buf = (jbyte *)env->GetDirectBufferAddress(buffer);
    if (!buf) {
        return;
    }
    int ret = write(fd, buf, length);
    free(buf);
    close(fd);
}

#include "com_itay_wrapper_memory_Memory.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

JNIEXPORT jobject JNICALL Java_com_itay_wrapper_memory_Memory_mallocJni
(JNIEnv *env, jclass clz, jint numBytes) {
	char* ptr = (char*)malloc(numBytes);
	if (ptr == 0) return 0;
	return env->NewDirectByteBuffer(ptr, numBytes);
}

JNIEXPORT void JNICALL Java_com_itay_wrapper_memory_Memory_free
(JNIEnv *env, jclass clz, jobject obj_buffer) {
	unsigned char* buffer = (unsigned char*)(obj_buffer ? env->GetDirectBufferAddress(obj_buffer) : 0);
	free(buffer);
}

JNIEXPORT jlong JNICALL Java_com_itay_wrapper_memory_Memory_getBufferAddress
(JNIEnv *env, jclass cls, jobject obj_buffer) {
	unsigned char* buffer = (unsigned char*)(obj_buffer ? env->GetDirectBufferAddress(obj_buffer) : 0);
	jlong JNI_returnValue = (jlong)buffer;
	return JNI_returnValue;
}
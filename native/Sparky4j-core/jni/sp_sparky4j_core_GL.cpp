#include <GLEW\glew.h>
#include "sp_sparky4j_core_GL.h"

JNIEXPORT void JNICALL Java_sp_sparky4j_core_GL_glActiveTexture
(JNIEnv *env, jclass obj, jint texture) {
	glActiveTexture(texture);
}


JNIEXPORT void JNICALL Java_sp_sparky4j_core_GL_glBegin
(JNIEnv *env, jclass obj, jint mode) {
	glBegin(mode);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_GL_glClearColor
(JNIEnv *env, jclass obj, jfloat r, jfloat g, jfloat b, jfloat a) {
	glClearColor(r, g, b, a);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_GL_glEnd
(JNIEnv *env, jclass obj) {
	glEnd();
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_GL_glVertex2f
(JNIEnv *env, jclass obj, jfloat x, jfloat y) {
	glVertex2f(x, y);
}

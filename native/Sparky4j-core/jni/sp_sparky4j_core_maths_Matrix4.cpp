#include "sp_sparky4j_core_maths_Matrix4.h"
#include "../src/maths/mat4.h"
#include <iostream>
#include "handle.h"

using namespace sparky::maths;

static jobject createMatrixObject(JNIEnv* env) {
	jclass cls = env->FindClass("sp/sparky4j/core/maths/Matrix4");
	jmethodID constructor = env->GetMethodID(cls, "<init>", "()V");
	jobject result = env->NewObject(cls, constructor);
	return result;
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_maths_Matrix4_bind__
(JNIEnv *env, jobject obj) {
	mat4* mat = new mat4();
	setHandle(env, obj, mat);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_maths_Matrix4_bind__F
(JNIEnv *env, jobject obj, jfloat diagnol) {
	mat4* mat = new mat4(diagnol);
	setHandle(env, obj, mat);
}

JNIEXPORT jobject JNICALL Java_sp_sparky4j_core_maths_Matrix4_multiply
(JNIEnv *env, jobject obj, jobject other) {
	mat4* mat = getHandle<mat4>(env, obj);
	mat4* otherMat = getHandle<mat4>(env, other);
	mat->multiply(*otherMat);
	return obj;
}

JNIEXPORT jfloat JNICALL Java_sp_sparky4j_core_maths_Matrix4_elements__I
(JNIEnv *env, jobject obj, jint index) {
	mat4* mat = getHandle<mat4>(env, obj);
	return mat->elements[index];
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_maths_Matrix4_elements__IF
(JNIEnv *env, jobject obj, jint index, jfloat value) {
	mat4* mat = getHandle<mat4>(env, obj);
	mat->elements[index] = value;
}

JNIEXPORT jobject JNICALL Java_sp_sparky4j_core_maths_Matrix4_getColumn
(JNIEnv *env, jobject obj, jint index) {
	mat4* mat = getHandle<mat4>(env, obj);
	vec4 vec = mat->getColumn(index);
	jclass cls = env->FindClass("sp/sparky4j/core/maths/Vector4");
	jmethodID constructor = env->GetMethodID(cls, "<init>", "(FFFF)V");
	jobject result = env->NewObject(cls, constructor, vec.x, vec.y, vec.z, vec.w);
	return result;
}

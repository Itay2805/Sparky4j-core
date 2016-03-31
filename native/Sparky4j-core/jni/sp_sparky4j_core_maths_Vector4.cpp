#include "sp_sparky4j_core_maths_Vector4.h"
#include "../src/maths/vec4.h"
#include "handle.h"

using namespace sparky::maths;

JNIEXPORT void JNICALL Java_sp_sparky4j_core_maths_Vector4_bind
(JNIEnv *env, jobject obj, jfloat x, jfloat y, jfloat z, jfloat w) {
	vec4* vec = new vec4(x, y, z, w);
	setHandle(env, obj, vec);
}

JNIEXPORT jobject JNICALL Java_sp_sparky4j_core_maths_Vector4_add
(JNIEnv *env, jobject obj, jobject other) {
	vec4 *vec = getHandle<vec4>(env, obj);
	vec4 *otherVec = getHandle<vec4>(env, other);
	vec->add(*otherVec);
	return obj;
}

JNIEXPORT jobject JNICALL Java_sp_sparky4j_core_maths_Vector4_subtract
(JNIEnv *env, jobject obj, jobject other) {
	vec4 *vec = getHandle<vec4>(env, obj);
	vec4 *otherVec = getHandle<vec4>(env, other);
	vec->subtract(*otherVec);
	return obj;
}

JNIEXPORT jobject JNICALL Java_sp_sparky4j_core_maths_Vector4_multiply
(JNIEnv *env, jobject obj, jobject other) {
	vec4 *vec = getHandle<vec4>(env, obj);
	vec4 *otherVec = getHandle<vec4>(env, other);
	vec->multiply(*otherVec);
	return obj;
}

JNIEXPORT jobject JNICALL Java_sp_sparky4j_core_maths_Vector4_divide
(JNIEnv *env, jobject obj, jobject other) {
	vec4 *vec = getHandle<vec4>(env, obj);
	vec4 *otherVec = getHandle<vec4>(env, other);
	vec->divide(*otherVec);
	return obj;
}

JNIEXPORT jfloat JNICALL Java_sp_sparky4j_core_maths_Vector4_x__
(JNIEnv *env, jobject obj) {
	vec4 *vec = getHandle<vec4>(env, obj);
	return vec->x;
}

JNIEXPORT jfloat JNICALL Java_sp_sparky4j_core_maths_Vector4_y__
(JNIEnv *env, jobject obj) {
	vec4 *vec = getHandle<vec4>(env, obj);
	return vec->y;
}

JNIEXPORT jfloat JNICALL Java_sp_sparky4j_core_maths_Vector4_z__
(JNIEnv *env, jobject obj) {
	vec4 *vec = getHandle<vec4>(env, obj);
	return vec->z;
}

JNIEXPORT jfloat JNICALL Java_sp_sparky4j_core_maths_Vector4_w__
(JNIEnv *env, jobject obj) {
	vec4 *vec = getHandle<vec4>(env, obj);
	return vec->w;
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_maths_Vector4_x__F
(JNIEnv *env, jobject obj, jfloat x) {
	vec4 *vec = getHandle<vec4>(env, obj);
	vec->x = x;
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_maths_Vector4_y__F
(JNIEnv *env, jobject obj, jfloat y) {
	vec4 *vec = getHandle<vec4>(env, obj);
	vec->y = y;
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_maths_Vector4_z__F
(JNIEnv *env, jobject obj, jfloat z) {
	vec4 *vec = getHandle<vec4>(env, obj);
	vec->z = z;
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_maths_Vector4_w__F
(JNIEnv *env, jobject obj, jfloat w) {
	vec4 *vec = getHandle<vec4>(env, obj);
	vec->w = w;
}
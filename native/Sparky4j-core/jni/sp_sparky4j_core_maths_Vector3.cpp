#include "sp_sparky4j_core_maths_Vector3.h"
#include "../src/maths/vec3.h"
#include "handle.h"

using namespace sparky::maths;

JNIEXPORT void JNICALL Java_sp_sparky4j_core_maths_Vector3_bind
(JNIEnv *env, jobject obj, jfloat x, jfloat y, jfloat z) {
	vec3* vec = new vec3(x, y, z);
	setHandle(env, obj, vec);
}

JNIEXPORT jobject JNICALL Java_sp_sparky4j_core_maths_Vector3_add
(JNIEnv *env, jobject obj, jobject other) {
	vec3* vec = getHandle<vec3>(env, obj);
	vec3* otherVec = getHandle<vec3>(env, other);
	vec->add(*otherVec);
	return obj;
}

JNIEXPORT jobject JNICALL Java_sp_sparky4j_core_maths_Vector3_subtract
(JNIEnv *env, jobject obj, jobject other) {
	vec3* vec = getHandle<vec3>(env, obj);
	vec3* otherVec = getHandle<vec3>(env, other);
	vec->subtract(*otherVec);
	return obj;
}

JNIEXPORT jobject JNICALL Java_sp_sparky4j_core_maths_Vector3_multiply
(JNIEnv *env, jobject obj, jobject other) {
	vec3* vec = getHandle<vec3>(env, obj);
	vec3* otherVec = getHandle<vec3>(env, other);
	vec->multiply(*otherVec);
	return obj;
}

JNIEXPORT jobject JNICALL Java_sp_sparky4j_core_maths_Vector3_divide
(JNIEnv *env, jobject obj, jobject other) {
	vec3* vec = getHandle<vec3>(env, obj);
	vec3* otherVec = getHandle<vec3>(env, other);
	vec->divide(*otherVec);
	return obj;
}

JNIEXPORT jfloat JNICALL Java_sp_sparky4j_core_maths_Vector3_x__
(JNIEnv *env, jobject obj) {
	vec3* vec = getHandle<vec3>(env, obj);
	return vec->x;
}

JNIEXPORT jfloat JNICALL Java_sp_sparky4j_core_maths_Vector3_y__
(JNIEnv *env, jobject obj) {
	vec3* vec = getHandle<vec3>(env, obj);
	return vec->y;
}

JNIEXPORT jfloat JNICALL Java_sp_sparky4j_core_maths_Vector3_z__
(JNIEnv *env, jobject obj) {
	vec3* vec = getHandle<vec3>(env, obj);
	return vec->z;
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_maths_Vector3_x__F
(JNIEnv *env, jobject obj, jfloat x) {
	vec3* vec = getHandle<vec3>(env, obj);
	vec->x = x;
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_maths_Vector3_y__F
(JNIEnv *env, jobject obj, jfloat y) {
	vec3* vec = getHandle<vec3>(env, obj);
	vec->y = y;
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_maths_Vector3_z__F
(JNIEnv *env, jobject obj, jfloat z) {
	vec3* vec = getHandle<vec3>(env, obj);
	vec->z = z;
}

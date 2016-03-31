#include "sp_sparky4j_core_maths_Vector2.h"
#include "../src/maths/vec2.h"
#include "handle.h"

using namespace sparky::maths;

JNIEXPORT void JNICALL Java_sp_sparky4j_core_maths_Vector2_bind
(JNIEnv *env, jobject obj, jfloat x, jfloat y) {
	vec2* vec = new vec2(x, y);
	setHandle(env, obj, vec);
}

JNIEXPORT jobject JNICALL Java_sp_sparky4j_core_maths_Vector2_add
(JNIEnv *env, jobject obj, jobject other) {
	vec2 *vec = getHandle<vec2>(env, obj);
	vec2 *otherVec = getHandle<vec2>(env, other);
	vec->add(*otherVec);
	return obj;
}

JNIEXPORT jobject JNICALL Java_sp_sparky4j_core_maths_Vector2_subtract
(JNIEnv *env, jobject obj, jobject other) {
	vec2 *vec = getHandle<vec2>(env, obj);
	vec2 *otherVec = getHandle<vec2>(env, other);
	vec->subtract(*otherVec);
	return obj;
}

JNIEXPORT jobject JNICALL Java_sp_sparky4j_core_maths_Vector2_multiply
(JNIEnv *env, jobject obj, jobject other) {
	vec2 *vec = getHandle<vec2>(env, obj);
	vec2 *otherVec = getHandle<vec2>(env, other);
	vec->multiply(*otherVec);
	return obj;
}

JNIEXPORT jobject JNICALL Java_sp_sparky4j_core_maths_Vector2_divide
(JNIEnv *env, jobject obj, jobject other) {
	vec2 *vec = getHandle<vec2>(env, obj);
	vec2 *otherVec = getHandle<vec2>(env, other);
	vec->divide(*otherVec);
	return obj;
}

JNIEXPORT jfloat JNICALL Java_sp_sparky4j_core_maths_Vector2_x__
(JNIEnv *env, jobject obj) {
	vec2 *vec = getHandle<vec2>(env, obj);
	return vec->x;
}

JNIEXPORT jfloat JNICALL Java_sp_sparky4j_core_maths_Vector2_y__
(JNIEnv *env, jobject obj) {
	vec2 *vec = getHandle<vec2>(env, obj);
	return vec->y;
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_maths_Vector2_x__F
(JNIEnv *env, jobject obj, jfloat x) {
	vec2 *vec = getHandle<vec2>(env, obj);
	vec->x = x;
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_maths_Vector2_y__F
(JNIEnv *env, jobject obj, jfloat y) {
	vec2 *vec = getHandle<vec2>(env, obj);
	vec->y = y;
}
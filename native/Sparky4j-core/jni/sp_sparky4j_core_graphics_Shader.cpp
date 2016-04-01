#include "sp_sparky4j_core_graphics_Shader.h"
#include "../src/graphics/shader.h"
#include "handle.h"

using namespace sparky::graphics;
using namespace sparky::maths;

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Shader_bind
(JNIEnv *env, jobject obj, jstring vertPath, jstring fragPath) {
	const char* vertPathChars = env->GetStringUTFChars(vertPath, false);
	const char* fragPathChars = env->GetStringUTFChars(fragPath, false);
	Shader* shader = new Shader(vertPathChars, fragPathChars);
	env->ReleaseStringUTFChars(vertPath, vertPathChars);
	env->ReleaseStringUTFChars(fragPath, fragPathChars);
	setHandle(env, obj, shader);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Shader_setUniform1f
(JNIEnv *env, jobject obj, jstring name, jfloat value) {
	Shader* shader = getHandle<Shader>(env, obj);
	shader->setUniform1f(env->GetStringUTFChars(name, false), value);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Shader_setUniform1i
(JNIEnv *env, jobject obj, jstring name, jint value) {
	Shader* shader = getHandle<Shader>(env, obj);
	shader->setUniform1i(env->GetStringUTFChars(name, false), value);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Shader_setUniform2f
(JNIEnv *env, jobject obj, jstring name, jobject vector) {
	Shader* shader = getHandle<Shader>(env, obj);
	vec2* vec = getHandle<vec2>(env, vector);
	shader->setUniform2f(env->GetStringUTFChars(name, false), *vec);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Shader_setUniform3f
(JNIEnv *env, jobject obj, jstring name, jobject vector) {
	Shader* shader = getHandle<Shader>(env, obj);
	vec3* vec = getHandle<vec3>(env, vector);
	shader->setUniform3f(env->GetStringUTFChars(name, false), *vec);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Shader_setUniform4f
(JNIEnv *env, jobject obj, jstring name, jobject vector) {
	Shader* shader = getHandle<Shader>(env, obj);
	vec4* vec = getHandle<vec4>(env, vector);
	shader->setUniform4f(env->GetStringUTFChars(name, false), *vec);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Shader_setUniformMat4
(JNIEnv *env, jobject obj, jstring name, jobject matrix) {
	Shader* shader = getHandle<Shader>(env, obj);
	mat4* mat = getHandle<mat4>(env, matrix);
	shader->setUniformMat4(env->GetStringUTFChars(name, false), *mat);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Shader_enable
(JNIEnv *env, jobject obj) {
	Shader* shader = getHandle<Shader>(env, obj);
	shader->enable();
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Shader_disable
(JNIEnv *env, jobject obj) {
	Shader* shader = getHandle<Shader>(env, obj);
	shader->disable();
}
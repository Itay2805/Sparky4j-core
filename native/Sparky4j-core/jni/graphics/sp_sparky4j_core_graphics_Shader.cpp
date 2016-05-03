#include "sp_sparky4j_core_graphics_Shader.h"
#include "../../src/graphics/shader.h"
#include "../handle.h"

using namespace sparky::graphics;
using namespace sparky::maths;

JNIEXPORT jlong JNICALL Java_sp_sparky4j_core_graphics_Shader_bind
(JNIEnv *env, jclass cls, jstring vertPath, jstring fragPath) {
	const char* vertPathChars = env->GetStringUTFChars(vertPath, JNI_FALSE);
	const char* fragPathChars = env->GetStringUTFChars(fragPath, JNI_FALSE);
	Shader* shader = new Shader(vertPathChars, fragPathChars);
	env->ReleaseStringUTFChars(vertPath, vertPathChars);
	env->ReleaseStringUTFChars(fragPath, fragPathChars);
	return getPointer(shader);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Shader_native_1setUniform1f
(JNIEnv *env, jclass cls, jlong handle, jstring name, jfloat value) {
	Shader* shader = getHandle<Shader>(handle);
	const char* nameChars = env->GetStringUTFChars(name, JNI_FALSE);
	shader->setUniform1f(nameChars, value);
	env->ReleaseStringUTFChars(name, nameChars);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Shader_native_1setUniform1fv
(JNIEnv *env, jclass cls, jlong handle, jstring name, jfloatArray array, jint count) {
	Shader* shader = getHandle<Shader>(handle);
	const char* nameChars = env->GetStringUTFChars(name, JNI_FALSE);
	jfloat* elements = env->GetFloatArrayElements(array, JNI_FALSE);
	shader->setUniform1fv(nameChars, elements, count);
	env->ReleaseFloatArrayElements(array, elements, JNI_FALSE);
	env->ReleaseStringUTFChars(name, nameChars);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Shader_native_1setUniform1i
(JNIEnv *env, jclass cls, jlong handle, jstring name, jint value) {
	Shader* shader = getHandle<Shader>(handle);
	const char* nameChars = env->GetStringUTFChars(name, JNI_FALSE);
	shader->setUniform1i(nameChars, value);
	env->ReleaseStringUTFChars(name, nameChars);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Shader_native_1setUniform1iv
(JNIEnv *env, jclass cls, jlong handle, jstring name, jintArray array, jint count) {
	Shader* shader = getHandle<Shader>(handle);
	const char* nameChars = env->GetStringUTFChars(name, JNI_FALSE);
	jint* elements = env->GetIntArrayElements(array, JNI_FALSE);
	int* data = new int[count];
	for (int i = 0; i < count; i++)
		data[i] = elements[i];
	shader->setUniform1iv(nameChars, data, count);
	env->ReleaseIntArrayElements(array, elements, JNI_FALSE);
	env->ReleaseStringUTFChars(name, nameChars);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Shader_native_1setUniform2f
(JNIEnv *env, jclass cls, jlong handle, jstring name, jfloat x, jfloat y) {
	Shader* shader = getHandle<Shader>(handle);
	const char* nameChars = env->GetStringUTFChars(name, JNI_FALSE);
	shader->setUniform2f(nameChars, vec2(x, y));
	env->ReleaseStringUTFChars(name, nameChars);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Shader_native_1setUniform3f
(JNIEnv *env, jclass cls, jlong handle, jstring name, jfloat x, jfloat y, jfloat z) {
	Shader* shader = getHandle<Shader>(handle);
	const char* nameChars = env->GetStringUTFChars(name, JNI_FALSE);
	shader->setUniform3f(nameChars, vec3(x, y, z));
	env->ReleaseStringUTFChars(name, nameChars);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Shader_native_1setUniform4f
(JNIEnv *env, jclass cls, jlong handle, jstring name, jfloat x, jfloat y, jfloat z, jfloat w) {
	Shader* shader = getHandle<Shader>(handle);
	const char* nameChars = env->GetStringUTFChars(name, JNI_FALSE);
	shader->setUniform4f(nameChars, vec4(x, y, z, w));
	env->ReleaseStringUTFChars(name, nameChars);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Shader_native_1setUniformMat4
(JNIEnv *env, jclass cls, jlong handle, jstring name, jfloatArray elements) {
	Shader* shader = getHandle<Shader>(handle);
	const char* nameChars = env->GetStringUTFChars(name, JNI_FALSE);
	jfloat* elementsData = env->GetFloatArrayElements(elements, JNI_FALSE);
	shader->setUniformMat4(nameChars, mat4(elementsData));
	env->ReleaseFloatArrayElements(elements, elementsData, JNI_FALSE);
	env->ReleaseStringUTFChars(name, nameChars);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Shader_native_1enable
(JNIEnv *env, jclass cls, jlong handle) {
	Shader* shader = getHandle<Shader>(handle);
	shader->enable();
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Shader_native_1disable
(JNIEnv *env, jclass cls, jlong handle) {
	Shader* shader = getHandle<Shader>(handle);
	shader->disable();
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Shader_native_1delete
(JNIEnv *env, jclass cls, jlong handle) {
	Shader* shader = getHandle<Shader>(handle);
	delete shader;
}
#include "sp_graphics_shaders_Shader.h"
#include "../../handle.h"
#include "sp\graphics\shaders\Shader.h"

using namespace sp::graphics;

JNIEXPORT jlong JNICALL Java_sp_graphics_shaders_Shader_bind
(JNIEnv *env, jclass clz, jstring name, jstring source) {
	const char* nameChars = env->GetStringUTFChars(name, JNI_FALSE);
	const char* sourceChars = env->GetStringUTFChars(source, JNI_FALSE);
	String nameStr(nameChars);
	String sourceStr(sourceChars);
	Shader* shader = Shader::FromSource(nameStr, sourceStr);
	env->ReleaseStringUTFChars(name, nameChars);
	env->ReleaseStringUTFChars(source, sourceChars);
	return getPointer(shader);
}

JNIEXPORT void JNICALL Java_sp_graphics_shaders_Shader_native_1setUniform1f
(JNIEnv *env, jclass clz, jlong handler, jstring name, jfloat value) {
	Shader* shader = getHandle<Shader>(handler);
	const char* nameChars = env->GetStringUTFChars(name, JNI_FALSE);
	shader->SetUniform1f(String(nameChars), value);
	env->ReleaseStringUTFChars(name, nameChars);
}

JNIEXPORT void JNICALL Java_sp_graphics_shaders_Shader_native_1setUniform1fv
(JNIEnv *env, jclass clz, jlong handler, jstring name, jfloatArray values, jint count) {
	Shader* shader = getHandle<Shader>(handler);
	const char* nameChars = env->GetStringUTFChars(name, JNI_FALSE);
	jfloat* elements = env->GetFloatArrayElements(values, JNI_FALSE);
	shader->SetUniform1fv(String(nameChars), elements, count);
	env->ReleaseFloatArrayElements(values, elements, JNI_FALSE);
	env->ReleaseStringUTFChars(name, nameChars);
}

JNIEXPORT void JNICALL Java_sp_graphics_shaders_Shader_native_1setUniform1i
(JNIEnv *env, jclass cls, jlong handler, jstring name, jint value) {
	Shader* shader = getHandle<Shader>(handler);
	const char* nameChars = env->GetStringUTFChars(name, JNI_FALSE);
	shader->SetUniform1i(String(nameChars), value);
	env->ReleaseStringUTFChars(name, nameChars);
}

JNIEXPORT void JNICALL Java_sp_graphics_shaders_Shader_native_1setUniform1iv
(JNIEnv *env, jclass cls, jlong handler, jstring name, jintArray values, jint count) {
	Shader* shader = getHandle<Shader>(handler);
	const char* nameChars = env->GetStringUTFChars(name, JNI_FALSE);
	jint* elements = env->GetIntArrayElements(values, JNI_FALSE);
	int* data = new int[count];
	for (int i = 0; i < count; i++)
		data[i] = elements[i];
	shader->SetUniform1iv(String(nameChars), data, count);
	env->ReleaseIntArrayElements(values, elements, JNI_FALSE);
	env->ReleaseStringUTFChars(name, nameChars);
	delete data;
}

JNIEXPORT void JNICALL Java_sp_graphics_shaders_Shader_native_1setUniform2f
(JNIEnv *env, jclass clz, jlong handler, jstring name, jfloat x, jfloat y) {
	Shader* shader = getHandle<Shader>(handler);
	const char* nameChars = env->GetStringUTFChars(name, JNI_FALSE);
	shader->SetUniform2f(String(nameChars), sp::maths::vec2(x, y));
	env->ReleaseStringUTFChars(name, nameChars);
}

JNIEXPORT void JNICALL Java_sp_graphics_shaders_Shader_native_1setUniform3f
(JNIEnv *env, jclass cls, jlong handler, jstring name, jfloat x, jfloat y, jfloat z) {
	Shader* shader = getHandle<Shader>(handler);
	const char* nameChars = env->GetStringUTFChars(name, JNI_FALSE);
	shader->SetUniform3f(String(nameChars), sp::maths::vec3(x, y, z));
	env->ReleaseStringUTFChars(name, nameChars);
}

JNIEXPORT void JNICALL Java_sp_graphics_shaders_Shader_native_1setUniform4f
(JNIEnv *env, jclass cls, jlong handler, jstring name, jfloat x, jfloat y, jfloat z, jfloat w) {
	Shader* shader = getHandle<Shader>(handler);
	const char* nameChars = env->GetStringUTFChars(name, JNI_FALSE);
	shader->SetUniform4f(String(nameChars), sp::maths::vec4(x, y, z, w));
	env->ReleaseStringUTFChars(name, nameChars);
}

JNIEXPORT void JNICALL Java_sp_graphics_shaders_Shader_native_1setUniformMat4
(JNIEnv *env, jclass cls, jlong handler, jstring name, jfloatArray matrix) {
	Shader* shader = getHandle<Shader>(handler);
	const char* nameChars = env->GetStringUTFChars(name, JNI_FALSE);
	jfloat* elements = env->GetFloatArrayElements(matrix, JNI_FALSE);
	sp::maths::mat4* mat = new sp::maths::mat4();
	for (int i = 0; i < 4 * 4; i++)
		mat->elements[i] = elements[i];
	shader->SetUniformMat4(String(nameChars), *mat);
	env->ReleaseFloatArrayElements(matrix, elements, JNI_FALSE);
	env->ReleaseStringUTFChars(name, nameChars);
	delete mat;
}

JNIEXPORT void JNICALL Java_sp_graphics_shaders_Shader_native_1bind
(JNIEnv *env, jclass clz, jlong handler) {
	Shader* shader = getHandle<Shader>(handler);
	shader->Bind();
}

JNIEXPORT void JNICALL Java_sp_graphics_shaders_Shader_native_1unbind
(JNIEnv *env, jclass clz, jlong handler) {
	Shader* shader = getHandle<Shader>(handler);
	shader->Unbind();
}
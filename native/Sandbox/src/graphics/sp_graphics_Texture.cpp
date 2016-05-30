#include "sp_graphics_Texture.h"
#include "../handle.h"
#include "sp\graphics\Texture.h"

using namespace sp::graphics;

JNIEXPORT jlong JNICALL Java_sp_graphics_Texture_bind__III
(JNIEnv *env, jclass cls, jint width, jint height, jint bits) {
	Texture* texture = new Texture(width, height, bits);
	return getPointer(texture);
}

JNIEXPORT jlong JNICALL Java_sp_graphics_Texture_bind__Ljava_lang_String_2
(JNIEnv *env, jclass cls, jstring filepath) {
	const char* filepathChars = env->GetStringUTFChars(filepath, JNI_FALSE);
	Texture* texture = new Texture("", filepathChars);
	env->ReleaseStringUTFChars(filepath, filepathChars);
	return getPointer(texture);
}

JNIEXPORT void JNICALL Java_sp_graphics_Texture_native_1bind
(JNIEnv *env, jclass cls, jlong handler) {
	Texture* texture = getHandle<Texture>(handler);
	texture->Bind();
}

JNIEXPORT void JNICALL Java_sp_graphics_Texture_native_1unbind
(JNIEnv *env, jclass cls, jlong handler) {
	Texture* texture = getHandle<Texture>(handler);
	texture->Unbind();
}

JNIEXPORT jint JNICALL Java_sp_graphics_Texture_native_1getID
(JNIEnv *env, jclass cls, jlong handler) {
	Texture* texture = getHandle<Texture>(handler);
	return texture->GetID();
}

JNIEXPORT jint JNICALL Java_sp_graphics_Texture_native_1getWidth
(JNIEnv *env, jclass cls, jlong handler) {
	Texture* texture = getHandle<Texture>(handler);
	return texture->GetWidth();
}

JNIEXPORT jint JNICALL Java_sp_graphics_Texture_native_1getHeight
(JNIEnv *env, jclass cls, jlong handler) {
	Texture* texture = getHandle<Texture>(handler);
	return texture->GetHeight();
}

JNIEXPORT void JNICALL Java_sp_graphics_Texture_native_1setWrap
(JNIEnv *env, jclass cls, jint mode) {
	Texture::SetWrap((TextureWrap)mode);
}

JNIEXPORT void JNICALL Java_sp_graphics_Texture_native_1setFilter
(JNIEnv *env, jclass cls, jint mode) {
	Texture::SetFilter((TextureFilter)mode);
}
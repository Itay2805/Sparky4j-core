#include "sp_sparky4j_core_graphics_Texture.h"
#include "../../src/graphics/texture.h"
#include "../handle.h"

using namespace sparky::graphics;

JNIEXPORT jlong JNICALL Java_sp_sparky4j_core_graphics_Texture_bind
(JNIEnv *env, jclass cls, jstring filename) {
	const char* filenameChars = env->GetStringUTFChars(filename, JNI_FALSE);
	Texture* texture = new Texture(filenameChars);
	env->ReleaseStringUTFChars(filename, filenameChars);
	return getPointer(texture);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Texture_native_1bind
(JNIEnv *env, jclass cls, jlong handle) {
	Texture* texture = getHandle<Texture>(handle);
	texture->bind();
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Texture_native_1unbind
(JNIEnv *env, jclass cls, jlong handle) {
	Texture* texture = getHandle<Texture>(handle);
	texture->unbind();
}

JNIEXPORT jint JNICALL Java_sp_sparky4j_core_graphics_Texture_native_1getWidth
(JNIEnv *env, jclass cls, jlong handle) {
	Texture* texture = getHandle<Texture>(handle);
	return texture->getWidth();
}

JNIEXPORT jint JNICALL Java_sp_sparky4j_core_graphics_Texture_native_1getHeight
(JNIEnv *env, jclass cls, jlong handle) {
	Texture* texture = getHandle<Texture>(handle);
	return texture->getHeight();
}

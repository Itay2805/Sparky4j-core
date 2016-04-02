#include "sp_sparky4j_core_graphics_Texture.h"
#include "../src/graphics/texture.h"
#include "handle.h"

using namespace sparky::graphics;

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Texture_bind
(JNIEnv *env, jobject obj, jstring str) {
	const char* filename = env->GetStringUTFChars(str, false);
	Texture* texture = new Texture(filename);
	env->ReleaseStringUTFChars(str, filename);
	setHandle(env, obj, texture);
}

JNIEXPORT jint JNICALL Java_sp_sparky4j_core_graphics_Texture_getWidth
(JNIEnv *env, jobject obj) {
	Texture* texture = getHandle<Texture>(env, obj);
	return texture->getWidth();
}

JNIEXPORT jint JNICALL Java_sp_sparky4j_core_graphics_Texture_getHeight
(JNIEnv *env, jobject obj) {
	Texture* texture = getHandle<Texture>(env, obj);
	return texture->getHeight();
}
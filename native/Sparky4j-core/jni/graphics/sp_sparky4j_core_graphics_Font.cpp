#include "sp_sparky4j_core_graphics_Font.h"
#include "../../src/graphics/font.h"
#include "../handle.h"

using namespace sparky::graphics;

JNIEXPORT jlong JNICALL Java_sp_sparky4j_core_graphics_Font_bind
(JNIEnv *env, jclass cls, jstring name, jstring filename, jint size) {
	const char* nameChars = env->GetStringUTFChars(name, NULL);
	const char* filenameChars = env->GetStringUTFChars(filename, NULL);
	Font* font = new Font(nameChars, filenameChars, size);
	env->ReleaseStringUTFChars(name, nameChars);
	env->ReleaseStringUTFChars(filename, filenameChars);
	return getPointer(font);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Font_native_1set_1scale
(JNIEnv *env, jclass clz, jlong handle, jfloat x, jfloat y) {
	Font* font = getHandle<Font>(handle);
	font->setScale(x, y);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Font_native_1delete
(JNIEnv *env, jclass cls, jlong handle) {
	Font* font = getHandle<Font>(handle);
	delete font;
}
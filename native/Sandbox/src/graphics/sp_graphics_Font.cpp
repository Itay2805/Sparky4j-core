#include "sp_graphics_Font.h"
#include "../handle.h"
#include "sp\graphics\Font.h"
#include "sp\utils\Log.h"

using namespace sp::graphics;

JNIEXPORT jlong JNICALL Java_sp_graphics_Font_bind__Ljava_lang_String_2F
(JNIEnv *env, jclass cls, jstring filename, jfloat size) {
	const char* filenameChars = env->GetStringUTFChars(filename, JNI_FALSE);
	Font* font = new Font("", filenameChars, size);
	env->ReleaseStringUTFChars(filename, filenameChars);
	return getPointer(font);
}

JNIEXPORT jlong JNICALL Java_sp_graphics_Font_bind___3BIF
(JNIEnv *env, jclass cls, jbyteArray data, jint datasize, jfloat size) {
	SPARKY_ERROR("This method was not implemented yet. Please load from file instead");
	return -1;
}

JNIEXPORT void JNICALL Java_sp_graphics_Font_native_1setScale
(JNIEnv *env, jclass cls, jlong handler, jfloat x, jfloat y) {
	Font* font = getHandle<Font>(handler);
	font->SetScale(x, y);
}

JNIEXPORT jint JNICALL Java_sp_graphics_Font_native_1getID
(JNIEnv *env, jclass cls, jlong handler) {
	Font* font = getHandle<Font>(handler);
	return font->GetID();
}

JNIEXPORT jint JNICALL Java_sp_graphics_Font_native_1getScaleX
(JNIEnv *env, jclass cls, jlong handler) {
	Font* font = getHandle<Font>(handler);
	return font->GetScale().x;
}

JNIEXPORT jint JNICALL Java_sp_graphics_Font_native_1getScaleY
(JNIEnv *env, jclass cls, jlong handler) {
	Font* font = getHandle<Font>(handler);
	return font->GetScale().y;
}

JNIEXPORT jint JNICALL Java_sp_graphics_Font_native_1getSize
(JNIEnv *env, jclass cls, jlong handler) {
	Font* font = getHandle<Font>(handler);
	return font->GetSize();
}
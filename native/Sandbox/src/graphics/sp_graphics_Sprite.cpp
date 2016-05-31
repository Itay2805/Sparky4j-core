#include "sp_graphics_Sprite.h"
#include "../handle.h"
#include "sp\graphics\Sprite.h"

using namespace sp::graphics;

JNIEXPORT jlong JNICALL Java_sp_graphics_Sprite_bind__FFFFI
(JNIEnv *env, jclass cls, jfloat x, jfloat y, jfloat width, jfloat height, jint color) {
	Sprite* sprite = new Sprite(x, y, width, height, color);
	return getPointer(sprite);
}

JNIEXPORT jlong JNICALL Java_sp_graphics_Sprite_bind__FFFFJ
(JNIEnv *env, jclass cls, jfloat x, jfloat y, jfloat width, jfloat height, jlong texture) {
	Texture* natTexture = getHandle<Texture>(texture);
	Sprite* sprite = new Sprite(x, y, width, height, natTexture);
	return getPointer(sprite);
}

JNIEXPORT void JNICALL Java_sp_graphics_Sprite_native_1setPosition
(JNIEnv *env, jclass cls, jlong handler, jfloat x, jfloat y, jfloat z) {
	Sprite* sprite = getHandle<Sprite>(handler);
	sprite->position.x = x;
	sprite->position.y = y;
	sprite->position.z = z;
}

JNIEXPORT void JNICALL Java_sp_graphics_Sprite_native_1setSize
(JNIEnv *env, jclass cls, jlong handler, jfloat x, jfloat y) {
	Sprite* sprite = getHandle<Sprite>(handler);
	sprite->size.x = x;
	sprite->size.y = y;
}
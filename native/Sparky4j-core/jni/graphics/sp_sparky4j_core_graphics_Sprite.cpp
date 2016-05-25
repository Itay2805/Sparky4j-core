#include "sp_sparky4j_core_graphics_Sprite.h"
#include "../../src/graphics/sprite.h"
#include "../handle.h"

using namespace sparky::graphics;
using namespace sparky::maths;

JNIEXPORT jlong JNICALL Java_sp_sparky4j_core_graphics_Sprite_bind__FFFFI
(JNIEnv *env, jclass cls, jfloat x, jfloat y, jfloat width, jfloat height, jint color) {
	Sprite* sprite = new Sprite(x, y, width, height, color);
	return getPointer(sprite);
}

JNIEXPORT jlong JNICALL Java_sp_sparky4j_core_graphics_Sprite_bind__FFFFJ
(JNIEnv *env, jclass cls, jfloat x, jfloat y, jfloat width, jfloat height, jlong texture) {
	Texture* nativeTexture = getHandle<Texture>(texture);
	Sprite* sprite = new Sprite(x, y, width, height, nativeTexture);
	return getPointer(sprite);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Sprite_native_1set_1position
(JNIEnv *env, jclass clz, jlong handle, jfloat x, jfloat y, jfloat z) {
	Sprite* sprite = getHandle<Sprite>(handle);
	sprite->position.x = x;
	sprite->position.y = y;
	sprite->position.z = z;
}
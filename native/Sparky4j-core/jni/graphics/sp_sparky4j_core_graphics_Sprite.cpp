#include "sp_sparky4j_core_graphics_Sprite.h"
#include "../../src/graphics/sprite.h"
#include "../handle.h"

using namespace sparky::graphics;
using namespace sparky::maths;

JNIEXPORT jlong JNICALL Java_sp_sparky4j_core_graphics_Sprite_bind__FFFFFFFF
(JNIEnv *env, jclass cls, jfloat x, jfloat y, jfloat width, jfloat height, jfloat xColor, jfloat yColor, jfloat zColor, jfloat wColor) {
	Sprite* sprite = new Sprite(x, y, width, height, vec4(xColor, yColor, zColor, wColor));
	return getPointer(sprite);
}

JNIEXPORT jlong JNICALL Java_sp_sparky4j_core_graphics_Sprite_bind__FFFFJ
(JNIEnv *env, jclass cls, jfloat x, jfloat y, jfloat width, jfloat height, jlong texture) {
	Texture* nativeTexture = getHandle<Texture>(texture);
	Sprite* sprite = new Sprite(x, y, width, height, nativeTexture);
	return getPointer(sprite);
}
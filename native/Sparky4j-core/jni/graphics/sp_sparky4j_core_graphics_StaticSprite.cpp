#include "sp_sparky4j_core_graphics_StaticSprite.h"
#include "../../src/graphics/static_sprite.h"
#include "../handle.h"

using namespace sparky::graphics;
using namespace sparky::maths;

JNIEXPORT jlong JNICALL Java_sp_sparky4j_core_graphics_StaticSprite_bind
(JNIEnv *env, jclass cls, jfloat x, jfloat y, jfloat width, jfloat height, jfloat xColor, jfloat yColor, jfloat zColor, jfloat wColor, jlong shader) {
	Shader* nativeShader = getHandle<Shader>(shader);
	StaticSprite* sprite = new StaticSprite(x, y, width, height, vec4(xColor, yColor, zColor, wColor), *nativeShader);
	return getPointer(sprite);
}
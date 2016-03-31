#include "sp_sparky4j_core_graphics_Sprite.h"
#include "../src/graphics/sprite.h"
#include "handle.h"

using namespace sparky::maths;
using namespace sparky::graphics;

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Sprite_bind
(JNIEnv *env, jobject obj, jfloat x, jfloat y, jfloat width, jfloat height, jobject color) {
	vec4* colorVec = getHandle<vec4>(env, color);

	Sprite* sprite = new Sprite(x, y, width, height, *colorVec);
	setHandle(env, obj, sprite);
}
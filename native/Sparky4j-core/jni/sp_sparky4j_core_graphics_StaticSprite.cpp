#include "sp_sparky4j_core_graphics_StaticSprite.h"
#include "../src/graphics/static_sprite.h"
#include "handle.h"

using namespace sparky::maths;
using namespace sparky::graphics;

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_StaticSprite_bind
(JNIEnv *env, jobject obj, jfloat x, jfloat y, jfloat width, jfloat height, jobject color, jobject shader) {
	vec4* colorVec = getHandle<vec4>(env, color);
	Shader* shaderNat = getHandle<Shader>(env, shader);

	StaticSprite* sprite = new StaticSprite(x, y, width, height, *colorVec, *shaderNat);
	setHandle(env, obj, sprite);
}
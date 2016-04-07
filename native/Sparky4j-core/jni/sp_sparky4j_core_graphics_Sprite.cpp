#include "sp_sparky4j_core_graphics_Sprite.h"
#include "../src/graphics/sprite.h"
#include "handle.h"

using namespace sparky::maths;
using namespace sparky::graphics;

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Sprite_bind__FFFFLsp_sparky4j_core_maths_Vector4_2
(JNIEnv *env, jobject obj, jfloat x, jfloat y, jfloat width, jfloat height, jobject color) {
	vec4* colorVec = getHandle<vec4>(env, color);

	Sprite* sprite = new Sprite(x, y, width, height, *colorVec);
	setHandle(env, obj, sprite);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Sprite_bind__FFFFLsp_sparky4j_core_graphics_Texture_2
(JNIEnv *env, jobject obj, jfloat x, jfloat y, jfloat width, jfloat height, jobject texture) {
	Texture* textureNat = getHandle<Texture>(env, texture);

	Sprite* sprite = new Sprite(x, y, width, height, textureNat);
	setHandle(env, obj, sprite);
}
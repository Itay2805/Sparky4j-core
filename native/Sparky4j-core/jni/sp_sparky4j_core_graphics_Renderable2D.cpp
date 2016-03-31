#include "sp_sparky4j_core_graphics_Renderable2D.h"
#include "../src/graphics/renderable2d.h"
#include "handle.h"

using namespace sparky::maths;
using namespace sparky::graphics;

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Renderable2D_bind
(JNIEnv *env, jobject obj, jobject position, jobject size, jobject color, jobject shader) {
	vec3* positionVec = getHandle<vec3>(env, position);
	vec2* sizeVec = getHandle<vec2>(env, size);
	vec4* colorVec = getHandle<vec4>(env, color);
	Shader* shaderNat = getHandle<Shader>(env, shader);

	Renderable2D* renderable = new Renderable2D(*positionVec, *sizeVec, *colorVec, *shaderNat);
	setHandle(env, obj, renderable);
}
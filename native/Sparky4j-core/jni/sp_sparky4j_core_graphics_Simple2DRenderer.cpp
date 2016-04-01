#include "sp_sparky4j_core_graphics_Simple2DRenderer.h"
#include "../src/graphics/simple2drenderer.h"
#include "handle.h"

using namespace sparky::graphics;
using namespace sparky::maths;

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Simple2DRenderer_bind
(JNIEnv *env, jobject obj) {
	Simple2DRenderer* renderer = new Simple2DRenderer();
	setHandle(env, obj, renderer);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Simple2DRenderer_submit
(JNIEnv *env, jobject obj, jobject renderable) {
	Simple2DRenderer* renderer = getHandle<Simple2DRenderer>(env, obj);
	Renderable2D* renderableNat = getHandle<Renderable2D>(env, renderable);
	renderer->submit(renderableNat);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Simple2DRenderer_flush
(JNIEnv *env, jobject obj) {
	Simple2DRenderer* renderer = getHandle<Simple2DRenderer>(env, obj);
	(*renderer).flush();
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Simple2DRenderer_push
(JNIEnv *env, jobject obj, jobject matrix, jboolean override) {
	Simple2DRenderer* renderer = getHandle<Simple2DRenderer>(env, obj);
	mat4* mat = getHandle<mat4>(env, matrix);
	renderer->push(*mat, override);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Simple2DRenderer_pop
(JNIEnv *env, jobject obj) {
	Simple2DRenderer* renderer = getHandle<Simple2DRenderer>(env, obj);
	renderer->pop();
}
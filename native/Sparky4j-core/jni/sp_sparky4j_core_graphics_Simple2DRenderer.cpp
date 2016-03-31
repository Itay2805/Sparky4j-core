#include "sp_sparky4j_core_graphics_Simple2DRenderer.h"
#include "../src/graphics/simple2drenderer.h"
#include "handle.h"

using namespace sparky::graphics;

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Simple2DRenderer_bind
(JNIEnv *env, jobject obj) {
	Simple2DRenderer* renderer = new Simple2DRenderer();
	setHandle(env, obj, renderer);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Simple2DRenderer_nativeSubmit
(JNIEnv *env, jobject obj, jobject renderable) {
	Simple2DRenderer* renderer = getHandle<Simple2DRenderer>(env, obj);
	Renderable2D* renderableNat = getHandle<Renderable2D>(env, renderable);
	renderer->submit(renderableNat);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Simple2DRenderer_nativeFlush
(JNIEnv *env, jobject obj) {
	Simple2DRenderer* renderer = getHandle<Simple2DRenderer>(env, obj);
	(*renderer).flush();
}
#include "sp_sparky4j_core_graphics_BatchRenderer2D.h"
#include "../src/graphics/BatchRenderer2d.h"
#include "handle.h"

using namespace sparky::graphics;

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_bind
(JNIEnv *env, jobject obj) {
	BatchRenderer2D* renderer = new BatchRenderer2D();
	setHandle(env, obj, renderer);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_nativeSubmit
(JNIEnv *env, jobject obj, jobject renderable) {
	BatchRenderer2D* renderer = getHandle<BatchRenderer2D>(env, obj);
	Renderable2D* renderableNat = getHandle<Renderable2D>(env, renderable);

	renderer->submit(renderableNat);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_begin
(JNIEnv *env, jobject obj) {
	BatchRenderer2D* renderer = getHandle<BatchRenderer2D>(env, obj);
	renderer->begin();
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_nativeFlush
(JNIEnv *env, jobject obj) {
	BatchRenderer2D* renderer = getHandle<BatchRenderer2D>(env, obj);
	renderer->flush();
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_end
(JNIEnv *env, jobject obj) {
	BatchRenderer2D* renderer = getHandle<BatchRenderer2D>(env, obj);
	renderer->end();
}
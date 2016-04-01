#include "sp_sparky4j_core_graphics_BatchRenderer2D.h"
#include "../src/graphics/BatchRenderer2d.h"
#include "handle.h"

using namespace sparky::graphics;
using namespace sparky::maths;

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_bind
(JNIEnv *env, jobject obj) {
	BatchRenderer2D* renderer = new BatchRenderer2D();
	setHandle(env, obj, renderer);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_push
(JNIEnv *env, jobject obj, jobject matrix, jboolean override) {
	BatchRenderer2D* renderer = getHandle<BatchRenderer2D>(env, obj);
	mat4* mat = getHandle<mat4>(env, matrix);
	renderer->push(*mat, override);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_pop
(JNIEnv *env, jobject obj) {
	BatchRenderer2D* renderer = getHandle<BatchRenderer2D>(env, obj);
	renderer->pop();
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_submit
(JNIEnv *env, jobject obj, jobject renderable) {
	BatchRenderer2D* renderer = getHandle<BatchRenderer2D>(env, obj);
	Renderable2D* renderableNat = getHandle<Renderable2D>(env, renderable);

	renderer->submit(renderableNat);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_flush
(JNIEnv *env, jobject obj) {
	BatchRenderer2D* renderer = getHandle<BatchRenderer2D>(env, obj);
	renderer->flush();
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_begin
(JNIEnv *env, jobject obj) {
	BatchRenderer2D* renderer = getHandle<BatchRenderer2D>(env, obj);
	renderer->begin();
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_end
(JNIEnv *env, jobject obj) {
	BatchRenderer2D* renderer = getHandle<BatchRenderer2D>(env, obj);
	renderer->end();
}
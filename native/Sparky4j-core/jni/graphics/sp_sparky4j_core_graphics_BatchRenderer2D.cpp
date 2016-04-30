#include "sp_sparky4j_core_graphics_BatchRenderer2D.h"
#include "../../src/graphics/BatchRenderer2d.h"
#include "../handle.h"

using namespace sparky::graphics;
using namespace sparky::maths;

JNIEXPORT jlong JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_bind
(JNIEnv *env, jclass cls) {
	BatchRenderer2D* renderer = new BatchRenderer2D();
	return getPointer(renderer);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_native_1begin
(JNIEnv *env, jclass cls, jlong handle) {
	BatchRenderer2D* renderer = getHandle<BatchRenderer2D>(handle);
	renderer->begin();
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_native_1submit
(JNIEnv *env, jclass cls, jlong handle, jlong renderable) {
	BatchRenderer2D* renderer = getHandle<BatchRenderer2D>(handle);
	Renderable2D* renderableNative = getHandle<Renderable2D>(renderable);
	renderer->submit(renderableNative);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_native_1end
(JNIEnv *env, jclass cls, jlong handle) {
	BatchRenderer2D* renderer = getHandle<BatchRenderer2D>(handle);
	renderer->end();
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_native_1flush
(JNIEnv *env, jclass cls, jlong handle) {
	BatchRenderer2D* renderer = getHandle<BatchRenderer2D>(handle);
	renderer->flush();
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_native_1push
(JNIEnv *env, jclass cls, jlong handle, jfloatArray array, jboolean override) {
	BatchRenderer2D* renderer = getHandle<BatchRenderer2D>(handle);
	float* matrix = env->GetFloatArrayElements(array, JNI_FALSE);
	renderer->push(mat4(matrix), override == JNI_TRUE);
	env->ReleaseFloatArrayElements(array, matrix, JNI_FALSE);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_native_1pop
(JNIEnv *env, jclass cls, jlong handle) {
	BatchRenderer2D* renderer = getHandle<BatchRenderer2D>(handle);
	renderer->pop();
}
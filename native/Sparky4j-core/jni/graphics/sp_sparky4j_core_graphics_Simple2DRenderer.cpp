#include "sp_sparky4j_core_graphics_Simple2DRenderer.h"
#include "../../src/graphics/simple2drenderer.h"
#include "../handle.h"

using namespace sparky::graphics;
using namespace sparky::maths;

JNIEXPORT jlong JNICALL Java_sp_sparky4j_core_graphics_Simple2DRenderer_bind
(JNIEnv *env, jclass cls) {
	Simple2DRenderer* renderer = new Simple2DRenderer();
	return getPointer(renderer);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Simple2DRenderer_native_1submit
(JNIEnv *env, jclass cls, jlong handle, jlong renderable) {
	Simple2DRenderer* renderer = getHandle<Simple2DRenderer>(handle);
	Renderable2D* nativeRenderable = getHandle<Renderable2D>(renderable);
	renderer->submit(nativeRenderable);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Simple2DRenderer_native_1flush
(JNIEnv *env, jclass cls, jlong handle) {
	Simple2DRenderer* renderer = getHandle<Simple2DRenderer>(handle);
	renderer->flush();
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Simple2DRenderer_native_1push
(JNIEnv *env, jclass cls, jlong handle, jfloatArray array, jboolean override) {
	Simple2DRenderer* renderer = getHandle<Simple2DRenderer>(handle);
	float* matrix = env->GetFloatArrayElements(array, JNI_FALSE);
	renderer->push(mat4(matrix), override == JNI_TRUE);
	env->ReleaseFloatArrayElements(array, matrix, JNI_FALSE);
}


JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Simple2DRenderer_native_1pop
(JNIEnv *env, jclass cls, jlong handle) {
	Simple2DRenderer* renderer = getHandle<Simple2DRenderer>(handle);
	renderer->pop();
}
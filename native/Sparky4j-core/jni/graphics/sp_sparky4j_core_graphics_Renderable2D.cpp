#include "sp_sparky4j_core_graphics_Renderable2D.h"
#include "../../src/graphics/renderable2d.h"
#include "../../src/graphics/renderer2d.h"
#include "../handle.h"

using namespace sparky::graphics;
using namespace sparky::maths;

JNIEXPORT jlong JNICALL Java_sp_sparky4j_core_graphics_Renderable2D_bind
(JNIEnv *env, jclass cls, jfloat xPos, jfloat yPos, jfloat zPos, jfloat xSize, jfloat ySize, jint color) {
	Renderable2D* renderable = new Renderable2D(vec3(xPos, yPos, zPos), vec2(xSize, ySize), color);
	return getPointer(renderable);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Renderable2D_native_1setColor__JI
(JNIEnv *env, jclass cls, jlong handle, jint color) {
	Renderable2D* renderable = getHandle<Renderable2D>(handle);
	renderable->setColor(color);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Renderable2D_native_1setColor__JFFFF
(JNIEnv *env, jclass cls, jlong handle, jfloat xColor, jfloat yColor, jfloat zColor, jfloat wColor) {
	Renderable2D* renderable = getHandle<Renderable2D>(handle);
	renderable->setColor(vec4(xColor, yColor, zColor, wColor));
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Renderable2D_native_1submit
(JNIEnv *env, jclass cls, jlong handle, jlong renderer) {
	Renderer2D* nativeRenderer = getHandle<Renderer2D>(renderer);
	Renderable2D* renderable = getHandle<Renderable2D>(handle);
	nativeRenderer->submit(renderable);
}
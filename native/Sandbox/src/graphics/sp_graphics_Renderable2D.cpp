#include "sp_graphics_Renderable2D.h"
#include "../handle.h"
#include "sp\graphics\Renderable2D.h"

using namespace sp::graphics;

JNIEXPORT jlong JNICALL Java_sp_graphics_Renderable2D_native_1getTexture
(JNIEnv *env, jclass cls, jlong handler) {
	Renderable2D* renderable = getHandle<Renderable2D>(handler);
	return getPointer(renderable->GetTexture());
}

JNIEXPORT void JNICALL Java_sp_graphics_Renderable2D_native_1setColor
(JNIEnv *env, jclass cls, jlong handler, jint color) {
	Renderable2D* renderable = getHandle<Renderable2D>(handler);
	renderable->SetColor(color);
}

JNIEXPORT jint JNICALL Java_sp_graphics_Renderable2D_native_1getColor
(JNIEnv *env, jclass cls, jlong handler) {
	Renderable2D* renderable = getHandle<Renderable2D>(handler);
	return renderable->GetColor();
}
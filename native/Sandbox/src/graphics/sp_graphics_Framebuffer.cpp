#include "sp_graphics_Framebuffer.h"
#include "../handle.h"
#include "sp\graphics\Framebuffer.h"

using namespace sp::graphics;

JNIEXPORT jlong JNICALL Java_sp_graphics_Framebuffer_bind
(JNIEnv *evn, jclass cls, jint width, jint height) {
	Framebuffer* buffer = new Framebuffer(width, height);
	return getPointer(buffer);
}

JNIEXPORT void JNICALL Java_sp_graphics_Framebuffer_native_1bind
(JNIEnv *env, jclass cls, jlong handler) {
	Framebuffer* buffer = getHandle<Framebuffer>(handler);
	buffer->Bind();
}

JNIEXPORT void JNICALL Java_sp_graphics_Framebuffer_native_1clear
(JNIEnv *env, jclass cls, jlong handler) {
	Framebuffer* buffer = getHandle<Framebuffer>(handler);
	buffer->Clear();
}

JNIEXPORT jlong JNICALL Java_sp_graphics_Framebuffer_native_1getTexture
(JNIEnv *env, jclass cls, jlong handler) {
	Framebuffer* buffer = getHandle<Framebuffer>(handler);
	return getPointer(buffer->GetTexture());
}

JNIEXPORT void JNICALL Java_sp_graphics_Framebuffer_native_1setClearColor
(JNIEnv *env, jclass cls, jlong handler, jfloat x, jfloat y, jfloat z, jfloat w) {
	Framebuffer* buffer = getHandle<Framebuffer>(handler);
	buffer->SetClearColor(sp::maths::vec4(x, y, z, w));
}

#include "sp_graphics_Window.h"
#include "../handle.h"
#include "sp\graphics\Window.h"

using namespace sp::graphics;

JNIEXPORT jlong JNICALL Java_sp_graphics_Window_bind
(JNIEnv *env, jclass clz, jstring name, jint width, jint height) {
	const char* nameChars = env->GetStringUTFChars(name, JNI_FALSE);
	Window* window = new Window(nameChars, width, height);
	env->ReleaseStringUTFChars(name, nameChars);
	return getPointer(window);
}

JNIEXPORT void JNICALL Java_sp_graphics_Window_native_1clear
(JNIEnv *env, jclass cls, jlong handler) {
	Window* window = getHandle<Window>(handler);
	window->Clear();
}

JNIEXPORT void JNICALL Java_sp_graphics_Window_native_1update
(JNIEnv *env, jclass cls, jlong handler) {
	Window* window = getHandle<Window>(handler);
	window->Update();
}

JNIEXPORT void JNICALL Java_sp_graphics_Window_native_1updateInput
(JNIEnv *env, jclass cls, jlong handler) {
	Window* window = getHandle<Window>(handler);
	window->UpdateInput();
}

JNIEXPORT jboolean JNICALL Java_sp_graphics_Window_native_1closed
(JNIEnv *env, jclass cls, jlong handler) {
	Window* window = getHandle<Window>(handler);
	return window->Closed();
}

JNIEXPORT jint JNICALL Java_sp_graphics_Window_native_1getWidth
(JNIEnv *env, jclass cls, jlong handler) {
	Window* window = getHandle<Window>(handler);
	return window->GetWidth();
}

JNIEXPORT jint JNICALL Java_sp_graphics_Window_native_1getHeight
(JNIEnv *env, jclass cls, jlong handler) {
	Window* window = getHandle<Window>(handler);
	return window->GetHeight();
}

JNIEXPORT jboolean JNICALL Java_sp_graphics_Window_native_1isKeyPressed
(JNIEnv *env, jclass cls, jlong handler, jint keycode) {
	Window* window = getHandle<Window>(handler);
	return window->IsKeyPressed(keycode);
}

JNIEXPORT jboolean JNICALL Java_sp_graphics_Window_native_1isKeyTyped
(JNIEnv *env, jclass cls, jlong handler, jint keycode) {
	Window* window = getHandle<Window>(handler);
	return window->IsKeyTyped(keycode);
}

JNIEXPORT jboolean JNICALL Java_sp_graphics_Window_native_1isMouseButtonPressed
(JNIEnv *env, jclass cls, jlong handler, jint buttom) {
	Window* window = getHandle<Window>(handler);
	return window->IsMouseButtonPressed(buttom);
}

JNIEXPORT jboolean JNICALL Java_sp_graphics_Window_native_1isMouseButtonClicked
(JNIEnv *env, jclass cls, jlong handler, jint buttom) {
	Window* window = getHandle<Window>(handler);
	return window->IsMouseButtonClicked(buttom);
}

JNIEXPORT jfloat JNICALL Java_sp_graphics_Window_native_1getMouseX
(JNIEnv *env, jclass cls, jlong handler) {
	Window* window = getHandle<Window>(handler);
	return window->GetMousePosition().x;
}

JNIEXPORT jfloat JNICALL Java_sp_graphics_Window_native_1getMousey
(JNIEnv *env, jclass cls, jlong handler) {
	Window* window = getHandle<Window>(handler);
	return window->GetMousePosition().y;
}

JNIEXPORT void JNICALL Java_sp_graphics_Window_native_1setMousePosition
(JNIEnv *env, jclass clz, jlong handler, jfloat x, jfloat y) {
	Window* window = getHandle<Window>(handler);
	window->SetMousePosition(sp::maths::vec2(x, y));
}

JNIEXPORT jboolean JNICALL Java_sp_graphics_Window_native_1isMouseGrabbed
(JNIEnv *env, jclass cls, jlong handler) {
	Window* window = getHandle<Window>(handler);
	return window->IsMouseGrabbed();
}

JNIEXPORT void JNICALL Java_sp_graphics_Window_native_1setMouseGrabbed
(JNIEnv *env, jclass clz, jlong handler, jboolean grabbed) {
	Window* window = getHandle<Window>(handler);
	window->SetMouseGrabbed(grabbed == JNI_TRUE);
}

JNIEXPORT void JNICALL Java_sp_graphics_Window_native_1setMouseCursor
(JNIEnv *env, jclass clz, jlong handler, jint cursor) {
	Window* window = getHandle<Window>(handler);
	window->SetMouseCursor(cursor);
}

JNIEXPORT void JNICALL Java_sp_graphics_Window_native_1setVsync
(JNIEnv *env, jclass clz, jlong handler, jboolean enabled) {
	Window* window = getHandle<Window>(handler);
	window->SetVsync(enabled == JNI_TRUE);
}

JNIEXPORT jboolean JNICALL Java_sp_graphics_Window_native_1isVsync
(JNIEnv *env, jclass cls, jlong handler) {
	Window* window = getHandle<Window>(handler);
	return window->IsVsync();
}
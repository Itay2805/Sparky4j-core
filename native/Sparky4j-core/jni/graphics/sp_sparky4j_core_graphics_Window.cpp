#include "sp_sparky4j_core_graphics_Window.h"
#include "../../src/graphics/window.h"
#include "../handle.h"

using namespace sparky::graphics;

JNIEXPORT jlong JNICALL Java_sp_sparky4j_core_graphics_Window_bind
(JNIEnv *env, jclass cls, jstring title, jint width, jint height) {
	const char* titleChars = env->GetStringUTFChars(title, JNI_FALSE);
	Window* window = new Window(titleChars, width, height);
	env->ReleaseStringUTFChars(title, titleChars);
	return getPointer(window);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Window_native_1clear
(JNIEnv *env, jclass cls, jlong handle) {
	Window* window = getHandle<Window>(handle);
	window->clear();
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Window_native_1update
(JNIEnv *env, jclass cls, jlong handle) {
	Window* window = getHandle<Window>(handle);
	window->update();
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Window_native_1updateInput
(JNIEnv *env, jclass clz, jlong handle) {
	Window* window = getHandle<Window>(handle);
	window->updateInput();
}

JNIEXPORT jboolean JNICALL Java_sp_sparky4j_core_graphics_Window_native_1closed
(JNIEnv *env, jclass cls, jlong handle) {
	Window* window = getHandle<Window>(handle);
	return window->closed();
}

JNIEXPORT jboolean JNICALL Java_sp_sparky4j_core_graphics_Window_native_1isKeyPressed
(JNIEnv *env, jclass cls, jlong handle, jint keycode) {
	Window* window = getHandle<Window>(handle);
	return window->isKeyPressed(keycode);
}

JNIEXPORT jboolean JNICALL Java_sp_sparky4j_core_graphics_Window_native_1isKeyTyped
(JNIEnv *env, jclass cls, jlong handle, jint keycode) {
	Window* window = getHandle<Window>(handle);
	return window->isKeyTyped(keycode);
}

JNIEXPORT jboolean JNICALL Java_sp_sparky4j_core_graphics_Window_native_1isMouseButtonPressed
(JNIEnv *env, jclass cls, jlong handle, jint button) {
	Window* window = getHandle<Window>(handle);
	return window->isMouseButtonPressed(button);
}

JNIEXPORT jboolean JNICALL Java_sp_sparky4j_core_graphics_Window_native_1isMouseButtonClicked
(JNIEnv *env, jclass cls, jlong handle, jint button) {
	Window* window = getHandle<Window>(handle);
	return window->isMouseButtonClicked(button);
}

JNIEXPORT jdouble JNICALL Java_sp_sparky4j_core_graphics_Window_native_1getMouseX
(JNIEnv *env, jclass cls, jlong handle) {
	Window* window = getHandle<Window>(handle);
	return window->getMousePosition().x;
}

JNIEXPORT jdouble JNICALL Java_sp_sparky4j_core_graphics_Window_native_1getMouseY
(JNIEnv *env, jclass cls, jlong handle) {
	Window* window = getHandle<Window>(handle);
	return window->getMousePosition().y;
}

JNIEXPORT jint JNICALL Java_sp_sparky4j_core_graphics_Window_native_1get_1width
(JNIEnv *env, jclass cls, jlong handle) {
	Window* window = getHandle<Window>(handle);
	return window->getWidth();
}

JNIEXPORT jint JNICALL Java_sp_sparky4j_core_graphics_Window_native_1get_1height
(JNIEnv *env, jclass cls, jlong handle) {
	Window* window = getHandle<Window>(handle);
	return window->getHeight();
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Window_native_1delete
(JNIEnv *env, jclass cls, jlong handle) {
	Window* window = getHandle<Window>(handle);
	delete window;
}
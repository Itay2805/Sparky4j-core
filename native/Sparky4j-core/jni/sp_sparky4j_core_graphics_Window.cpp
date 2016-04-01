#include "sp_sparky4j_core_graphics_Window.h"
#include "../src/graphics/window.h"
#include "handle.h"

using namespace sparky::graphics;

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Window_bindWindow
(JNIEnv *env, jobject obj, jstring title, jint width, jint height) {
	const char* chars = env->GetStringUTFChars(title, false);
	Window* window = new Window(chars, width, height);
	env->ReleaseStringUTFChars(title, chars);
	setHandle(env, obj, window);
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Window_clear
(JNIEnv *env, jobject obj) {
	Window* window = getHandle<Window>(env, obj);
	window->clear();
}

JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_Window_update
(JNIEnv *env, jobject obj) {
	Window* window = getHandle<Window>(env, obj);
	window->update();
}

JNIEXPORT jboolean JNICALL Java_sp_sparky4j_core_graphics_Window_closed
(JNIEnv *env, jobject obj) {
	Window* window = getHandle<Window>(env, obj);
	jboolean result = JNI_FALSE;
	if (window->closed()) result = JNI_TRUE;
	return result;
}

JNIEXPORT jint JNICALL Java_sp_sparky4j_core_graphics_Window_getWidth
(JNIEnv *env, jobject obj) {
	Window* window = getHandle<Window>(env, obj);
	return window->getWidth();
}

JNIEXPORT jint JNICALL Java_sp_sparky4j_core_graphics_Window_getHeight
(JNIEnv *env, jobject obj) {
	Window* window = getHandle<Window>(env, obj);
	return window->getHeight();
}

JNIEXPORT jboolean JNICALL Java_sp_sparky4j_core_graphics_Window_isKeyPressed
(JNIEnv *env, jobject obj, jint keycode) {
	Window* window = getHandle<Window>(env, obj);
	jboolean result = JNI_FALSE;
	if(window->isKeyPressed(keycode)) result = JNI_TRUE;
	return result;
}

JNIEXPORT jboolean JNICALL Java_sp_sparky4j_core_graphics_Window_isMouseButtonPressed
(JNIEnv *env, jobject obj, jint button) {
	Window* window = getHandle<Window>(env, obj);
	jboolean result = JNI_FALSE;
	if (window->isMouseButtonPressed(button)) result = JNI_TRUE;
	return result;
}


JNIEXPORT jdouble JNICALL Java_sp_sparky4j_core_graphics_Window_getMouseX
(JNIEnv *env, jobject obj) {
	Window* window = getHandle<Window>(env, obj);
	double x, y;
	window->getMousePosition(x, y);
	return x;
}

JNIEXPORT jdouble JNICALL Java_sp_sparky4j_core_graphics_Window_getMouseY
(JNIEnv *env, jobject obj) {
	Window* window = getHandle<Window>(env, obj);
	double x, y;
	window->getMousePosition(x, y);
	return y;
}
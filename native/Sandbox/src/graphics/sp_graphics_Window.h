/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class sp_graphics_Window */

#ifndef _Included_sp_graphics_Window
#define _Included_sp_graphics_Window
#ifdef __cplusplus
extern "C" {
#endif
	/*
	* Class:     sp_graphics_Window
	* Method:    bind
	* Signature: (Ljava/lang/String;II)J
	*/
	JNIEXPORT jlong JNICALL Java_sp_graphics_Window_bind
		(JNIEnv *, jclass, jstring, jint, jint);

	/*
	* Class:     sp_graphics_Window
	* Method:    native_clear
	* Signature: (J)V
	*/
	JNIEXPORT void JNICALL Java_sp_graphics_Window_native_1clear
		(JNIEnv *, jclass, jlong);

	/*
	* Class:     sp_graphics_Window
	* Method:    native_update
	* Signature: (J)V
	*/
	JNIEXPORT void JNICALL Java_sp_graphics_Window_native_1update
		(JNIEnv *, jclass, jlong);

	/*
	* Class:     sp_graphics_Window
	* Method:    native_updateInput
	* Signature: (J)V
	*/
	JNIEXPORT void JNICALL Java_sp_graphics_Window_native_1updateInput
		(JNIEnv *, jclass, jlong);

	/*
	* Class:     sp_graphics_Window
	* Method:    native_closed
	* Signature: (J)Z
	*/
	JNIEXPORT jboolean JNICALL Java_sp_graphics_Window_native_1closed
		(JNIEnv *, jclass, jlong);

	/*
	* Class:     sp_graphics_Window
	* Method:    native_getWidth
	* Signature: (J)I
	*/
	JNIEXPORT jint JNICALL Java_sp_graphics_Window_native_1getWidth
		(JNIEnv *, jclass, jlong);

	/*
	* Class:     sp_graphics_Window
	* Method:    native_getHeight
	* Signature: (J)I
	*/
	JNIEXPORT jint JNICALL Java_sp_graphics_Window_native_1getHeight
		(JNIEnv *, jclass, jlong);

	/*
	* Class:     sp_graphics_Window
	* Method:    native_isKeyPressed
	* Signature: (JI)Z
	*/
	JNIEXPORT jboolean JNICALL Java_sp_graphics_Window_native_1isKeyPressed
		(JNIEnv *, jclass, jlong, jint);

	/*
	* Class:     sp_graphics_Window
	* Method:    native_isKeyTyped
	* Signature: (JI)Z
	*/
	JNIEXPORT jboolean JNICALL Java_sp_graphics_Window_native_1isKeyTyped
		(JNIEnv *, jclass, jlong, jint);

	/*
	* Class:     sp_graphics_Window
	* Method:    native_isMouseButtonPressed
	* Signature: (JI)Z
	*/
	JNIEXPORT jboolean JNICALL Java_sp_graphics_Window_native_1isMouseButtonPressed
		(JNIEnv *, jclass, jlong, jint);

	/*
	* Class:     sp_graphics_Window
	* Method:    native_isMouseButtonClicked
	* Signature: (JI)Z
	*/
	JNIEXPORT jboolean JNICALL Java_sp_graphics_Window_native_1isMouseButtonClicked
		(JNIEnv *, jclass, jlong, jint);

	/*
	* Class:     sp_graphics_Window
	* Method:    native_getMouseX
	* Signature: (J)F
	*/
	JNIEXPORT jfloat JNICALL Java_sp_graphics_Window_native_1getMouseX
		(JNIEnv *, jclass, jlong);

	/*
	* Class:     sp_graphics_Window
	* Method:    native_getMousey
	* Signature: (J)F
	*/
	JNIEXPORT jfloat JNICALL Java_sp_graphics_Window_native_1getMousey
		(JNIEnv *, jclass, jlong);

	/*
	* Class:     sp_graphics_Window
	* Method:    native_setMousePosition
	* Signature: (JFF)V
	*/
	JNIEXPORT void JNICALL Java_sp_graphics_Window_native_1setMousePosition
		(JNIEnv *, jclass, jlong, jfloat, jfloat);

	/*
	* Class:     sp_graphics_Window
	* Method:    native_isMouseGrabbed
	* Signature: (J)Z
	*/
	JNIEXPORT jboolean JNICALL Java_sp_graphics_Window_native_1isMouseGrabbed
		(JNIEnv *, jclass, jlong);

	/*
	* Class:     sp_graphics_Window
	* Method:    native_setMouseGrabbed
	* Signature: (JZ)V
	*/
	JNIEXPORT void JNICALL Java_sp_graphics_Window_native_1setMouseGrabbed
		(JNIEnv *, jclass, jlong, jboolean);

	/*
	* Class:     sp_graphics_Window
	* Method:    native_setMouseCursor
	* Signature: (JI)V
	*/
	JNIEXPORT void JNICALL Java_sp_graphics_Window_native_1setMouseCursor
		(JNIEnv *, jclass, jlong, jint);

	/*
	* Class:     sp_graphics_Window
	* Method:    native_setVsync
	* Signature: (JZ)V
	*/
	JNIEXPORT void JNICALL Java_sp_graphics_Window_native_1setVsync
		(JNIEnv *, jclass, jlong, jboolean);

	/*
	* Class:     sp_graphics_Window
	* Method:    native_isVsync
	* Signature: (J)Z
	*/
	JNIEXPORT jboolean JNICALL Java_sp_graphics_Window_native_1isVsync
		(JNIEnv *, jclass, jlong);

#ifdef __cplusplus
}
#endif
#endif
/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class sp_graphics_Renderer2D */

#ifndef _Included_sp_graphics_Renderer2D
#define _Included_sp_graphics_Renderer2D
#ifdef __cplusplus
extern "C" {
#endif
	/*
	* Class:     sp_graphics_Renderer2D
	* Method:    native_push
	* Signature: (J[FZ)V
	*/
	JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1push
		(JNIEnv *, jclass, jlong, jfloatArray, jboolean);

	/*
	* Class:     sp_graphics_Renderer2D
	* Method:    native_pop
	* Signature: (J)V
	*/
	JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1pop
		(JNIEnv *, jclass, jlong);

	/*
	* Class:     sp_graphics_Renderer2D
	* Method:    native_setRenderTarget
	* Signature: (JI)V
	*/
	JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1setRenderTarget
		(JNIEnv *, jclass, jlong, jint);

	/*
	* Class:     sp_graphics_Renderer2D
	* Method:    native_getRenderTarget
	* Signature: (J)I
	*/
	JNIEXPORT jint JNICALL Java_sp_graphics_Renderer2D_native_1getRenderTarget
		(JNIEnv *, jclass, jlong);

	/*
	* Class:     sp_graphics_Renderer2D
	* Method:    native_setPostEffects
	* Signature: (JZ)V
	*/
	JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1setPostEffects
		(JNIEnv *, jclass, jlong, jboolean);

	/*
	* Class:     sp_graphics_Renderer2D
	* Method:    native_getPostEffects
	* Signature: (J)Z
	*/
	JNIEXPORT jboolean JNICALL Java_sp_graphics_Renderer2D_native_1getPostEffects
		(JNIEnv *, jclass, jlong);

	/*
	* Class:     sp_graphics_Renderer2D
	* Method:    native_AddPostEffectsPass
	* Signature: (JJ)V
	*/
	JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1AddPostEffectsPass
		(JNIEnv *, jclass, jlong, jlong);

	/*
	* Class:     sp_graphics_Renderer2D
	* Method:    native_setMask
	* Signature: (JJ)V
	*/
	JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1setMask
		(JNIEnv *, jclass, jlong, jlong);

	/*
	* Class:     sp_graphics_Renderer2D
	* Method:    native_begin
	* Signature: (J)V
	*/
	JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1begin
		(JNIEnv *, jclass, jlong);

	/*
	* Class:     sp_graphics_Renderer2D
	* Method:    native_submit
	* Signature: (JJ)V
	*/
	JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1submit
		(JNIEnv *, jclass, jlong, jlong);

	/*
	* Class:     sp_graphics_Renderer2D
	* Method:    native_drawString
	* Signature: (JLjava/lang/String;FFFJI)V
	*/
	JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1drawString
		(JNIEnv *, jclass, jlong, jstring, jfloat, jfloat, jfloat, jlong, jint);

	/*
	* Class:     sp_graphics_Renderer2D
	* Method:    native_end
	* Signature: (J)V
	*/
	JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1end
		(JNIEnv *, jclass, jlong);

	/*
	* Class:     sp_graphics_Renderer2D
	* Method:    native_flush
	* Signature: (J)V
	*/
	JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1flush
		(JNIEnv *, jclass, jlong);

#ifdef __cplusplus
}
#endif
#endif

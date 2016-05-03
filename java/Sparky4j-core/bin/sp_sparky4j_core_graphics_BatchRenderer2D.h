/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class sp_sparky4j_core_graphics_BatchRenderer2D */

#ifndef _Included_sp_sparky4j_core_graphics_BatchRenderer2D
#define _Included_sp_sparky4j_core_graphics_BatchRenderer2D
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     sp_sparky4j_core_graphics_BatchRenderer2D
 * Method:    bind
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_bind
  (JNIEnv *, jclass);

/*
 * Class:     sp_sparky4j_core_graphics_BatchRenderer2D
 * Method:    native_begin
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_native_1begin
  (JNIEnv *, jclass, jlong);

/*
 * Class:     sp_sparky4j_core_graphics_BatchRenderer2D
 * Method:    native_submit
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_native_1submit
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     sp_sparky4j_core_graphics_BatchRenderer2D
 * Method:    native_draw_string
 * Signature: (JLjava/lang/String;FFFJI)V
 */
JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_native_1draw_1string
  (JNIEnv *, jclass, jlong, jstring, jfloat, jfloat, jfloat, jlong, jint);

/*
 * Class:     sp_sparky4j_core_graphics_BatchRenderer2D
 * Method:    native_end
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_native_1end
  (JNIEnv *, jclass, jlong);

/*
 * Class:     sp_sparky4j_core_graphics_BatchRenderer2D
 * Method:    native_flush
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_native_1flush
  (JNIEnv *, jclass, jlong);

/*
 * Class:     sp_sparky4j_core_graphics_BatchRenderer2D
 * Method:    native_push
 * Signature: (J[FZ)V
 */
JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_native_1push
  (JNIEnv *, jclass, jlong, jfloatArray, jboolean);

/*
 * Class:     sp_sparky4j_core_graphics_BatchRenderer2D
 * Method:    native_pop
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_native_1pop
  (JNIEnv *, jclass, jlong);

#ifdef __cplusplus
}
#endif
#endif

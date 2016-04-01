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
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_bind
  (JNIEnv *, jobject);

/*
 * Class:     sp_sparky4j_core_graphics_BatchRenderer2D
 * Method:    push
 * Signature: (Lsp/sparky4j/core/maths/Matrix4;Z)V
 */
JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_push
  (JNIEnv *, jobject, jobject, jboolean);

/*
 * Class:     sp_sparky4j_core_graphics_BatchRenderer2D
 * Method:    pop
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_pop
  (JNIEnv *, jobject);

/*
 * Class:     sp_sparky4j_core_graphics_BatchRenderer2D
 * Method:    submit
 * Signature: (Lsp/sparky4j/core/graphics/Renderable2D;)V
 */
JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_submit
  (JNIEnv *, jobject, jobject);

/*
 * Class:     sp_sparky4j_core_graphics_BatchRenderer2D
 * Method:    flush
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_flush
  (JNIEnv *, jobject);

/*
 * Class:     sp_sparky4j_core_graphics_BatchRenderer2D
 * Method:    begin
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_begin
  (JNIEnv *, jobject);

/*
 * Class:     sp_sparky4j_core_graphics_BatchRenderer2D
 * Method:    end
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_sp_sparky4j_core_graphics_BatchRenderer2D_end
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif

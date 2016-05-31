#include "sp_graphics_Mask.h"
#include "../handle.h"
#include "sp\graphics\Mask.h"

using namespace sp::graphics;

JNIEXPORT jlong JNICALL Java_sp_graphics_Mask_bind
(JNIEnv *env, jclass cls, jlong texture, jfloatArray elements) {
	Texture* natTexture = getHandle<Texture>(texture);
	jfloat* array = env->GetFloatArrayElements(elements, NULL);
	sp::maths::mat4* mat = new sp::maths::mat4();
	for (int i = 0; i < 4 * 4; i++)
		mat->elements[i] = array[i];
	Mask* mask = new Mask(natTexture, *mat);
	return getPointer(mask);
}

JNIEXPORT void JNICALL Java_sp_graphics_Mask_native_1setTransform
(JNIEnv *env, jclass cls, jlong handler, jfloatArray elements) {
	Mask* mask = getHandle<Mask>(handler);
	jfloat* array = env->GetFloatArrayElements(elements, NULL);
	sp::maths::mat4* mat = new sp::maths::mat4();
	for (int i = 0; i < 4 * 4; i++)
		mat->elements[i] = array[i];
	mask->transform = *mat;
}
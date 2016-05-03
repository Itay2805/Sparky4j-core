#include "sp_sparky4j_core_graphics_Font.h"
#include "../../src/graphics/font.h"
#include "../handle.h"

using namespace sparky::graphics;

JNIEXPORT jlong JNICALL Java_sp_sparky4j_core_graphics_Font_bind
(JNIEnv *env, jclass cls, jstring name, jstring filename, jint size) {
	const char* nameChars = env->GetStringUTFChars(name, NULL);
	const char* filenameChars = env->GetStringUTFChars(filename, NULL);
	Font* font = new Font(nameChars, filenameChars, size);
	env->ReleaseStringUTFChars(name, nameChars);
	env->ReleaseStringUTFChars(filename, filenameChars);
	return getPointer(font);
}

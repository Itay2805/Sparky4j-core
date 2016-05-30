#include "sp_utils_Log.h"
#include "sp\utils\Log.h"

JNIEXPORT void JNICALL Java_sp_utils_Log_SPARKY_1LOG
(JNIEnv *env, jclass cls, jstring text) {
	const char* textChars = env->GetStringUTFChars(text, NULL);
	SPARKY_INFO(textChars);
	env->ReleaseStringUTFChars(text, textChars);
}
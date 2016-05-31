#include "sp_utils_Log.h"
#include "sp\utils\Log.h"

JNIEXPORT void JNICALL Java_sp_utils_Log_SPARKY_1FATAL
(JNIEnv *env, jclass cls, jstring text) {
	const char* textChars = env->GetStringUTFChars(text, NULL);
	SPARKY_FATAL(textChars);
	env->ReleaseStringUTFChars(text, textChars);
}

JNIEXPORT void JNICALL Java_sp_utils_Log_SPARKY_1ERROR
(JNIEnv *env, jclass cls, jstring text) {
	const char* textChars = env->GetStringUTFChars(text, NULL);
	SPARKY_ERROR(textChars);
	env->ReleaseStringUTFChars(text, textChars);
}

JNIEXPORT void JNICALL Java_sp_utils_Log_SPARKY_1WARN
(JNIEnv *env, jclass cls, jstring text) {
	const char* textChars = env->GetStringUTFChars(text, NULL);
	SPARKY_WARN(textChars);
	env->ReleaseStringUTFChars(text, textChars);
}

JNIEXPORT void JNICALL Java_sp_utils_Log_SPARKY_1INFO
(JNIEnv *env, jclass cls, jstring text) {
	const char* textChars = env->GetStringUTFChars(text, NULL);
	SPARKY_INFO(textChars);
	env->ReleaseStringUTFChars(text, textChars);
}
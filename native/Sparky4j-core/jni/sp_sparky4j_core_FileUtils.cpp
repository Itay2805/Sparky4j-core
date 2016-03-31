#include "sp_sparky4j_core_FileUtils.h"
#include "../src/utils/fileutils.h"

using namespace sparky;

JNIEXPORT jstring JNICALL Java_sp_sparky4j_core_FileUtils_read_1file
(JNIEnv *env, jclass cls, jstring filepath) {
	std::string file = FileUtils::read_file(env->GetStringUTFChars(filepath, false));
	const char *str = file.c_str();
	return env->NewStringUTF(str);
}
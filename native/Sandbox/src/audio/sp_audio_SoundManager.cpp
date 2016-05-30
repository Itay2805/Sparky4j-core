#include "sp_audio_SoundManager.h"
#include "sp\audio\SoundManager.h"

using namespace sp::audio;

JNIEXPORT void JNICALL Java_sp_audio_SoundManager_init
(JNIEnv *env, jclass cls) {
	SoundManager::Init();
}

JNIEXPORT void JNICALL Java_sp_audio_SoundManager_update
(JNIEnv *env, jclass cls) {
	SoundManager::Update();
}

JNIEXPORT void JNICALL Java_sp_audio_SoundManager_native_1clean
(JNIEnv *env, jclass cls) {
	SoundManager::Clean();
}
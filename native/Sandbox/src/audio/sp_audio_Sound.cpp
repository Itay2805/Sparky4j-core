#include "sp_audio_Sound.h"
#include "../handle.h"
#include "sp\audio\Sound.h"

using namespace sp::audio;

JNIEXPORT jlong JNICALL Java_sp_audio_Sound_bind
(JNIEnv *env, jclass cls, jstring filename) {
	const char* filenameChars = env->GetStringUTFChars(filename, JNI_FALSE);
	Sound* sound = new Sound("", filenameChars);
	env->ReleaseStringUTFChars(filename, filenameChars);
	return getPointer(sound);
}

JNIEXPORT void JNICALL Java_sp_audio_Sound_native_1play
(JNIEnv *env, jclass cls, jlong handler) {
	Sound* sound = getHandle<Sound>(handler);
	sound->Play();
}

JNIEXPORT void JNICALL Java_sp_audio_Sound_native_1loop
(JNIEnv *env, jclass cls, jlong handler) {
	Sound* sound = getHandle<Sound>(handler);
	sound->Loop();
}

JNIEXPORT void JNICALL Java_sp_audio_Sound_native_1pause
(JNIEnv *env, jclass cls, jlong handler) {
	Sound* sound = getHandle<Sound>(handler);
	sound->Pause();
}

JNIEXPORT void JNICALL Java_sp_audio_Sound_native_1resume
(JNIEnv *env, jclass cls, jlong handler) {
	Sound* sound = getHandle<Sound>(handler);
	sound->Resume();
}

JNIEXPORT void JNICALL Java_sp_audio_Sound_native_1stop
(JNIEnv *env, jclass cls, jlong handler) {
	Sound* sound = getHandle<Sound>(handler);
	sound->Stop();
}

JNIEXPORT void JNICALL Java_sp_audio_Sound_native_1setGain
(JNIEnv *env, jclass cls, jlong handler, jfloat gain) {
	Sound* sound = getHandle<Sound>(handler);
	sound->SetGain(gain);
}

JNIEXPORT jboolean JNICALL Java_sp_audio_Sound_native_1isPlaying
(JNIEnv *env, jclass cls, jlong handler) {
	Sound* sound = getHandle<Sound>(handler);
	return sound->IsPlaying();
}

JNIEXPORT jfloat JNICALL Java_sp_audio_Sound_native_1getGain
(JNIEnv *env, jclass cls, jlong handler) {
	Sound* sound = getHandle<Sound>(handler);
	return sound->GetGain();
}

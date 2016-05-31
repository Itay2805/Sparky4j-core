#include "sp_graphics_Renderer2D .h"
#include "../handle.h"
#include "sp\graphics\Renderer2D.h"

using namespace sp::graphics;

JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1push
(JNIEnv *env, jclass cls, jlong handler, jfloatArray elements, jboolean override) {
	Renderer2D* renderer = getHandle<Renderer2D>(handler);
	jfloat* floats = env->GetFloatArrayElements(elements, NULL);
	sp::maths::mat4* mat = new sp::maths::mat4();
	for (int i = 0; i < 4 * 4; i++)
		mat->elements[i] = floats[i];
	renderer->Push(*mat);
	env->ReleaseFloatArrayElements(elements, floats, NULL);
	delete mat;
}

JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1pop
(JNIEnv *env, jclass cls, jlong handler) {
	Renderer2D* renderer = getHandle<Renderer2D>(handler);
	renderer->Pop();
}

JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1setRenderTarget
(JNIEnv *env, jclass cls, jlong handler, jint target) {
	Renderer2D* renderer = getHandle<Renderer2D>(handler);
	renderer->SetRenderTarget((RenderTarget)target);
}

JNIEXPORT jint JNICALL Java_sp_graphics_Renderer2D_native_1getRenderTarget
(JNIEnv *env, jclass cls, jlong handler) {
	Renderer2D* renderer = getHandle<Renderer2D>(handler);
	return (jint)renderer->GetRenderTarget();
}

JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1setPostEffects
(JNIEnv *env, jclass cls, jlong handler, jboolean enabled) {
	Renderer2D* renderer = getHandle<Renderer2D>(handler);
	renderer->SetPostEffects(enabled == JNI_TRUE);
}

JNIEXPORT jboolean JNICALL Java_sp_graphics_Renderer2D_native_1getPostEffects
(JNIEnv *env, jclass cls, jlong handler) {
	Renderer2D* renderer = getHandle<Renderer2D>(handler);
	return renderer->GetPostEffects();
}

JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1AddPostEffectsPass
(JNIEnv *env, jclass cls, jlong handler, jlong pass) {
	Renderer2D* renderer = getHandle<Renderer2D>(handler);
	PostEffectsPass* natPass = getHandle<PostEffectsPass>(pass);
	renderer->AddPostEffectsPass(natPass);
}

JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1setMask
(JNIEnv *env, jclass cls, jlong handler, jlong mask) {
	Renderer2D* renderer = getHandle<Renderer2D>(handler);
	Mask* natMask = getHandle<Mask>(handler);
	renderer->SetMask(natMask);
}

JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1begin
(JNIEnv *env, jclass cls, jlong handler) {
	Renderer2D* renderer = getHandle<Renderer2D>(handler);
	renderer->Begin();
}

JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1submit
(JNIEnv *env, jclass cls, jlong handler, jlong renderable) {
	Renderer2D* renderer = getHandle<Renderer2D>(handler);
	Renderable2D* natRenderable = getHandle<Renderable2D>(renderable);
	renderer->Submit(natRenderable);
}

JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1drawString
(JNIEnv *env, jclass cls, jlong handler, jstring text, jfloat x, jfloat y, jfloat z, jlong font, jint color) {
	Renderer2D* renderer = getHandle<Renderer2D>(handler);
	Font* natFont = getHandle<Font>(font);
	const char* textChars = env->GetStringUTFChars(text, NULL);
	renderer->DrawString(textChars, sp::maths::vec3(x, y, z), *natFont, color);
	env->ReleaseStringUTFChars(text, textChars);
}

JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1end
(JNIEnv *env, jclass cls, jlong handler) {
	Renderer2D* renderer = getHandle<Renderer2D>(handler);
	renderer->End();
}

JNIEXPORT void JNICALL Java_sp_graphics_Renderer2D_native_1flush
(JNIEnv *env, jclass cls, jlong handler) {
	Renderer2D* renderer = getHandle<Renderer2D>(handler);
	renderer->Flush();
}
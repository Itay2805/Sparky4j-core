#include "sp_graphics_postfx_PostEffectsPass.h"
#include "../../handle.h"
#include "sp\graphics\postfx\PostEffectsPass.h"

using namespace sp::graphics;

JNIEXPORT jlong JNICALL Java_sp_graphics_postfx_PostEffectsPass_bind
(JNIEnv *env, jclass cls, jlong shader) {
	Shader* natShader = getHandle<Shader>(shader);
	PostEffectsPass* pass = new PostEffectsPass(natShader);
	return getPointer(pass);
}

JNIEXPORT void JNICALL Java_sp_graphics_postfx_PostEffectsPass_native_1renderPass
(JNIEnv *env, jclass cls, jlong handler, jlong framebuffer) {
	PostEffectsPass* pass = getHandle<PostEffectsPass>(handler);
	Framebuffer* buffer = getHandle<Framebuffer>(framebuffer);
	pass->RenderPass(buffer);
}
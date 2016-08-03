#include "platform_SPOpenGLRenderAPI.h";
#include "platform\opengl\SPOpenGLRenderAPI.inl";

using namespace sp::graphics::API;

JNIEXPORT jint JNICALL Java_platform_SPOpenGLRenderAPI_createVertexArray
(JNIEnv *env, jobject obj) {
	return CreateVertexArray();
}

JNIEXPORT jint JNICALL Java_platform_SPOpenGLRenderAPI_createBuffer
(JNIEnv *env, jobject obj) {
	return CreateBuffer();
}

JNIEXPORT jint JNICALL Java_platform_SPOpenGLRenderAPI_createFramebuffer
(JNIEnv *env, jobject obj) {
	return CreateFramebuffer();
}

JNIEXPORT jint JNICALL Java_platform_SPOpenGLRenderAPI_createRenderbuffer
(JNIEnv *env, jobject obj) {
	return CreateRenderbuffer();
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_ceateVertexArrays
(JNIEnv *env, jobject obj, jint size, jintArray arrays) {
	jsize len = env->GetArrayLength(arrays);
	jint* jintArray = env->GetIntArrayElements(arrays, NULL);
	uint* nativeArrays = new uint[len];
	for (int i = 0; i < len; i++) {
		nativeArrays[i] = jintArray[i];
	}
	CreateVertexArrays(size, nativeArrays);
	delete nativeArrays;
	env->ReleaseIntArrayElements(arrays, jintArray, NULL);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_createVertexBuffers
(JNIEnv *env, jobject obj, jint size, jintArray arrays) {
	jsize len = env->GetArrayLength(arrays);
	jint* jintArray = env->GetIntArrayElements(arrays, NULL);
	uint* nativeArrays = new uint[len];
	for (int i = 0; i < len; i++) {
		nativeArrays[i] = jintArray[i];
	}
	CreateVertexBuffers(size, nativeArrays);
	delete nativeArrays;
	env->ReleaseIntArrayElements(arrays, jintArray, NULL);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_createFramebuffers
(JNIEnv *env, jobject obj, jint size, jintArray arrays) {
	jsize len = env->GetArrayLength(arrays);
	jint* jintArray = env->GetIntArrayElements(arrays, NULL);
	uint* nativeArrays = new uint[len];
	for (int i = 0; i < len; i++) {
		nativeArrays[i] = jintArray[i];
	}
	CreateFramebuffers(size, nativeArrays);
	delete nativeArrays;
	env->ReleaseIntArrayElements(arrays, jintArray, NULL);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_createRenderbuffers
(JNIEnv *env, jobject obj, jint size, jintArray arrays) {
	jsize len = env->GetArrayLength(arrays);
	jint* jintArray = env->GetIntArrayElements(arrays, NULL);
	uint* nativeArrays = new uint[len];
	for (int i = 0; i < len; i++) {
		nativeArrays[i] = jintArray[i];
	}
	CreateRenderbuffers(size, nativeArrays);
	delete nativeArrays;
	env->ReleaseIntArrayElements(arrays, jintArray, NULL);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_bindVertexArray
(JNIEnv *env, jobject obj, jint array) {
	BindVertexArray(array);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_bindBuffer
(JNIEnv *env, jobject obj, jint target, jint buffer) {
	BindBuffer(target, buffer);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_bindFramebuffer
(JNIEnv *env, jobject obj, jint target, jint buffer) {
	BindFramebuffer(target, buffer);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_bindRenderbuffer
(JNIEnv *env, jobject obj, jint target, jint buffer) {
	BindRenderbuffer(target, buffer);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_setBufferData
(JNIEnv *env, jobject obj, jint target, jint size, jobject buffer, jint usage) {
	void* nativeData = env->GetDirectBufferAddress(buffer);
	SetBufferData(target, size, nativeData, usage);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_setBufferSubData
(JNIEnv *env, jobject obj, jint target, jint offset, jint size, jobject buffer) {
	void* nativeData = env->GetDirectBufferAddress(buffer);
	SetBufferSubData(target, offset, size, nativeData);
}

JNIEXPORT jobject JNICALL Java_platform_SPOpenGLRenderAPI_getBufferPointer
(JNIEnv *env, jobject obj, jint target, jint access) {
	void* data = GetBufferPointer(target, access);
	std::cout << sizeof(data) << std::endl;
	return env->NewDirectByteBuffer(data, sizeof(data));
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_releaseBufferPointer
(JNIEnv *env, jobject obj, jint target) {
	ReleaseBufferPointer(target);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_framebufferTexture2D
(JNIEnv *env, jobject obj, jint target, jint attachment, jint textarget, jint texture, jint level) {
	FramebufferTexture2D(target, attachment, textarget, texture, level);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_framebufferRenderbuffer
(JNIEnv *, jobject, jint target, jint attachment, jint renderbuffertarget, jint renderbuffer) {
	FramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_renderbufferStorage
(JNIEnv *env, jobject obj, jint target, jint format, jint width, jint height) {
	RenderbufferStorage(target, format, width, height);
}

JNIEXPORT jint JNICALL Java_platform_SPOpenGLRenderAPI_getScreenBuffer
(JNIEnv *env, jobject obj) {
	return GetScreenBuffer();
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_setViewport
(JNIEnv *env, jobject obj, jint x, jint y, jint width, jint height) {
	SetViewport(x, y, width, height);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_clear
(JNIEnv *env, jobject obj, jint flags) {
	Clear(flags);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_setClearColor
(JNIEnv *env, jobject obj, jfloat r, jfloat g, jfloat b, jfloat a) {
	SetClearColor(r, g, b, a);
}

JNIEXPORT jint JNICALL Java_platform_SPOpenGLRenderAPI_createTexture
(JNIEnv *env, jobject obj) {
	return CreateTexture();
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_createTextures
(JNIEnv *env, jobject obj, jint size, jintArray arrays) {
	jsize len = env->GetArrayLength(arrays);
	jint* jintArray = env->GetIntArrayElements(arrays, NULL);
	uint* nativeArrays = new uint[len];
	for (int i = 0; i < len; i++) {
		nativeArrays[i] = jintArray[i];
	}
	CreateTextures(size, nativeArrays);
	delete nativeArrays;
	env->ReleaseIntArrayElements(arrays, jintArray, NULL);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_bindTexture
(JNIEnv *env, jobject obj, jint target, jint texture) {
	BindTexture(target, texture);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_unbindTexture
(JNIEnv *env, jobject obj, jint target) {
	UnbindTexture(target);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_setTextureParamater
(JNIEnv *env, jobject, jint target, jint parameter, jint value) {
	SetTextureParameter(target, parameter, value);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_setTextureData
(JNIEnv *env, jobject obj, jint target, jint internalformat, jint width, jint height, jint format, jint type, jintArray pixels) {
	jsize len = env->GetArrayLength(pixels);
	jint* jintArray = env->GetIntArrayElements(pixels, NULL);
	uint* nativePixels = new uint[len];
	for (int i = 0; i < len; i++) {
		nativePixels[i] = jintArray[i];
	}
	SetTextureData(target, internalformat, width, height, format, type, nativePixels);
	delete nativePixels;
	env->ReleaseIntArrayElements(pixels, jintArray, NULL);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_setActiveTexture
(JNIEnv *env, jobject obj, jint texture) {
	SetActiveTexture(texture);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_unbindVertexArrays
(JNIEnv *env, jobject obj) {
	UnbindVertexArrays();
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_unbindBuffers
(JNIEnv *env, jobject obj, jint target) {
	UnbindBuffers(target);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_enableVertexAttribute
(JNIEnv *env, jobject obj, jint index) {
	EnableVertexAttribute(index);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_disableVertexAttribute
(JNIEnv *env, jobject obj, jint index) {
	DisableVertexAttribute(index);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_setVertexAttributePointer
(JNIEnv *env, jobject obj, jint index, jint size, jint type, jboolean normalized, jint stride, jint offset) {
	SetVertexAttributePointer(index, size, type, normalized, stride, offset);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_freeVertexArray
(JNIEnv *env, jobject obj, jint array) {
	FreeVertexArray(array);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_freeBuffer
(JNIEnv *env, jobject obj, jint buffer) {
	FreeBuffer(buffer);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_freeFramebuffer
(JNIEnv *env, jobject obj, jint buffer) {
	FreeFramebuffer(buffer);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_freeVertexArrays
(JNIEnv *env, jobject obj, jint size, jintArray arrays) {
	jsize len = env->GetArrayLength(arrays);
	jint* jintArray = env->GetIntArrayElements(arrays, NULL);
	uint* nativeArrays = new uint[len];
	for (int i = 0; i < len; i++) {
		nativeArrays[i] = jintArray[i];
	}
	FreeVertexArrays(size, nativeArrays);
	delete nativeArrays;
	env->ReleaseIntArrayElements(arrays, jintArray, NULL);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_freeBuffers
(JNIEnv *env, jobject obj, jint size, jintArray arrays) {
	jsize len = env->GetArrayLength(arrays);
	jint* jintArray = env->GetIntArrayElements(arrays, NULL);
	uint* nativeArrays = new uint[len];
	for (int i = 0; i < len; i++) {
		nativeArrays[i] = jintArray[i];
	}
	FreeBuffers(size, nativeArrays);
	delete nativeArrays;
	env->ReleaseIntArrayElements(arrays, jintArray, NULL);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_freeFramebuffers
(JNIEnv *env, jobject obj, jint size, jintArray arrays) {
	jsize len = env->GetArrayLength(arrays);
	jint* jintArray = env->GetIntArrayElements(arrays, NULL);
	uint* nativeArrays = new uint[len];
	for (int i = 0; i < len; i++) {
		nativeArrays[i] = jintArray[i];
	}
	FreeFramebuffers(size, nativeArrays);
	delete nativeArrays;
	env->ReleaseIntArrayElements(arrays, jintArray, NULL);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_freeTexture
(JNIEnv *env, jobject obj, jint texture) {
	FreeTexture(texture);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_freeTextures
(JNIEnv *env, jobject obj, jint size, jintArray arrays) {
	jsize len = env->GetArrayLength(arrays);
	jint* jintArray = env->GetIntArrayElements(arrays, NULL);
	uint* nativeArrays = new uint[len];
	for (int i = 0; i < len; i++) {
		nativeArrays[i] = jintArray[i];
	}
	FreeTextures(size, nativeArrays);
	delete nativeArrays;
	env->ReleaseIntArrayElements(arrays, jintArray, NULL);
}

JNIEXPORT void JNICALL Java_platform_SPOpenGLRenderAPI_drawElements
(JNIEnv *env, jobject obj, jint mode, jint count, jint type, jobject buffer) {
	void* data = env->GetDirectBufferAddress(buffer);
	DrawElements(mode, count, type, data);
}
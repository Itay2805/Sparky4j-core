#ifndef _HANDLE_H_INCLUDED_
#define _HANDLE_H_INCLUDED_

static jfieldID getHandleField(JNIEnv *env, jobject obj)
{
	return env->GetFieldID(env->GetObjectClass(obj), "nativeHandle", "J");
}

template <typename T>
static T *getHandle(JNIEnv *env, jobject obj)
{
	jlong handle = env->GetLongField(obj, getHandleField(env, obj));
	return reinterpret_cast<T *>(handle);
}

template <typename T>
static void setHandle(JNIEnv *env, jobject obj, T *t)
{
	jlong handle = reinterpret_cast<jlong>(t);
	env->SetLongField(obj, getHandleField(env, obj), handle);
}

#endif
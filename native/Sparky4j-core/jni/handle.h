#pragma once

#ifndef  _HANDLE_H_INCLUDED_
#define _HANDLE_H_INCLUDED_

template <typename T>
T *getHandle(jlong handle) {
	return reinterpret_cast<T *>(handle);
}

template <typename T>
jlong getPointer(T *t) {
	return reinterpret_cast<jlong>(t);
}


#endif //  _HANDLE_H_INCLUDED_

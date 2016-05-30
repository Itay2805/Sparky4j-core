#include "sp_graphics_BatchRenderer2D.h"
#include "../handle.h"
#include "sp\graphics\BatchRenderer2D.h"

using namespace sp::graphics;

JNIEXPORT jlong JNICALL Java_sp_graphics_BatchRenderer2D_bind
(JNIEnv *env, jclass cls, jint width, jint height) {
	BatchRenderer2D* renderer = new BatchRenderer2D(width, height);
	return getPointer(renderer);
}

JNIEXPORT void JNICALL Java_sp_graphics_BatchRenderer2D_native_1drawAABB
(JNIEnv *env, jclass cls, jlong handler, jfloat minx, jfloat miny, jfloat minz, jfloat maxx, jfloat maxy, jfloat maxz, jint color) {
	BatchRenderer2D* renderer = getHandle<BatchRenderer2D>(handler);
	sp::maths::vec3 min(minx, miny, minz);
	sp::maths::vec3 max(maxx, maxy, maxz);
	sp::maths::AABB aabb(min, max);
	renderer->DrawAABB(aabb, color);
}

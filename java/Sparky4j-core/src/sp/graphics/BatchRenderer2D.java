package sp.graphics;

import sp.maths.AABB;

public class BatchRenderer2D extends Renderer2D {

	public BatchRenderer2D(int width, int height) {
		super(bind(width, height));
	}
	
	private static native long bind(int width, int height);
	
	public void drawAABB(AABB aabb) { drawAABB(aabb, 0xffffffff); }
	public void drawAABB(AABB aabb, int color) {
		native_drawAABB(getNativeHandler(),
						aabb.min.x, aabb.min.y, aabb.min.z,
						aabb.max.x, aabb.max.y, aabb.max.z,
						color);
	}
	
	private static native void native_drawAABB(long handler,
												float minX, float minY, float minZ,
												float maxX, float maxY, float maxZ,
												int color);
	
	// TODO add tvec
	// Need to find a way to use it without reflection
	
}

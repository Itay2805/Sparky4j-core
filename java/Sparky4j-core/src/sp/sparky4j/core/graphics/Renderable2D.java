package sp.sparky4j.core.graphics;

import sp.sparky4j.core.maths.Vector2;
import sp.sparky4j.core.maths.Vector3;
import sp.sparky4j.core.maths.Vector4;

public class Renderable2D {
	
	protected long nativeHandle;
	
	public Renderable2D(Vector3 position, Vector2 size, int color) {
		nativeHandle = bind(position.x, position.y, position.z,
							size.x, size.y,
							color);
	}
	
	protected Renderable2D() {
		nativeHandle = bind(0, 0, 0, 0, 0, 0);
	}
	
	private static native long bind(float xPos, float yPos, float zPos,
							 float xSize, float ySize,
							 int color);
	
	public void submit(Renderer2D renderer) {
		//native_submit(nativeHandle, renderer.getNativeHandler());
		renderer.submit(this);
	}
	
	public void setColor(int color) {
		native_setColor(nativeHandle, color);
	}
	
	public void setColor(Vector4 color) {
		native_setColor(nativeHandle, color.x, color.y, color.z, color.w);
	}
	
	private static native void native_setColor(long handle, int color);
	private static native void native_setColor(long handle, float x, float y, float z, float w);
	private static native void native_submit(long handle, long renderer);
	
	public long getNativeHandle() {
		return nativeHandle;
	}
	
}

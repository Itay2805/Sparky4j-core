package sp.sparky4j.core.graphics;

import sp.sparky4j.core.maths.Vector2;
import sp.sparky4j.core.maths.Vector3;
import sp.sparky4j.core.maths.Vector4;

public class Renderable2D {
	
	protected long nativeHandle;
	
	public Renderable2D(Vector3 position, Vector2 size, Vector4 color) {
		nativeHandle = bind(position.x, position.y, position.z,
							size.x, size.y,
							color.x, color.y, color.z, color.w);
	}
	
	protected Renderable2D() {}
	
	private static native long bind(float xPos, float yPos, float zPos,
							 float xSize, float ySize,
							 float xColor, float yColor, float zColor, float wColor);
	
	public void submit(Renderer2D renderer) {
		native_submit(nativeHandle, renderer.getNativeHandler());
	}
	
	private static native void native_submit(long handle, long renderer);
	
	public long getNativeHandle() {
		return nativeHandle;
	}
	
}

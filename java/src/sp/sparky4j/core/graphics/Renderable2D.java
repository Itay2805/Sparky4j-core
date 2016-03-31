package sp.sparky4j.core.graphics;

import sp.sparky4j.core.maths.Vector2;
import sp.sparky4j.core.maths.Vector3;
import sp.sparky4j.core.maths.Vector4;

public class Renderable2D {
	
	private long nativeHandle;
	
	public Renderable2D(Vector3 position, Vector2 size, Vector4 color) {
		bind(position, size, color);
	}
	
	protected Renderable2D() {}
	
	private native void bind(Vector3 position, Vector2 size, Vector4 color);
	
}

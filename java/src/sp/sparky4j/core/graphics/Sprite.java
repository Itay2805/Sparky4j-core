package sp.sparky4j.core.graphics;

import sp.sparky4j.core.maths.Vector4;

public class Sprite extends Renderable2D {
	
	private long nativeHandle;
	
	public Sprite(float x, float y, float width, float height, Vector4 color) {
		bind(x, y, width, height, color);
	}
	
	private native void bind(float x, float y, float width, float height, Vector4 color);
	
}

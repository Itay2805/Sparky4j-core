package sp.sparky4j.core.graphics;

import sp.sparky4j.core.maths.Vector4;

public class StaticSprite extends Renderable2D {
	
	private long nativeHandle;
	
	public StaticSprite(float x, float y, float width, float height, Vector4 color, Shader shader) {
		bind(x, y, width, height, color, shader);
	}
	
	private native void bind(float x, float y, float width, float height, Vector4 color, Shader shader);
	
}

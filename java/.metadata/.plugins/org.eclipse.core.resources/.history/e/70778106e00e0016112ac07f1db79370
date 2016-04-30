package sp.sparky4j.core.graphics;

import sp.sparky4j.core.maths.Vector4;

public class Sprite extends Renderable2D {
	
	public Sprite(float x, float y, float width, float height, Vector4 color) {
		nativeHandle = bind(x, y, width, height, color.x, color.y, color.z, color.w);
	}
	
	public Sprite(float x, float y, float width, float height, Texture texture) {
		nativeHandle = bind(x, y, width, height, texture.getNativeHandler());
	}
	
	private static native long bind(float x, float y,
									float width, float height,
									float xColor, float yColor, float zColor, float wColor);
	
	private static native long bind(float x, float y,
									float width, float height,
									long texture);

	
}

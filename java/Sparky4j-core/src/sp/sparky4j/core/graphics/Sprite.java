package sp.sparky4j.core.graphics;

public class Sprite extends Renderable2D {
	
	public Sprite(float x, float y, float width, float height, int color) {
		nativeHandle = bind(x, y, width, height, color);
	}
	
	public Sprite(float x, float y, float width, float height, Texture texture) {
		nativeHandle = bind(x, y, width, height, texture.getNativeHandler());
	}
	
	private static native long bind(float x, float y,
									float width, float height,
									int color);
	
	private static native long bind(float x, float y,
									float width, float height,
									long texture);

	
}

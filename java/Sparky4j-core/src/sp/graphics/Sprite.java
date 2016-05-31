package sp.graphics;

import sp.maths.Vector2;
import sp.maths.Vector3;
import sp.maths.Vector4;

public class Sprite extends Renderable2D {
	
	private Vector3 position;
	private Vector2 size;
	
	public Sprite(Texture texture) {
		super(bind(0.0f, 0.0f, texture.getWidth(), texture.getHeight(), texture.getNativeHandler()));
		position = new Vector3(0.0f, 0.0f, 0.0f);
		size = new Vector2(texture.getWidth(), texture.getHeight());
	}
	
	public Sprite(float x, float y, Texture texture) {
		super(bind(x, y, texture.getWidth(), texture.getHeight(), texture.getNativeHandler()));
		position = new Vector3(x, y, 0.0f);
		size = new Vector2(texture.getWidth(), texture.getHeight());		
	}
	
	public Sprite(float x, float y, float width, float height, int color) {
		super(bind(x, y, width, height, color));
		position = new Vector3(x, y, 0.0f);
		size = new Vector2(width, height);
	}
	
	public Sprite(float x, float y, float width, float height, Vector4 color) {
		super(bind(x, y, width, height, calculateColor(color)));
		position = new Vector3(x, y, 0.0f);
		size = new Vector2(width, height);
	}
	
	public Sprite(float x, float y, float width, float height, Texture texture) {
		super(bind(x, y, width, height, texture.getNativeHandler()));
		position = new Vector3(x, y, 0.0f);
		size = new Vector2(width, height);
	}
	
	public Vector3 getPosition() {
		return position;
	}
	
	public Vector2 getSize() {
		return size;
	}
	
	public void move(float x, float y) {
		position.x += x;
		position.y += y;
		native_setPosition(getNativeHandler(), position.x, position.y, position.z);
	}
	
	public void setPosition(Vector3 position) {
		this.position = position;
		native_setPosition(getNativeHandler(), position.x, position.y, position.z);		
	}
	
	public void setSize(Vector2 size) {
		this.size = size;
		native_setSize(getNativeHandler(), size.x, size.y);
	}
	
	private static native long bind(float x, float y, float width, float height, int color);
	private static native long bind(float x, float y, float width, float height, long texture);
	
	private static native void native_setPosition(long handler, float x, float y, float z);
	private static native void native_setSize(long handler, float x, float y);
	
	private static int calculateColor(Vector4 color) {
		int r = (int)(color.x * 255.0f);
		int g = (int)(color.y * 255.0f);
		int b = (int)(color.z * 255.0f);
		int a = (int)(color.w * 255.0f);
		return a << 24 | b << 16 | g << 8 | r;
	}
	
	// TODO set UV
	
}

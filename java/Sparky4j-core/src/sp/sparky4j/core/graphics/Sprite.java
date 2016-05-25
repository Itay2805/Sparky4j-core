package sp.sparky4j.core.graphics;

import sp.sparky4j.core.maths.Vector3;

public class Sprite extends Renderable2D {
	
	private Vector3 position;
	
	public Sprite(float x, float y, float width, float height, int color) {
		nativeHandle = bind(x, y, width, height, color);
		this.position = new Vector3(x, y, 0);
	}
	
	public Sprite(float x, float y, float width, float height, Texture texture) {
		nativeHandle = bind(x, y, width, height, texture.getNativeHandler());
		this.position = new Vector3(x, y, 0);
	}
	
	private static native long bind(float x, float y,
									float width, float height,
									int color);
	
	private static native long bind(float x, float y,
									float width, float height,
									long texture);
	
	public void move(float x, float y) {
		position.x += x;
		position.y += y;
		native_set_position(nativeHandle, position.x, position.y, position.z);
	}
	
	public void move(float x, float y, float z) {
		position.x += x;
		position.y += y;
		position.z += z;
		native_set_position(nativeHandle, position.x, position.y, position.z);
	}
	
	public void setPosition(Vector3 position) {
		this.position = position;
		native_set_position(nativeHandle, position.x, position.y, position.z);		
	}
	
	public Vector3 getPosition() {
		return position;
	}
	
	private static native void native_set_position(long handle, float x, float y, float z);
	
}

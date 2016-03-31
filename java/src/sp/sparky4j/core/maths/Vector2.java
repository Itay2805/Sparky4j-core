package sp.sparky4j.core.maths;

public class Vector2 {
	
	private long nativeHandle;
	
	public Vector2() {
		bind(0, 0);
	}
	
	public Vector2(float x, float y) {
		bind(x, y);
	}
	
	private native void bind(float x, float y);
	
	public native Vector2 add(Vector2 other);
	public native Vector2 subtract(Vector2 other);
	public native Vector2 multiply(Vector2 other);
	public native Vector2 divide(Vector2 other);
	

	public String toString() {
		return "vec2: (" + x() + ", " + y() + ")";
	}
	
	public native float x();
	public native float y();
	
	public native void x(float x);
	public native void y(float y);
	
}

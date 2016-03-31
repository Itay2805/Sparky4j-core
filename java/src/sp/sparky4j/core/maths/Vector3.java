package sp.sparky4j.core.maths;

public class Vector3 {
	
	private long nativeHandle;
	
	public Vector3() {
		bind(0, 0, 0);
	}
	
	public Vector3(float x, float y, float z) {
		bind(x, y, z);
	}
	
	private native void bind(float x, float y, float z);
	
	public native Vector3 add(Vector3 other);
	public native Vector3 subtract(Vector3 other);
	public native Vector3 multiply(Vector3 other);
	public native Vector3 divide(Vector3 other);
	

	public String toString() {
		return "vec3: (" + x() + ", " + y() + ", " + z() + ")";
	}
	
	public native float x();
	public native float y();
	public native float z();

	public native void x(float x);
	public native void y(float y);
	public native void z(float z);
	
}

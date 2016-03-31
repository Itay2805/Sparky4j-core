package sp.sparky4j.core.maths;

public class Vector4 {
	
	private long nativeHandle;
	
	public Vector4() {
		bind(0, 0, 0, 0);
	}
	
	public Vector4(float x, float y, float z, float w) {
		bind(x, y, z, w);
	}
	
	private native void bind(float x, float y, float z, float w);
	
	public native Vector4 add(Vector4 other);
	public native Vector4 subtract(Vector4 other);
	public native Vector4 multiply(Vector4 other);
	public native Vector4 divide(Vector4 other);
	

	public String toString() {
		return "vec4: (" + x() + ", " + y() + ", " + z() + ", " + w() + ")";
	}
	
	public native float x();
	public native float y();
	public native float z();
	public native float w();

	public native void x(float x);
	public native void y(float y);
	public native void z(float z);
	public native void w(float w);

}

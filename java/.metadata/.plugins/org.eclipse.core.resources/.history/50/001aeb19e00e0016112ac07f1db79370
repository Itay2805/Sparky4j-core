package sp.sparky4j.core.graphics;

import sp.sparky4j.core.maths.Matrix4;
import sp.sparky4j.core.maths.Vector2;
import sp.sparky4j.core.maths.Vector3;
import sp.sparky4j.core.maths.Vector4;

public class Shader {
	
	private long nativeHandler;
	
	public Shader(String vertPath, String fragPath) {
		nativeHandler = bind(vertPath, fragPath);
	}
	
	private static native long bind(String vertPath, String fragPath);
	
	public void setUniform1f(String name, float value) {
		native_setUniform1f(nativeHandler, name, value);
	}
	
	public void setUniform1fv(String name, float[] value, int count) {
		native_setUniform1fv(nativeHandler, name, value, count);
	}
	
	public void setUniform1i(String name, int value) {
		native_setUniform1i(nativeHandler, name, value);
	}
	
	public void setUniform1iv(String name, int[] value, int count) {
		native_setUniform1iv(nativeHandler, name, value, count);
	}
	
	public void setUniform2f(String name, Vector2 vector) {
		native_setUniform2f(nativeHandler, name, vector.x, vector.y);
	}
	
	public void setUniform3f(String name, Vector3 vector) {
		native_setUniform3f(nativeHandler, name, vector.x, vector.y, vector.z);
	}
	
	public void setUniform4f(String name, Vector4 vector) {
		native_setUniform4f(nativeHandler, name, vector.x, vector.y, vector.z, vector.w);
	}
	
	public void setUniformMat4(String name, Matrix4 matrix) {
		native_setUniformMat4(nativeHandler, name, matrix.elements);
	}
	
	public static native void native_setUniform1f(long handler, String name, float value);
	public static native void native_setUniform1fv(long handler, String name, float[] value, int count);
	public static native void native_setUniform1i(long handler, String name, int value);
	public static native void native_setUniform1iv(long handler, String name, int[] value, int count);
	public static native void native_setUniform2f(long handler, String name, float x, float y);
	public static native void native_setUniform3f(long handler, String name, float x, float y, float z);
	public static native void native_setUniform4f(long handler, String name, float x, float y, float z, float w);
	public static native void native_setUniformMat4(long handler, String name, float[] matrix);
	
	public void enable() {
		native_enable(nativeHandler);
	}
	
	public void disable() {
		native_disable(nativeHandler);
	}
	
	private static native void native_enable(long handler);
	private static native void native_disable(long handler);
	
	public long getNativeHandler() {
		return nativeHandler;
	}
	
}

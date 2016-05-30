package sp.graphics.shaders;

import com.itay.wrapper.NativeClass;

import sp.maths.Matrix4;
import sp.maths.Vector2;
import sp.maths.Vector3;
import sp.maths.Vector4;
import sp.utils.FileUtils;

public class Shader extends NativeClass {

	public Shader(String name, String source) {
		super(bind(name, source));
	}
	
	private static native long bind(String name, String source);
	
	public void setUniform1f(String name, float value) { native_setUniform1f(getNativeHandler(), name, value); }
	public void setUniform1fv(String name, float[] values, int count) { native_setUniform1fv(getNativeHandler(), name, values, count); }
	public void setUniform1i(String name, int value) { native_setUniform1i(getNativeHandler(), name, value); }
	public void setUniform1iv(String name, int[] values, int count) { native_setUniform1iv(getNativeHandler(), name, values, count); }
	public void setUniform2f(String name, Vector2 vector) { native_setUniform2f(getNativeHandler(), name, vector.x, vector.y); }
	public void setUniform3f(String name, Vector3 vector) { native_setUniform3f(getNativeHandler(), name, vector.x, vector.y, vector.z); }
	public void setUniform4f(String name, Vector4 vector) { native_setUniform4f(getNativeHandler(), name, vector.x, vector.y, vector.z, vector.w); }
	public void setUniformMat4(String name, Matrix4 matrix) { native_setUniformMat4(getNativeHandler(), name, matrix.elements); }
	
	public void bind() { native_bind(getNativeHandler()); }
	public void unbind() { native_unbind(getNativeHandler()); }
	
	private static native void native_setUniform1f(long handler, String name, float value);
	private static native void native_setUniform1fv(long handler, String name, float[] values, int count);
	private static native void native_setUniform1i(long handler, String name, int value);
	private static native void native_setUniform1iv(long handler, String name, int[] values, int count);
	private static native void native_setUniform2f(long handler, String name, float x, float y);
	private static native void native_setUniform3f(long handler, String name, float x, float y, float z);
	private static native void native_setUniform4f(long handler, String name, float x, float y, float z, float w);
	private static native void native_setUniformMat4(long handler, String name, float[] elements);
	
	private static native void native_bind(long handler);
	private static native void native_unbind(long handler);
	
	public static Shader fromFile(String name, String filepath) {
		String shader = FileUtils.readFile(filepath);
		return new Shader(name, shader);
	}
	
	public static Shader fromSource(String name, String source) {
		return new Shader(name, source);
	}
	
}

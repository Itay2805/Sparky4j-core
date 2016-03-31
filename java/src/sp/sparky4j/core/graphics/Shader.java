package sp.sparky4j.core.graphics;

import sp.sparky4j.core.maths.Matrix4;
import sp.sparky4j.core.maths.Vector2;
import sp.sparky4j.core.maths.Vector3;
import sp.sparky4j.core.maths.Vector4;

public class Shader {
	
	private long nativeHandle;
	
	public Shader(String vertPath, String fragPath) {
		bind(vertPath, fragPath);
	}
	
	private native void bind(String vertPath, String fragPath);
	
	public native void setUniform1f(String name, float value);
	public native void setUniform1i(String name, int value);
	public native void setUniform2f(String name, Vector2 vector);
	public native void setUniform3f(String name, Vector3 vector);
	public native void setUniform4f(String name, Vector4 vector);
	public native void setUniformMat4(String name, Matrix4 matrix);
	
	public native void enable();
	public native void disable();
	
}

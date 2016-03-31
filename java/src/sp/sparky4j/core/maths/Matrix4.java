package sp.sparky4j.core.maths;

public class Matrix4 {
	
	private long nativeHandle;
	
	public Matrix4() {
		bind();
	}
	
	public Matrix4(float diagonal) {
		bind(diagonal);	
	}
	
	private native void bind();
	private native void bind(float diagonal);
	
	public native Matrix4 multiply(Matrix4 other);
	
	public native float elements(int i);
	public native void elements(int i, float value);
	public native Vector4 getColumn(int i);
	
	public static Matrix4 identity() {
		return new Matrix4(1.0f);
	}
	
	public static Matrix4 orthographic(float left, float right, float bottom, float top, float near, float far) {
		Matrix4 result = new Matrix4(1.0f);
		
		result.elements(0 + 0 * 4, 2.0f / (right - left));
		
		result.elements(1 + 1 * 4, 2.0f / (top - bottom));
		
		result.elements(2 + 2 * 4, 2.0f / (near - far));
		
		result.elements(0 + 3 * 4, (left + right) / (left - right));
		result.elements(1 + 3 * 4, (bottom + top) / (bottom - top));
		result.elements(2 + 3 * 4, (far + near) / (far - near));
		
		return result;
	}
	
	public static Matrix4 perspective(float fov, float aspectRatio, float near, float far) {
		Matrix4 result = new Matrix4(1.0f);
		
		float q = (float) (1.0f / Math.tan(Math.toRadians(0.5f * fov)));
		float a = q / aspectRatio;

		float b = (near + far) / (near - far);
		float c = (2.0f * near * far) / (near - far);
		
		result.elements(0 + 0 * 4, a);
		result.elements(1 + 1 * 4, q);
		result.elements(2 + 2 * 4, b);
		result.elements(3 + 2 * 4, -1.0f);
		result.elements(2 + 3 * 4, c);
		
		return result;
	}
	
	public static Matrix4 translation(Vector3 translation) {
		Matrix4 result = new Matrix4(1.0f);
		
		result.elements(0 + 3 * 4, translation.x());
		result.elements(1 + 3 * 4, translation.y());
		result.elements(2 + 3 * 4, translation.z());
		
		return result;
	}
	
	public static Matrix4 rotation(float angle, Vector3 axis) {
		Matrix4 result = new Matrix4(1.0f);
		
		float r = (float) Math.toRadians(angle);
		float c = (float) Math.cos(r);
		float s = (float) Math.sin(r);
		float omc = 1.0f - c;

		float x = axis.x();
		float y = axis.y();
		float z = axis.z();
		
		result.elements(0 + 0 * 4, x * omc + c);
		result.elements(1 + 0 * 4, y * x * omc + z * s);
		result.elements(2 + 0 * 4, x * z * omc - y * s);

		result.elements(0 + 1 * 4, x * y * omc - z * s);
		result.elements(1 + 1 * 4, y * omc + c);
		result.elements(2 + 1 * 4, y * z * omc + x * s);

		result.elements(0 + 2 * 4, x * z * omc + y * s);
		result.elements(1 + 2 * 4, y * z * omc - x * s);
		result.elements(2 + 2 * 4, z * omc + c);
		
		return result;
	}
	
	public static Matrix4 scale(Vector3 scale) {
		Matrix4 result = new Matrix4(1.0f);
		
		result.elements(0 + 0 * 4, scale.x());
		result.elements(1 + 1 * 4, scale.y());
		result.elements(2 + 2 * 4, scale.z());
		
		return result;
	}

}

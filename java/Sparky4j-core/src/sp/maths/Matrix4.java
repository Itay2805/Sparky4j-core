package sp.maths;

public class Matrix4 {
	
	public float[] elements = new float[4 * 4];
	
	public Matrix4() {
		for(int i = 0; i < 4 * 4; i++)
			elements[i] = 0.0f;
	}
	
	public Matrix4(float diagonal) {
		for(int i = 0; i < 4 * 4; i++)
			elements[i] = 0.0f;
		
		elements[0 + 0 * 4] = diagonal;
		elements[1 + 1 * 4] = diagonal;
		elements[2 + 2 * 4] = diagonal;
		elements[3 + 3 * 4] = diagonal;
	}
	
	public Matrix4(float[] elements) {
		for(int i = 0; i < 4 * 4; i++)
			this.elements[i] = elements[i];
	}
	
	public Vector4 getColumn(int index) {
		index *= 4;
		return new Vector4(elements[index], elements[index + 1], elements[index + 2], elements[index + 3]);
	}
	
	public static Matrix4 identity() {
		return new Matrix4(1.0f);
	}
	
	public Matrix4 multiply(Matrix4 other) {
		float[] data = new float[16];
		for(int y = 0; y < 4; y++) {
			for(int x = 0; x < 4; x++) {
				float sum = 0.0f;
				for(int e = 0; e < 4; e++) {
					sum += elements[x + e * 4] * other.elements[e + y * 4];
				}
				data[x + y * 4] = sum;
			}
		}
		
		for(int i = 0; i < 4 * 4; i++)
			elements[i] = data[i];
		
		return this;
	}
	
	public Vector3 multiply(Vector3 other) {
		return new Vector3(
				getColumn(0).x * other.x + getColumn(1).x * other.y + getColumn(2).x * other.z + getColumn(3).x,
				getColumn(0).y * other.x + getColumn(1).y * other.y + getColumn(2).y * other.z + getColumn(3).y,
				getColumn(0).z * other.x + getColumn(1).z * other.y + getColumn(2).z * other.z + getColumn(3).z
			);
	}
	
	public Vector4 multiply(Vector4 other) {
		return new Vector4(
				getColumn(0).x * other.x + getColumn(1).x * other.y + getColumn(2).x * other.z + getColumn(3).x * other.w,
				getColumn(0).y * other.x + getColumn(1).y * other.y + getColumn(2).y * other.z + getColumn(3).y * other.w,
				getColumn(0).z * other.x + getColumn(1).z * other.y + getColumn(2).z * other.z + getColumn(3).z * other.w,
				getColumn(0).w * other.x + getColumn(1).w * other.y + getColumn(2).w * other.z + getColumn(3).w * other.w
			);
	}
	
	public Matrix4 invert() {
		double[] temp = new double[16];
		
		temp[0] = elements[5] * elements[10] * elements[15] -
				elements[5] * elements[11] * elements[14] -
				elements[9] * elements[6] * elements[15] +
				elements[9] * elements[7] * elements[14] +
				elements[13] * elements[6] * elements[11] -
				elements[13] * elements[7] * elements[10];

		temp[4] = -elements[4] * elements[10] * elements[15] +
				elements[4] * elements[11] * elements[14] +
				elements[8] * elements[6] * elements[15] -
				elements[8] * elements[7] * elements[14] -
				elements[12] * elements[6] * elements[11] +
				elements[12] * elements[7] * elements[10];

		temp[8] = elements[4] * elements[9] * elements[15] -
				elements[4] * elements[11] * elements[13] -
				elements[8] * elements[5] * elements[15] +
				elements[8] * elements[7] * elements[13] +
				elements[12] * elements[5] * elements[11] -
				elements[12] * elements[7] * elements[9];

		temp[12] = -elements[4] * elements[9] * elements[14] +
				elements[4] * elements[10] * elements[13] +
				elements[8] * elements[5] * elements[14] -
				elements[8] * elements[6] * elements[13] -
				elements[12] * elements[5] * elements[10] +
				elements[12] * elements[6] * elements[9];

		temp[1] = -elements[1] * elements[10] * elements[15] +
				elements[1] * elements[11] * elements[14] +
				elements[9] * elements[2] * elements[15] -
				elements[9] * elements[3] * elements[14] -
				elements[13] * elements[2] * elements[11] +
				elements[13] * elements[3] * elements[10];

		temp[5] = elements[0] * elements[10] * elements[15] -
				elements[0] * elements[11] * elements[14] -
				elements[8] * elements[2] * elements[15] +
				elements[8] * elements[3] * elements[14] +
				elements[12] * elements[2] * elements[11] -
				elements[12] * elements[3] * elements[10];

		temp[9] = -elements[0] * elements[9] * elements[15] +
				elements[0] * elements[11] * elements[13] +
				elements[8] * elements[1] * elements[15] -
				elements[8] * elements[3] * elements[13] -
				elements[12] * elements[1] * elements[11] +
				elements[12] * elements[3] * elements[9];

		temp[13] = elements[0] * elements[9] * elements[14] -
				elements[0] * elements[10] * elements[13] -
				elements[8] * elements[1] * elements[14] +
				elements[8] * elements[2] * elements[13] +
				elements[12] * elements[1] * elements[10] -
				elements[12] * elements[2] * elements[9];

		temp[2] = elements[1] * elements[6] * elements[15] -
				elements[1] * elements[7] * elements[14] -
				elements[5] * elements[2] * elements[15] +
				elements[5] * elements[3] * elements[14] +
				elements[13] * elements[2] * elements[7] -
				elements[13] * elements[3] * elements[6];

		temp[6] = -elements[0] * elements[6] * elements[15] +
				elements[0] * elements[7] * elements[14] +
				elements[4] * elements[2] * elements[15] -
				elements[4] * elements[3] * elements[14] -
				elements[12] * elements[2] * elements[7] +
				elements[12] * elements[3] * elements[6];

		temp[10] = elements[0] * elements[5] * elements[15] -
				elements[0] * elements[7] * elements[13] -
				elements[4] * elements[1] * elements[15] +
				elements[4] * elements[3] * elements[13] +
				elements[12] * elements[1] * elements[7] -
				elements[12] * elements[3] * elements[5];

		temp[14] = -elements[0] * elements[5] * elements[14] +
				elements[0] * elements[6] * elements[13] +
				elements[4] * elements[1] * elements[14] -
				elements[4] * elements[2] * elements[13] -
				elements[12] * elements[1] * elements[6] +
				elements[12] * elements[2] * elements[5];

		temp[3] = -elements[1] * elements[6] * elements[11] +
				elements[1] * elements[7] * elements[10] +
				elements[5] * elements[2] * elements[11] -
				elements[5] * elements[3] * elements[10] -
				elements[9] * elements[2] * elements[7] +
				elements[9] * elements[3] * elements[6];

		temp[7] = elements[0] * elements[6] * elements[11] -
				elements[0] * elements[7] * elements[10] -
				elements[4] * elements[2] * elements[11] +
				elements[4] * elements[3] * elements[10] +
				elements[8] * elements[2] * elements[7] -
				elements[8] * elements[3] * elements[6];

		temp[11] = -elements[0] * elements[5] * elements[11] +
				elements[0] * elements[7] * elements[9] +
				elements[4] * elements[1] * elements[11] -
				elements[4] * elements[3] * elements[9] -
				elements[8] * elements[1] * elements[7] +
				elements[8] * elements[3] * elements[5];

		temp[15] = elements[0] * elements[5] * elements[10] -
				elements[0] * elements[6] * elements[9] -
				elements[4] * elements[1] * elements[10] +
				elements[4] * elements[2] * elements[9] +
				elements[8] * elements[1] * elements[6] -
				elements[8] * elements[2] * elements[5];
		
		double determinant = elements[0] * temp[0] + elements[1] * temp[4] + elements[2] * temp[8] + elements[3] * temp[12];
		determinant = 1.0 / determinant;
		
		for(int i = 0; i < 4 * 4; i++)
			elements[i] = (float) (temp[i] * determinant);
		
		return this;
	}
	
	public static Matrix4 orthographic(float left, float right, float bottom, float top, float near , float far) {
		Matrix4 result = new Matrix4(1.0f);
		
		result.elements[0 + 0 * 4] = 2.0f / (right - left);

		result.elements[1 + 1 * 4] = 2.0f / (top - bottom);

		result.elements[2 + 2 * 4] = 2.0f / (near - far);

		result.elements[0 + 3 * 4] = (left + right) / (left - right);
		result.elements[1 + 3 * 4] = (bottom + top) / (bottom - top);
		result.elements[2 + 3 * 4] = (far + near) / (far - near);
		
		return result;
	}
	
	public static Matrix4 prespective(float fov, float aspectRatio, float near, float far) {
		Matrix4 result = new Matrix4(1.0f);
		
		float q = (float) (1.0f / Math.tan(Math.toRadians(0.5f * fov)));
		float a = q / aspectRatio;

		float b = (near + far) / (near - far);
		float c = (2.0f * near * far) / (near - far);

		result.elements[0 + 0 * 4] = a;
		result.elements[1 + 1 * 4] = q;
		result.elements[2 + 2 * 4] = b;
		result.elements[3 + 2 * 4] = -1.0f;
		result.elements[2 + 3 * 4] = c;
		
		return result;
	}
	
	public static Matrix4 translate(Vector3 translation) {
		Matrix4 result = new Matrix4(1.0f);
		
		result.elements[0 + 3 * 4] = translation.x;
		result.elements[1 + 3 * 4] = translation.y;
		result.elements[2 + 3 * 4] = translation.z;
		
		return result;
	}
	
	public static Matrix4 rotate(float angle, Vector3 axis) {
		Matrix4 result = new Matrix4(1.0f);
		
		float r = (float) Math.toRadians(angle);
		float c = (float) Math.cos(r);
		float s = (float) Math.sin(r);
		float omc = 1.0f - c;
		
		float x = axis.x;
		float y = axis.y;
		float z = axis.z;

		result.elements[0 + 0 * 4] = x * omc + c;
		result.elements[1 + 0 * 4] = y * x * omc + z * s;
		result.elements[2 + 0 * 4] = x * z * omc - y * s;

		result.elements[0 + 1 * 4] = x * y * omc - z * s;
		result.elements[1 + 1 * 4] = y * omc + c;
		result.elements[2 + 1 * 4] = y * z * omc + x * s;

		result.elements[0 + 2 * 4] = x * z * omc + y * s;
		result.elements[1 + 2 * 4] = y * z * omc - x * s;
		result.elements[2 + 2 * 4] = z * omc + c;
		
		return result;
	}
	
	public static Matrix4 scale(Vector3 scale) {
		Matrix4 result = new Matrix4(1.0f);
		
		result.elements[0 + 0 * 4] = scale.x;
		result.elements[1 + 1 * 4] = scale.y;
		result.elements[2 + 2 * 4] = scale.z;
		
		return result;
	}
	
	public static Matrix4 invert(Matrix4 matrix) {
		Matrix4 result = matrix;
		return result.invert();		
	}
	
}

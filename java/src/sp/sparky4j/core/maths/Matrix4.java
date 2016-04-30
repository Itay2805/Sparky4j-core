package sp.sparky4j.core.maths;

public class Matrix4 {
	
	public float[] elements = new float[4 * 4];
	
	public Matrix4() {
		for (int i = 0; i < 4 * 4; i++)
			elements[i] = 0.0f;
	}

	public Matrix4(float diagonal) {
		for (int i = 0; i < 4 * 4; i++)
			elements[i] = 0.0f;
		elements[0 + 0 * 4] = diagonal;
		elements[1 + 1 * 4] = diagonal;
		elements[2 + 2 * 4] = diagonal;
		elements[3 + 3 * 4] = diagonal;
	}
	
	public Matrix4(float[] elements) {
		for (int i = 0; i < 4 * 4; i++)
			this.elements[i] = elements[i];
	}
	
	public Vector4 getColum(int index) {
		return new Vector4(
					elements[index + 0 * 4],
					elements[index + 1 * 4],
					elements[index + 2 * 4],
					elements[index + 3 * 4]
				);
	}

	public Matrix4 multiply(Matrix4 other) {
		float[] data = new float[4 * 4];
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				float sum = 0.0f;
				for (int e = 0; e < 4; e++) {
					sum += elements[x + e * 4] * other.elements[e + y * 4];
				}
				data[x + y * 4] = sum;
			}
		}
		System.arraycopy(data, 0, elements, 0, 4 * 4);
		return this;
	}
	
	public Vector3 multiply(Vector3 other) {
		Vector4 col0 = getColum(0);
		Vector4 col1 = getColum(1);
		Vector4 col2 = getColum(2);
		Vector4 col3 = getColum(3);
		return new Vector3(
				col0.x * other.x + col1.x * other.y + col2.x * other.z + col3.x,
				col0.y * other.x + col1.y * other.y + col2.y * other.z + col3.y,
				col0.z * other.x + col1.z * other.y + col2.z * other.z + col3.z
				);
	}
	
	public Vector4 multiply(Vector4 other) {
		Vector4 col0 = getColum(0);
		Vector4 col1 = getColum(1);
		Vector4 col2 = getColum(2);
		Vector4 col3 = getColum(3);
		return new Vector4(
					col0.x * other.x + col1.x * other.y + col2.x * other.z + col3.x * other.w,
				 	col0.y * other.x + col1.y * other.y + col2.y * other.z + col3.y * other.w,
				 	col0.z * other.x + col1.z * other.y + col2.z * other.z + col3.z * other.w,
				 	col0.w * other.x + col1.w * other.y + col2.w * other.z + col3.w * other.w
				 );
	}
	
	public static Matrix4 identity() {
		return new Matrix4(1.0f);
	}

	public static Matrix4 orthographic(float left, float right, float bottom, float top, float near, float far) {
		Matrix4 result = new Matrix4(1.0f);

		result.elements[0 + 0 * 4] = 2.0f / (right - left);
		result.elements[1 + 1 * 4] = 2.0f / (top - bottom);
		result.elements[2 + 2 * 4] = 2.0f / (near - far);
		result.elements[0 + 3 * 4] = (left + right) / (left - right);
		result.elements[1 + 3 * 4] = (bottom + top) / (bottom - top);
		result.elements[2 + 3 * 4] = (far + near) / (far - near);

		return result;
	}

	public static Matrix4 perspective(float fov, float aspectRatio, float near, float far) {
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

	public static Matrix4 translation(Vector3 translation) {
		Matrix4 result = new Matrix4(1.0f);

		result.elements[0 + 3 * 4] = translation.x;
		result.elements[1 + 3 * 4] = translation.y;
		result.elements[2 + 3 * 4] = translation.z;

		return result;
	}

	public static Matrix4 rotation(float angle, Vector3 axis) {
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
	
}

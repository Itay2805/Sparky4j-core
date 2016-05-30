package sp.maths;

public class Vector4 {
	
	public float x, y, z, w;
	
	public Vector4() {
		y = 0.0f;
		x = 0.0f;
		z = 0.0f;
		w = 0.0f;
	}

	public Vector4(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public Vector4 add(Vector4 other) {
		x += other.x;
		y += other.y;
		z += other.z;
		w += other.w;
		return this;
	}
	
	public Vector4 subtract(Vector4 other) {
		x -= other.x;
		y -= other.y;
		z -= other.z;
		w -= other.w;
		return this;
	}
	
	public Vector4 multiply(Vector4 other) {
		x *= other.x;
		y *= other.y;
		z *= other.z;
		w *= other.w;
		return this;
	}
	
	public Vector4 divide(Vector4 other) {
		x /= other.x;
		y /= other.y;
		z /= other.z;
		w /= other.w;
		return this;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Vector4) {
			Vector4 other = (Vector4)obj;
			return other.x == this.x && other.y == this.y && other.z == this.z && other.w == this.w;
		}
		return false;
	}
	
	public String toString() {
		return "vec4: (" + x + ", " + y + ", " + z + ", " + w + ")";
	}
	
}

package sp.sparky4j.core.maths;

public class Vector4 {
	
	public float x, y, z, w;
	
	public Vector4() {
		this.x = 0.0f;
		this.y = 0.0f;
		this.z = 0.0f;
		this.w = 0.0f;
	}
	
	public Vector4(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public Vector4 add(Vector4 other) {
		this.x += other.x;
		this.y += other.y;
		this.z += other.z;
		this.w += other.w;
		return this;
	}
	
	public Vector4 subtract(Vector4 other) {
		this.x -= other.x;
		this.y -= other.y;
		this.z -= other.z;
		this.w -= other.w;
		return this;
	}
	
	public Vector4 multiply(Vector4 other) {		
		this.x *= other.x;
		this.y *= other.y;
		this.z *= other.z;
		this.w *= other.w;
		return this;
	}
	
	public Vector4 devide(Vector4 other) {		
		this.x /= other.x;
		this.y /= other.y;
		this.z /= other.z;
		this.w /= other.w;
		return this;
	}
	
	public String toString() {
		return "vec4: (" + x + ", " + y + ", " + z + ", " + w + ")";
	}
	
}

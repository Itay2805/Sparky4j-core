package sp.sparky4j.core.maths;

public class Vector3 {
	
	public float x, y, z;
	
	public Vector3() {
		this.x = 0.0f;
		this.y = 0.0f;
		this.z = 0.0f;
	}
	
	public Vector3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3(Vector2 other) {
		this.x = other.x;
		this.y = other.y;
		this.z = 0;
	}
	
	public Vector3 add(Vector3 other) {
		this.x += other.x;
		this.y += other.y;
		this.z += other.z;
		return this;
	}
	
	public Vector3 subtract(Vector3 other) {
		this.x -= other.x;
		this.y -= other.y;
		this.z -= other.z;
		return this;
	}
	
	public Vector3 multiply(Vector3 other) {		
		this.x *= other.x;
		this.y *= other.y;
		this.z *= other.z;
		return this;
	}
	
	public Vector3 devide(Vector3 other) {		
		this.x /= other.x;
		this.y /= other.y;
		this.z /= other.z;
		return this;
	}
	
	public float distance(Vector3 other) {
		float a = x - other.x;
		float b = y - other.y;
		float c = z - other.z;
		return (float) Math.sqrt(a * a + b * b + c * c);
	}
	
	public String toString() {
		return "vec3: (" + x + ", " + y + ", " + z + ")";
	}
	
}

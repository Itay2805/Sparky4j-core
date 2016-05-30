package sp.maths;

public class Vector3 {
	
	public float x, y, z;
	
	public Vector3() {
		y = 0.0f;
		x = 0.0f;
		z = 0.0f;
	}

	public Vector3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3(Vector2 vector) {
		this.x = vector.x;
		this.y = vector.y;
		this.z = 0;
	}
	
	public Vector3 add(Vector3 other) {
		x += other.x;
		y += other.y;
		z += other.z;
		return this;
	}
	
	public Vector3 subtract(Vector3 other) {
		x -= other.x;
		y -= other.y;
		z -= other.z;
		return this;
	}
	
	public Vector3 multiply(Vector3 other) {
		x *= other.x;
		y *= other.y;
		z *= other.z;
		return this;
	}
	
	public Vector3 divide(Vector3 other) {
		x /= other.x;
		y /= other.y;
		z /= other.z;
		return this;
	}
	
	public boolean largerThan(Vector3 other) {
		return x > other.x && y > other.y && z > other.z;
	}
	
	public boolean smallerThan(Vector3 other) {
		return x < other.x && y < other.y && z < other.z;			
	}
	
	public float distance(Vector3 other) {
		float a = x - other.x;
		float b = y - other.y;
		float c = z - other.z;
		return (float) Math.sqrt(a * a + b * b + c * c);
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Vector3) {
			Vector3 other = (Vector3)obj;
			return other.x == this.x && other.y == this.y && other.z == this.z;
		}
		return false;
	}
	
	public String toString() {
		return "vec3: (" + x + ", " + y + ", " + z + ")";
	}
	
}

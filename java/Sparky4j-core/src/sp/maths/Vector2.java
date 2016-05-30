package sp.maths;

public class Vector2 {
	
	public float x, y;
	
	public Vector2() {
		y = 0.0f;
		x = 0.0f;
	}

	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2(Vector3 vector) {
		this.x = vector.x;
		this.y = vector.y;
	}
	
	public Vector2 add(Vector2 other) {
		x += other.x;
		y += other.y;
		return this;
	}
	
	public Vector2 subtract(Vector2 other) {
		x -= other.x;
		y -= other.y;
		return this;
	}
	
	public Vector2 multiply(Vector2 other) {
		x *= other.x;
		y *= other.y;
		return this;
	}
	
	public Vector2 divide(Vector2 other) {
		x /= other.x;
		y /= other.y;
		return this;
	}

	public float magnitude() {
		return (float) Math.sqrt(x * x + y * y);
	}
	
	public Vector2 normalise() {
		float length = magnitude();
		return new Vector2(x / length, y / length);
	}
	
	public float distance(Vector2 other) {
		float a = x - other.x;
		float b = y - other.y;
		return (float) Math.sqrt(a * a + b * b);
	}
	
	public float dot(Vector2 other) {
		return x * other.x + y * other.y;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Vector2) {
			Vector2 other = (Vector2)obj;
			return other.x == this.x && other.y == this.y;
		}
		return false;
	}
	
	public String toString() {
		return "vec2: (" + x + ", " + y + ")";
	}
}

package sp.sparky4j.core.maths;

public class Vector2 {
	
	public float x, y;
	
	public Vector2() {
		this.x = 0.0f;
		this.y = 0.0f;
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
		this.x += other.x;
		this.y += other.y;
		return this;
	}
	
	public Vector2 subtract(Vector2 other) {
		this.x -= other.x;
		this.y -= other.y;
		return this;
	}
	
	public Vector2 multiply(Vector2 other) {		
		this.x *= other.x;
		this.y *= other.y;
		return this;
	}
	
	public Vector2 devide(Vector2 other) {		
		this.x /= other.x;
		this.y /= other.y;
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
	
	public String toString() {
		return "vec2: (" + x + ", " + y + ")";
	}
	
}

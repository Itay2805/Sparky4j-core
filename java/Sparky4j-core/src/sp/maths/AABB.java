package sp.maths;

public class AABB {
	
	public Vector3 min, max;
	
	public AABB() {
		min = new Vector3();
		max = new Vector3();
	}
	
	public AABB(Vector2 min, Vector2 max) {
		this.min = new Vector3(min);
		this.max = new Vector3(max);
	}
	
	public AABB(Vector3 min, Vector3 max) {
		this.min = min;
		this.max = max;
	}
	
	public boolean intersects(AABB other) {
		return (max.largerThan(other.min) && min.smallerThan(other.max) || (min.largerThan(other.max) && max.smallerThan(other.min)));
	}
	
	public boolean contains(Vector2 point) {
		return new Vector3(point).largerThan(min) && new Vector3(point).smallerThan(max);
	}
	
	public boolean contains(Vector3 point) {
		return point.largerThan(min) && point.smallerThan(max);
	}
	
	public Vector3 center() {
		return (min.subtract(max)).multiply(new Vector3(0.5f, 0.5f, 0.5f));
	}
	
	public boolean smallerThan(AABB other) {
		return max.smallerThan(other.min);
	}
	
	public boolean largerThan(AABB other) {
		return min.largerThan(other.max);
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AABB) {
			AABB other = (AABB) obj;
			return this.min.equals(other.min) && this.max.equals(other.max);
		}
		return false;
	}
	
}

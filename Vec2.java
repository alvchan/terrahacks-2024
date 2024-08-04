import java.lang.Math;

public class Vec2 {
	private double x;
	private double y;

	public Vec2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vec2(Vec2 other) {
		this.x = other.x;
		this.y = other.y;
	}

	public Vec2 add(Vec2 other) {
		return new Vec2(x + other.x, y + other.y);		
	}

	public Vec2 sub(Vec2 other) {
		return new Vec2(x - other.x, y - other.y);
	}

	public Vec2 mult(double factor) {
		return new Vec2(x * factor, y * factor);
	}

	public Vec2 divide(double divider) {
		return new Vec2(x / divider, y / divider);
	}

	public double mag() {
		return Math.sqrt(x*x + y*y);
	}

	public Vec2 normalize() {
		Vec2 unitVec = new Vec2(this);
		unitVec.divide(unitVec.mag());
		return unitVec;
	}
}

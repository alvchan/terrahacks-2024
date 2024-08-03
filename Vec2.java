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

	public void add(Vec2 other) {
		x += other.x;
		y += other.y;
		
	}

	public void sub(Vec2 other) {
		x -= other.x;
		y -= other.y;
	}

	public void mult(double factor) {
		x *= factor;
		y *= factor;
	}

	public void divide(double divider) {
		x /= divider;
		y /= divider;
	}

	public double mag() {
		return Math.sqrt(x ** 2 + y ** 2);
	}

	public Vec2 normalize() {
		Vec2 unitVec = new Vec2(this);
		unitVec.divide(mag(unitVec));
		return unitVec;
	}
}

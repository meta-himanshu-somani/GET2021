
public interface Shape {
	public abstract double getArea();
	public abstract double getPerimeter();
	public abstract double getOrigin();
	public abstract boolean isPointEnclosed();
}

enum ShapeType {
	Circle,
	Rectangle,
	Triangle,
	Squre;
}

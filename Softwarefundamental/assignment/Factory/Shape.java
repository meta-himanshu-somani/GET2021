
public interface Shape {
	/**
	 * 
	 * @return area of shape
	 */
	public abstract double getArea();
	/**
	 * 
	 * @return perimeter i.e. sum of shape side
	 */
	public abstract double getPerimeter();
	/**
	 * 
	 * @return distance from origin to starting point of shape
	 */
	public abstract double getOrigin();
	/**
	 * 
	 * @param point_x X coordinate of shape
	 * @param point_y Y coordinate of shape 
	 * @return true if point present in shape else false
	 */
	public abstract boolean isPointEnclosed(double point_x,double point_y);
}

enum ShapeType{
	Circle,
	Rectangle,
	Triangle,
	Squre;
}

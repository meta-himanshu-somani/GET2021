
public class Circle implements Shape {
	private double radius=0;
	private double PI=3.14;
	public Circle(double center_X,double center_Y,double radius) {
		// TODO Auto-generated constructor stub
		this.radius=radius;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return PI*this.radius*this.radius;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*PI*this.radius;
	}

	@Override
	public double getOrigin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isPointEnclosed() {
		// TODO Auto-generated method stub
		return false;
	}

}

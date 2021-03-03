
public class Rectangle implements Shape {
	private double length=0;
	private double height=0;
	public Rectangle(double LeftBottom_X,double LeftBottom_Y,
					 double RightUpper_X,double RightUpper_Y) {
		// TODO Auto-generated constructor stub
		this.length=RightUpper_X-LeftBottom_X;
		this.height=RightUpper_Y-LeftBottom_Y;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return this.length*this.height;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*(this.length+this.height);
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

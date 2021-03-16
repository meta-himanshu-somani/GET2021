
public class Circle implements Shape {
	private double radius=0;
	private double PI=3.14;
	private double center_X=0;
	private double center_Y=0;
	public Circle(double center_X,double center_Y,double radius) {
		// TODO Auto-generated constructor stub
		this.center_X=center_X;
		this.center_Y=center_Y;
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
		return Math.sqrt(((this.center_X-0)*(this.center_X-0))+ ((this.center_Y-0)*(this.center_Y-0)))-this.radius;
	}

	@Override
	public boolean isPointEnclosed(double point_x,double point_y) {
		// TODO Auto-generated method stub
		double distance= Math.sqrt(((this.center_X-point_x)*(this.center_X-point_x))+ ((this.center_Y-point_y)*(this.center_Y-point_y)));
		if(distance>=this.radius){
			return false;
		}else {
			return true;
		}
	}

}

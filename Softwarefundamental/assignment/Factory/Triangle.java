import java.lang.Math;
public class Triangle implements Shape {
	double x1=0;
	double y1=0;
	double x2=0;
	double y2=0;
	double x3=0;
	double y3=0;
	double side1=0;
	double side2=0;
	double side3=0;
	public Triangle(double d, double e, double f, double g, double h, double i) {
		// TODO Auto-generated constructor stub
		this.x1=d;this.y1=e;this.x2=f;this.y2=g;this.x3=h;this.y3=i;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		this.side1=Math.sqrt((this.x2-this.x1)*(this.x2-this.x1)+(this.y2-this.y1)*(this.y2-this.y1));
		this.side2=Math.sqrt((this.x3-this.x1)*(this.x3-this.x1)+(this.y3-this.y1)*(this.y3-this.y1));
		this.side3=Math.sqrt((this.x2-this.x3)*(this.x2-this.x3)+(this.y2-this.y3)*(this.y2-this.y3));
		double s=(this.side1+this.side2+this.side3)/3;
		double area=Math.sqrt(s*(s-this.side1)*(s-this.side2)*(s-this.side3));
		return area;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return this.side1+this.side2+this.side3;
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

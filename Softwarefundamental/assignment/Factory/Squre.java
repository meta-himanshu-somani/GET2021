
public class Squre implements Shape {
	private double length=0;
	private double height=0;
	private double x1=0;
	private double x2=0;
	private double y1=0;
	private double y2=0;
	public Squre(double LeftBottom_X,double LeftBottom_Y,double RightUpper_X,double RightUpper_Y) {
		// TODO Auto-generated constructor stub
		this.x1=LeftBottom_X;
		this.x2=RightUpper_X;
		this.y1=LeftBottom_Y;
		this.y2=RightUpper_Y;
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
		return 4*this.length;
	}

	@Override
	public double getOrigin() {
		// TODO Auto-generated method stub
		//distance from origin(x,y)-->(0,0)
		return Math.sqrt(((this.x1-0)*(this.x1-0))+ ((this.y1-0)*(this.y1-0)));//finding distance between two points
	}

	@Override
	public boolean isPointEnclosed(double point_x,double point_y) {
		// TODO Auto-generated method stub
		if (point_x > this.x1 && point_x < this.x2 &&  
			    point_y > this.y1 && point_y < this.y2) 
			    return true; 
			  
			return false; 
	}

}

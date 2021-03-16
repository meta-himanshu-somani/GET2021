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
		double length1=Math.sqrt(((this.x1-0)*(this.x1-0))+ ((this.y1-0)*(this.y1-0)));
		double length2=Math.sqrt(((this.x2-0)*(this.x2-0))+ ((this.y2-0)*(this.y2-0)));
		double length3=Math.sqrt(((this.x3-0)*(this.x3-0))+ ((this.y3-0)*(this.y3-0)));
		double miniLength=0;
		if(length1<length2 && length1<length3){
			miniLength=length1;
		}else if(length2<length1 && length2<length3){
			miniLength=length2;
		}else {
			miniLength= length3;
		}
		return miniLength;
	}
    private double getSpecificArea(double x1,double y1,double x2,double y2,double x3,double y3){
    	double side1=Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
		double side2=Math.sqrt((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1));
		double side3=Math.sqrt((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3));
		double s=(side1+side2+side3)/3;
		double area=Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
		return area;
    }
	@Override
	public boolean isPointEnclosed(double point_x,double point_y) {
		// TODO Auto-generated method stub
		double Area=this.getArea();
		double area1=this.getSpecificArea(this.x1, this.y1, this.x2, this.y2, point_x, point_y);
		double area2=this.getSpecificArea(this.x3, this.y3, this.x2, this.y2, point_x, point_y);
		double area3=this.getSpecificArea(this.x1, this.y1, this.x3, this.y3, point_x, point_y);
		if(Area==area1+area2+area3){
			return true;
		}
		return false;
	}

}

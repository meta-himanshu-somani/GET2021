
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Screen s=new Screen();
		Shape sh=s.addShape(ShapeType.Circle, 2.0,2.0,2.0);
		System.out.println(sh.getArea());
		System.out.println(s.addShape(ShapeType.Circle, 4.0,4.0,4.0).getArea());
		System.out.println(s.addShape(ShapeType.Squre,4,4,6,6).getArea());
		s.sortShapeBasedOn("Area");
		//s.deleteAllSpecificShape(ShapeType.Circle);
		
		
	}

}

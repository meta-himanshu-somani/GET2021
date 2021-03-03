
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Screen s=new Screen();
		System.out.println(ShapeType.Circle);
		System.out.println(s.addShape(ShapeType.Circle, 2.0,2.0,2.0).getArea());
		System.out.println(s.addShape(ShapeType.Circle, 2.0,2.0,2.0).getArea());
		System.out.println("remove " + s.deleteShape(ShapeType.Circle));
	}

}

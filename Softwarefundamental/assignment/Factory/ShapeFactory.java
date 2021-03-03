
public class ShapeFactory {
	public static Shape create(ShapeType shapetype,double... args){
		Shape shape=null;
		if(ShapeType.Circle.equals(shapetype)){
			System.out.println("Circle "+ shapetype);
			shape= new Circle(args[0],args[1],args[2]);
		}else if(ShapeType.Rectangle.equals(shapetype)){
			shape= new Rectangle(args[0],args[1],args[2],args[3]);
		}else if(ShapeType.Triangle.equals(shapetype)){
			shape= new Triangle(args[0],args[1],args[2],args[3],args[4],args[5]);
		}else if(ShapeType.Squre.equals(shapetype)){
			shape= new Squre(args[0],args[1],args[2],args[3]);
		}
		return shape;
	}
}

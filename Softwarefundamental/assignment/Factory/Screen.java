import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Screen {
	private double XMAX=10;
	private double YMAX=10;
	private double XORIGIN=0;
	private double YORIGIN=0;
	private List<Shape> shapeList =new ArrayList<>();
	private Map shapemap=new HashMap();
	public Shape addShape(ShapeType shapetype,double... d){
		System.out.println("addShape "+shapetype);
		this.shapeList.add(ShapeFactory.create(shapetype,d));
		shapemap.put( shapetype,ShapeFactory.create(shapetype,d));
		System.out.println("this list "+this.shapemap+" end");
		return ShapeFactory.create(shapetype,d);
	}
	public Map deleteShape(ShapeType shapetype){
		shapemap.remove(shapetype);
		return shapemap;
	}
	public void deleteAllSpecificShape(ShapeType shapetype){
		shapemap.remove(shapetype);
	}
	public List<Shape> sortShapeBasedOn(String type){
		if("Area".equals(type)){
			double[] area=new double[this.shapeList.size()];
			
		}else if("Perimeter".equals(type)){
			
		}else if ("Timestamp".equals(type)){
			
		}else if ("Origin".equals(type)){
			
		}
		return shapeList;
	}
}

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Screen {
	/*private double XMAX=10;
	private double YMAX=10;
	private double XORIGIN=0;
	private double YORIGIN=0;*/
	private List<Shape> shapeList =new ArrayList<>();
	private Map<Shape,Timestamp> timeStamp=new HashMap<Shape,Timestamp>();
	private Map<Shape, ShapeType> shapemap=new HashMap<Shape, ShapeType>();
	/**
	 * 
	 * @param shapetype type of shape to create like Circle,Triangle...
	 * @param d list of points corresponding to shape type
	 * @return shapeObject after adding shape on virtual screen
	 */
	public Shape addShape(ShapeType shapetype,double... d){
		Timestamp ts= new Timestamp(System.currentTimeMillis());
		Shape shapeObject=ShapeFactory.create(shapetype,d);
		this.timeStamp.put(shapeObject,ts);
		this.shapeList.add(shapeObject);
		this.shapemap.put( shapeObject,shapetype);
		return shapeObject;
	}
	/**
	 * 
	 * @param shapeobject object of shape that to be delete from screen
	 */
	public void deleteShape(Shape shapeobject){
		shapemap.remove(shapeobject);
		this.timeStamp.remove(shapeobject);
		this.shapeList.remove(shapeobject);
	}
	/**
	 * 
	 * @param shapetype specific shape type to delete all its object on screen
	 */
	public void deleteAllSpecificShape(ShapeType shapetype){
		for(Iterator<Shape> iterator = this.shapemap.keySet().iterator(); iterator.hasNext(); ) {
			  Shape key = iterator.next();
			  if(this.shapemap.get(key)==shapetype) {
			    iterator.remove();
			    this.shapeList.remove(key);
			    this.timeStamp.remove(key);
			  }
			}
	}
	/**
	 * 
	 * @param type sort list of shape based on type like area,perimeter ,timestamp ,and origin
	 * @return
	 */
	public List<Shape> sortShapeBasedOn(String type){
		Shape[] temp = new Shape[this.shapeList.size()];
		int i=0;
		for(Shape shapeObject : this.shapeList){
			temp[i++]=shapeObject;
		}
		if("Area".equals(type)){
			System.out.println(this.shapeList);
			for(i=0;i<temp.length;i++){
				for(int j=i+1;j<temp.length;j++){
					if(temp[i].getArea()>temp[j].getArea()){ // swape the object based on area
						Shape tempShape=temp[i];
						temp[i]=temp[j];
						temp[j]=tempShape;
					}
				}
			}
		}else if("Perimeter".equals(type)){
			for(i=0;i<temp.length;i++){
				for(int j=i+1;j<temp.length;j++){
					if(temp[i].getPerimeter()>temp[j].getPerimeter()){// swape the object based on perimeter
						Shape tempShape=temp[i];
						temp[i]=temp[j];
						temp[j]=tempShape;
					}
				}
			}
		}else if ("Timestamp".equals(type)){
			Timestamp[] timeList=new Timestamp[this.shapeList.size()];
			int index=0;
			for(Timestamp time: this.timeStamp.values()){
				timeList[index++]=time;
			}
			for(i=0;i<temp.length;i++){
				for(int j=i+1;j<temp.length;j++){
					if(timeList[i].getTime()>timeList[j].getTime()){ // swape the object based on timestamp
						Shape tempShape=temp[i];
						temp[i]=temp[j];
						temp[j]=tempShape;
					}
				}
			}
		}else if ("Origin".equals(type)){
			for(i=0;i<temp.length;i++){
				for(int j=i+1;j<temp.length;j++){
					if(temp[i].getOrigin()>temp[j].getOrigin()){// swape the object based on distance from origin   
						Shape tempShape=temp[i];				//to starting point of shape
						temp[i]=temp[j];
						temp[j]=tempShape;
					}
				}
			}
		}
		this.shapeList.clear();
		for(i=0;i<temp.length;i++){
			this.shapeList.add(temp[i]);
		}
		System.out.println(this.shapeList);
		return shapeList;
	}
}

/*Design a class Area to calculate areas for different shapes. It should support following methods
- Method to return area of a Triangle. Method will receive width and height as double and return computed value as double.
- Method to return area of a Rectangle. Method will receive width and height as double and return computed value as double.
- Method to return area of a Square. Method will receive width as double and return computed value as double.
- Method to return area of a Circle. Method will receive radius as double and return computed value as double
*/
public class Area {
	/**
	 * 
	 * @param width width of right angle triangle as double type and positive
	 * @param height height of right angle triangle as double type and positive
	 * @return area=(1/2)*width*height
	 */
	public double areaOfTriangle(double width,double height){
		return width>0 && height>0 ? 0.5*width*height: 0;
	}
	/**
	 * 
	 * @param width of rectangle in double type and positive
	 * @param height of rectangle in double type and positive
	 * @return width*height
	 */
	public double areaOfRectangle(double width,double height){
		return width>0 && height>0 ? width*height : 0;
	}
	/**
	 * 
	 * @param width or side of square in double type and positive
	 * @return width*width
	 */
	public double areaOfSquare(double width){
		return width>0 ? width*width : 0;
	}
	/**
	 * 
	 * @param radius of circle in double type and positive
	 * @return 2*PI*radius*radius where PI=3.14
	 */
	public double areaOfCircle(double radius){
		double PI=3.14;
		return radius>0 ? 2*PI*radius*radius : 0;
}
}

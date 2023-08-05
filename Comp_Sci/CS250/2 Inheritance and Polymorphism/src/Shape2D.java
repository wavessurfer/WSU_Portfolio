
public abstract class Shape2D {
	//declare or define variables
	private int sides, x, y; 	//number of sides, x, y, center of location
	private String color;		//color of shape
	
	//empty constructor
	public Shape2D(){
	}
	
	//2nd constructor to initialize internal variables
	public Shape2D(String color, int x , int y, int sides) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.sides = sides;
	}
	
	/**
	 * @return the sides
	 */
	public int getSides() {
		return sides;
	}

	/**
	 * @param sides the sides to set
	 */
	public void setSides(int sides) {
		this.sides = sides;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * This method will return a string representation of the current shape object
	 */
	public String toString() {
		return "sides: " + sides + ", x: " + x + ", y: " + y + ", color: " + color;
	}
	
	public abstract double calcArea();			//calculate the area of the shape
	
	public abstract double calcPerimeter();		//calculate the perimeter of the shape
	
}
	


public class Rectangle extends Shape2D {
	private double length,width;

	public Rectangle() {
		// TODO Auto-generated constructor stub
	}

	public Rectangle(String color, int x, int y, int sides, double lenght, double width) {
		super(color, x, y, sides);
		// TODO Auto-generated constructor stub
		this.length = lenght;
		this.width = width;
	}

	/**
	 * @return the lenght
	 */
	public double getLenght() {
		return length;
	}

	/**
	 * @param lenght the lenght to set
	 */
	public void setLenght(double lenght) {
		this.length = lenght;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	
	public String toString() {
		return super.toString() + ", length: " + length + ", width: " + width;
	}

	@Override
	public double calcArea() {
		// TODO Auto-generated method stub
		return length * width;
	}

	@Override
	public double calcPerimeter() {
		// TODO Auto-generated method stub
		return ((2 * width) + (length * 2));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rec = new Rectangle("green",3,6,4,5,3);
		System.out.println(rec);
		System.out.println("The area is: " + rec.calcArea());
		System.out.println("The perimeter is: " + rec.calcPerimeter());

	}

}

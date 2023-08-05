
public class Circle extends Shape2D {
	
	private double radius;		//radius of the circle

	public Circle() {
		// TODO Auto-generated constructor stub
	}

	public Circle(String color, int x, int y, int sides, double radius) {
		super(color, x, y, sides);
		// TODO Auto-generated constructor stub
		this.radius = radius;
	}

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double calcArea() {
		// TODO Auto-generated method stub
		return Math.PI * (radius * radius);		//OR math.pow(radius,2)
	}

	@Override
	public double calcPerimeter() {
		// TODO Auto-generated method stub
		return 2 * Math.PI * radius;
	}
	/**
	 * Return a string representation of the current Circle Object
	 */
	public String toString() {
		return super.toString() + ", radius: " + radius;
	}
	
	public static void main(String[] args) {
		Circle circ = new Circle();
		circ.setColor("yellow");
		circ.setRadius(7.5);
		circ.setSides(1);
		circ.setX(5);
		circ.setY(10);
		
		Circle circ2 = new Circle("blue", 4,1, 1, 3.5);
		
		System.out.println(circ);
		System.out.println(circ2);
		
		System.out.println("The area is: " + circ.calcArea());
		System.out.println("The perimeter is: " + circ.calcPerimeter());

	}

}


public class Ellipse extends Shape2D {
	private double a, b; //major axis and minor axis

	public Ellipse() {
	}

	public Ellipse(String color, int x, int y, int sides, double a, double b) {
		super(color, x, y, sides);
		this.a = a;
		this.b = b;
	}

	/**
	 * @return the a
	 */
	public double getA() {
		return a;
	}

	/**
	 * @param a the a to set
	 */
	public void setA(double a) {
		this.a = a;
	}

	/**
	 * @return the b
	 */
	public double getB() {
		return b;
	}

	/**
	 * @param b the b to set
	 */
	public void setB(double b) {
		this.b = b;
	}

	public String toString() {
		return "Eclipse: "  + "major axis: " + a + ", minor axis: " + b + ", center = (" + getX() + "," + getY() + ")" ;
	}
	
	@Override
	public double calcArea() {
		// TODO Auto-generated method stub
		return Math.PI * (a / 2) * (b / 2);
	}

	@Override
	public double calcPerimeter() {
		// TODO Auto-generated method stub
		return (2 * Math.PI) * Math.sqrt ( Math.pow(a/2, 2) + Math.pow(b/2,2) / 2 );
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

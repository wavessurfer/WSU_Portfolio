
public class TestApp {
	
	/**
	* This method performs reporting on a Shape2D object
	* @param shape: the shape object
	* @return: None
	*/
	public static void report(Shape2D obj) {
	//TODO: add code below
	if (obj instanceof Circle)
		System.out.println("The class of obj is Circle");
	else if (obj instanceof Rectangle)
		System.out.println("The class of obj is Rectangle");
	else if (obj instanceof Ellipse)
		System.out.println("The class of obj is Ellipse");

	System.out.println(obj);
	System.out.println("Area: " + obj.calcArea() + ", perimeter: " + obj.calcPerimeter());


	}
	
	
	public TestApp() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rec = new Rectangle("green",3,6,4,5,3);
		Circle circ = new Circle("blue", 4,1, 1, 3.5);
		Ellipse ell = new Ellipse("orange", 5, 2, 0, 8, 4 );
		report(circ);
		report(rec);
		report(ell);
	}

}

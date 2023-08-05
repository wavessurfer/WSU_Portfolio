
public class Main {
	
	public static void main(String [] args) {
		HelloWorld app = new HelloWorld(); 		//another object from class HelloWorld
		
		
		
		app.readName(); 						//[objectname].[methodname] way to call an object
		app.readAge();
		double grade1 = app.readGrade();
		app.greet();	
		
		HelloWorld app2 = new HelloWorld();
		app2.readName(); 						
		app2.readAge();
		double grade2 = app2.readGrade();
		app2.greet();
		
		double c = grade1 + grade2;
				
		
		System.out.print("And the sum of your grades is " + c);
	}
}


import java.util.Scanner;

public class HelloWorld {
	private String greeting;
	
	private String name;
	
	private int age;
	
	private double grade;
	
	public HelloWorld() {
		greeting = "Welcome ";
	}
	
	public void greet() {
		System.out.println(greeting + name + "! Your age is " + age + " and your grade is " + grade);
	}
	
	public void readName() {
		Scanner in = new Scanner(System.in); 	//[classname] [objectname] = new [classname]();
		System.out.print("Enter your name ");
		name = in.next();
	}
	
	public void readAge() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your age ");
		age = in.nextInt();	
	}
	
	public double readGrade() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your grade ");
		grade = in.nextDouble();
		return grade;
		
	}
}
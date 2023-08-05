import java.util.InputMismatchException;
import java.util.Scanner;

public class P3a {
	public P3a() {
		
	}
	
	public static void main(String [] args ) {
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the numerator(a): ");
			int numerator = sc.nextInt();
			System.out.print("Enter the denominator(a): ");
			int denominator = sc.nextInt();
			
			/*if (denominator == 0) {
				System.err.println("Error! Denominator is zero");
				System.exit(0);
				}
			*/
			
			
			int ratio = numerator/denominator;
			System.out.println(numerator + " / " + denominator + " = " + ratio);
			
			System.out.print("Enter a number: ");
			String str = sc.next();
			double value = Double.valueOf(str);
			System.out.print("You have enter a numer: " + value);
			
			} catch (InputMismatchException ime) {
			System.err.println("Wrong Input! Please run again");
			
			} catch (ArithmeticException e) {
				System.err.println("Error!" + e.getMessage());
				e.printStackTrace();
			}
		
	}
}

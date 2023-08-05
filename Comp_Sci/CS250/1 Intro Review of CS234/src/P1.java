import java.util.Scanner;


public class P1 {
	
	
	public static void main(String[] args) {
		int i0 = 12345, i1 = -99999;
		float f0 = 1.2345F, f1 = 99.9999F;
		double d0 = 0.0001, d1 = 12345.98765;
		
		System.out.println( (i0 + i1) / 10);
		System.out.println( (i0 + i1) / 10.0);
		System.out.println( i0 % 100);
		System.out.println( (i0 - 2345) * 10);
		System.out.println( i0 - 2345 * 10);
		System.out.println( (f0 + f1) / (d0 * d1));
		System.out.println( 0.1 + 0.2 - 0.3);
		System.out.println( 6 % 4 + 12 -3 * (8 +3) / 2);
		
		System.out.println();
		
		System.out.println( i0 + "," + i1);
		System.out.printf( "i0 + i1 = %d\n",i0 + i1);
		System.out.printf("d0 + d1 = %.2f\n", d0 + d1);
		System.out.printf("d0 + d1 = %.5f\n", d0 + d1);
		
		System.out.println();

		float a,b,c;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the coefficient a:");
		a = scan.nextFloat();
		
		System.out.print("Enter the coefficient b:");
		b = scan.nextFloat();

		System.out.print("Enter the coefficient c:");
		c = scan.nextFloat();
		
		//System.out.println("The input formula: " + a + "x^2 + " + b + "x + " + c + " = 0");
		System.out.println("The input formula: " + a + "x^2 "
		+ (b>=0 ? ("+ " + b) : ("" + b))
		+ "x " + (c>=0 ? ("+ " + c): (" " + c)) + " = 0");

		
		
		double pos = (-b + Math.sqrt( Math.pow(b, 2) - 4 * a * c))/(2*a);
		double neg = (-b - Math.sqrt( Math.pow(b, 2) - 4 * a * c))/(2*a);
		System.out.println(pos + "," + neg);
		System.out.printf("The roots are: %.2f, %.2f", pos, neg );
		
		System.out.println();

		compareInt(3,3);
		compareInt(5,7);
		compareInt(6,2);
		
		System.out.println();
		
		double sal,rate;
		
		System.out.print("Enter Salary in $ ");
		sal = scan.nextDouble();
		System.out.print("Enter the tax rate percentage (i.e, 20) ");
		rate = scan.nextDouble();
		
		if ( sal > 0 && ( (rate >= 0 && rate <=100) )) {
			
			System.out.printf("The tax owed is $ %.2f", calcTax(sal,rate));
		}
		
		else {
			System.out.print("Please enter positive values");
		}
		

	}

	/**
	* This method compares two input integers a and b
	* and display the comparison result between them
	* @param a, b: the input numbers
	* @return: None but print to console the comparison result
	*/
	
	public static void compareInt(int a, int b) {
		//TODO: add code below
		if (a > b)	System.out.println( a + " is greater than " + b);
		else if ( a == b) System.out.println( a + " equals " + b);
		else System.out.println( a + " is less than " + b);
		
	}
	
	/**
	* This method calculates the owed tax of the user based on the input salary
	* and tax rate
	* @param salary: the input user‘s salary
	* @param tax_rate: the tax rate apply to such a user (0 - 100%)
	* @return: the owed tax
	*/
	public static double calcTax(double salary, double tax_rate) {
	//TODO: add code below
		
			double tax = (tax_rate/100) * salary;		
		return tax;
	}

	
	
}

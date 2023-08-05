import java.util.Scanner;

/**
  * Class Name: Lab08App
  * Author: Jose Ortega
  * Date: 03/18/21
  * Problem Description and Goals: that defines your application – 
  *     Lab8_SqrtGuess avoids the hustle of hand calculations the sum from 1 to n. the sum of squared from 1 to n, the average from 1 to n,
  * 	the mean value from 1 to 10, and the estimated squared root of n based on a initial guess.
  * Inputs and outputs for your application:
  * 	int n = 10;
  * 	double guess = 1.0;
  * Imported packages:
  * 	- java.util.Scanner;
  * 	- java.lang.Math;
  * Test Case:
  * 	Enter the number: -10(n)
  * 	Enter the initial guess of squared root: -1.0(guess)
  * 	The Sum from 1 to 10 is 55
  * 	The Sum of squared from 1 to 10 is 385
  * 	The Average from 1 to 10 is 5.5
  * 	The Mean value from 1 to 10 is 5.0
  * 	Initial guess: 1.0
  * 	Guess 1: 5.5
  * 	Guess 2: 3.659090909090909
  * 	Guess 3: 3.196005081874647
  * 	Guess 4: 3.16245562280389
  * 	Guess 5: 3.162277665175675
  * 	Guess 6: 3.162277660168379
  * 	The Estimated squared root of 10 is 3.162277660168379
  */

public class Lab08App {

    public static void main ( String args [] ) {
    	
    	Scanner scan = new Scanner(System.in);
    	System.out.print("Enter the number: ");
		int n = scan.nextInt();
    	System.out.print("Enter the initial guess of squared root: ");
    	double g = scan.nextDouble();
		System.out.println("The Sum from 1 to " + n + " is " + Lab08Utilities.sum1ToN(n));
		System.out.println("The Sum of squared from 1 to " + n + " is " + Lab08Utilities.squaredSum1ToN(n));
		System.out.println("The Average from 1 to " + n + " is " + Lab08Utilities.avg1ToN(n));
		System.out.println("The Mean value from 1 to " + n + " is " + Lab08Utilities.mean1ToN(n));
		System.out.println("The Estimated squared root of " + n + " is " + Lab08Utilities.estimateSqrt(n,g) );
    	
    }
}

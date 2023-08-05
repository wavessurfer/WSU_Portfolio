package laba;

import java.util.Scanner;

public class PowerRecursive {
	/**
	* This method calculates the power x^n
	* @param x: the base integer number
	* @param n: the positive integer number of the exponential
	* @return: the positive integer power n of x (x^n)
	*/
	public static int powerFunc(int x, int n) {
		
			//throw new IllegalArgumentException("n should be positive");
			if (n<0)
				throw new IllegalArgumentException("x should not be zero");
			
			if (n == 0) 
				return 1/powerFunc(x, -n);
					
			
			else if ( n > 1)
				return x * powerFunc(x,n-1);
			
			else return x;
			
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the base (x): ");
		int x = sc.nextInt();
		System.out.println("Enter the exponential (n): ");
		int n = sc.nextInt();
		System.out.println("\n" + x + "^" + n + " = " + powerFunc(x,n));



	}
}


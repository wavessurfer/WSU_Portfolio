import java.util.Scanner;
import java.lang.Math;

public final class Lab08Utilities {

	private Lab08Utilities() {}
	
	public static int sum1ToN(int n) {
		//This public static method takes a single int parameter (n) return the sum from 1 to n: 1 + 2 + ... + n
		int sum = 0;
		for(int k = 1; k <= n; k++)
			sum = sum + k;
		return sum;
	}
		public static int squaredSum1ToN(int n) {
		//This public static method takes an int parameters (n) and returns the squared sum from 1 to n: 1^2 + 2^2 + ... + n^2
		int sqsum = 0;
		for (double k = 1; k <=n; k++)
			sqsum = (int) (sqsum + Math.pow(k, 2));
		return sqsum;
			
	}
	public static double avg1ToN(int n) {
		//This public static method takes an int parameters (n) and returns the average from 1 to n: (1 + 2 + ... + n)/n
		int sum = 0;
		for(int k = 1; k <= n; k++)
			sum = sum + k;
		return (double) sum / n;
	}
	
	public static double mean1ToN(int n) {
		//This public static method takes an int parameters (n) and returns the mean value from 1 to n: n/2 if n is even else (n+1)/2
		if (n % 2 == 0) return n / 2;
		else return (n+1)/2;
	}
	
	public static double estimateSqrt(int n, double guess) {
		System.out.println("Initial guess: " + guess);
		double preguess;
		int i = 1;
		do { 
			preguess = guess;
			guess = (( n / guess) + guess) / 2;
			System.out.println("Guess " + i++ + ": " + guess);
			
		} while (Math.abs(guess- preguess) > Math.pow(10, -8));
		
	return guess;
	}		
}
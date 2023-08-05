package lec;
import java.util.Scanner;

public class TestRecursive {
	// calculate the sum of integers from 1 to n using recursive approach
	// sum1toN(n) = sum1toN(n-1) + n		if n > 1 (recursive case)
	// sum1toN(n) - 1						if n = 1 (base case)
	private static int sum1toN(int n) {
		if (n == 1)
			return 1;
		else if ( n > 1)
			return sum1toN(n-1) + n;
		else return 0;
	}
	
	private static int factorial(int n) {
		if (n <= 0)
			return 1;
		else
			return factorial(n-1) * n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n: ");
		int n = sc.nextInt();
		System.out.println("Sum from 1 to n: " + sum1toN(n));
		System.out.println("n! = " + factorial(n));


	}

}

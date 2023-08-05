package laba;

import java.util.Scanner;

public class Fibonacci {
	/**
	* This method calculates the Fibonacci of nth term recursively
	* @param n:
	* @return: the Fibonacci value of the nth term
	*/
	public static int fibRec(int n){
		//TODO: add code below
		if (n == 1 || n == 0)
			return n;
		else
			return fibRec(n-1) + fibRec(n-2);	
	}
	
	/**
	* This method calculates the Fibonacci of nth term iteratively using an array to
	* store the intermediate values to avoid the recomputation
	* iterative version:
	* @param n: the input number
	* @return: the Fibonacci value of the nth term
	*/
	public static int fibIter(int n) {
		//Create an array of integers the size of n + 1
		int[] arr = new int[n+1];	
		//Initialize the first two elements of the array to 0 and 1,
		//corresponding to the first two elements of the Fibonacci sequence.
		arr[0] = 0;
		arr[1] = 1;
		//Then use a for loop from 2 to n and computing each element of the array as the
		//sum of the two previous elements: array[i] = arr[i-1] + arr[i-2]
		for(int i = 2; 2 < n ;i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		//Return the value of the array at the index n: array[n]
		return arr[n];
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int n = sc.nextInt();
		if (n < 0)
			System.out.println("Please run again and enter a positive integer!");
		else {
			long start = System.nanoTime();
			System.out.println("\nFibocci of " + n + " is " + fibRec(n));
			long end = System.nanoTime();
			System.out.println("Recursion execution time: " + (end - start) /100000 + " ms"); 
			long st = System.nanoTime();
			System.out.println("\nIterative version: Fibocci of " + n + " is " + fibRec(n));
			long en = System.nanoTime();
			System.out.println("Iterative version: Recursion execution time: " + (en - st) /100000 + " ms");
	
		}
	}

}

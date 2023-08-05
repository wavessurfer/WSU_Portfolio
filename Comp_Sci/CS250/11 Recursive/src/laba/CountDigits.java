package laba;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CountDigits {
	
	/**
	* This method count the number of digits of an integer num
	* @param n: the positive integer number
	* @return: the number of digits in the given integer
	*/
	public static int countDigits(int n) {		
		//TODO: add code below
		if ( n < 10)
			return 1;
		else return 1 + countDigits(n/10);	//1234 = 1*10^3 + 2*10^2 + 3*10^1 + 4*10^0
		
	}
	
	//1234 => {1,2,3,4}
	public static List<Integer> extractDig(int n){
		if (n < 10)
			return new ArrayList<>(Arrays.asList(n));
		else {
			List<Integer> l = extractDig(n/10);
			//extract the last digit of n (unit digit)
			//1234 - 123*10 = 4
			//1234%10 = 4
			int last = n % 10;
			//append it the previous list
			l.add(last);	
			return l;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int n = sc.nextInt();
		if (n <= 0)
			System.out.println("Please run again and enter a positive integer!");
		else {
			System.out.println("The number of digits in " + n + ": " + countDigits(n));
			System.out.println("The list of digits in " + n + ": " + extractDig(n)); 
		}
	}
}
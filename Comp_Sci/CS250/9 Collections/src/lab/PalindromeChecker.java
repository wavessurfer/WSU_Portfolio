package lab;

import java.util.Scanner;
import java.util.Stack;

public class PalindromeChecker {
	
	//This method returns true if the given string is a palindrome
	public static boolean isPalindrome(String str) {
		//TODO: Add code below
		//stack = create a stack of character
		Stack<Character> stack = new Stack<>();
		//Strin tmp = Convert str to lowercase
		String tmp = str.toLowerCase();
		//Calculate the half-length of the input string
		int mid = tmp.length() / 2;
		//Use a loop to push the first character to the middle character of tmp to stack
		//skip the middle character if the length os tmp is odd
		for(int i = 0;i < mid; i++)
			stack.push(tmp.charAt(i));
		//i = mid + 1 if tmp. lenght is odd else mid
		int i = (tmp.length()%2 == 1) ? (mid + 1 ) : mid;
		//while i < tmp.length
		while ( i < tmp.length()) {
			//ch = pop the character from the stack
			char ch = stack.pop();
			//If ch is not equal jto the character at the index i of tmp, return flase
			if(ch != tmp.charAt(i))
				return false;
			//Increase 1 to i
			i++;
		}
		return true;
	}
	
	//main() application method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the word: ");
		while(true) {
			String word = sc.nextLine();
			if(word.equalsIgnoreCase("exit"))
				break;
			System.out.println("The " + word + " is a palindrome: " +isPalindrome(word));
		}
	}

}

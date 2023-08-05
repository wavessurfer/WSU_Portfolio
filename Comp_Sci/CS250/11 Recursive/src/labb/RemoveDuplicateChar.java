package labb;

public class RemoveDuplicateChar {
	/**
	* This method removes all adjacent duplicate chars in the given string
	* @param str: the given input string
	* @return: the string with all adjacent similar characters have been removed
	*/
	public static String removeDuplicateChar(String str) {
		// If the length of the input string is less than 2, simply return that str
		if (str.length() < 2)
			return str;
		
		//Otherwise, if the first character equals the second character, return the result of the recursive call on the first character + the substring of str from the index 2.
		if (str.charAt(0) == str.charAt(1))
			return removeDuplicateChar(str.charAt(0) + str.substring(2)) ;
			 
		
		//Otherwise, return the first character + the result of the recursive call on the substring of str from the index 1
		else return str.charAt(0) + removeDuplicateChar(str.substring(1));
		
		//Hint: use the String.charAt(index) method to get a specific character at index position. The method String.substring(index) will return the substring from the index position.
	}
	
	public static String putHyphenBetweenDuplicates(String str) {
		// If the length of the input string is less than 2, simply return that str
		if (str.length() < 2)
			return str;
		
		//Otherwise, if the first character equals the second character, return the result of the recursive call on the first character + the substring of str from the index 2.
		if (str.charAt(0) == str.charAt(1))
			return putHyphenBetweenDuplicates(str.charAt(0) + "-" + str.substring(1)) ;
			 
		
		//Otherwise, return the first character + the result of the recursive call on the substring of str from the index 1
		else return str.charAt(0) + putHyphenBetweenDuplicates(str.substring(1));
		
		//Hint: use the String.charAt(index) method to get a specific character at index position. The method String.substring(index) will return the substring from the index position.
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("  => " + removeDuplicateChar(""));
		System.out.println("a  => " + removeDuplicateChar("a"));
		System.out.println("hello  => " + removeDuplicateChar("hello"));
		System.out.println("abbcddd  => " + removeDuplicateChar("abbcddd"));
		System.out.println("xyyxzzz  => " + removeDuplicateChar("xyyxzzz"));
		System.out.println("\n");
		System.out.println("hello  => " + putHyphenBetweenDuplicates("hello"));
		System.out.println("abbcddd  => " + putHyphenBetweenDuplicates("abbcddd"));
		System.out.println("xyyxzzz  => " + putHyphenBetweenDuplicates("xyyxzzz"));
		System.out.println("112aa445  => " + putHyphenBetweenDuplicates("112aa445"));
	
	}


}

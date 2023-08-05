package labb;

public class PutHyphenBetweenChars {
	/**
	* This method returns a new string from the given string that puts a hyphen
	* between two characters
	* @param str: the input string
	* @return: a new string with a hyphen character is inserted between two
	* adjacent characters
	*/
	
	public static String putHyphenBetweenChars(String str) {
		
		//If the length of the input string is less than 2, simply return that str
		if (str.length() < 2)
			return str;
		
		//Else, return the first character + the hyphen + the result of the recursive call on the tail of the string (Hint: call substring of str with the index 1)
		else return (str.charAt(0) + "-" + putHyphenBetweenChars(str.substring(1)));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("     => " + putHyphenBetweenChars(""));
		System.out.println("a     => " + putHyphenBetweenChars("a"));
		System.out.println("abc     => " + putHyphenBetweenChars("abc"));
		
	}

}
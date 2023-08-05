package labb;

public class RecursiveParenthesisChecker {
	public static boolean checker(String str) {
		//if (str.equals("")) return true;
		if ( str.equals("")  )
			return true;
		
		else if ( (str.startsWith("(") & str.endsWith(")")) )
			return true;
		
		else return checker(str.substring(1, str.length()));
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("  => " + checker(""));
		System.out.println("()  => " + checker("()"));
		System.out.println("(())  => " + checker("(())"));




	}

}

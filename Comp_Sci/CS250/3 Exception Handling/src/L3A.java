
public class L3A {
	public static void main(String[] args) {
		int num1 = 22, num2 = 0;
		int divResult=0;
		char[] chArr = { 'a', 'b', 'c', 'd' };
		for (int i = 0; i < 2; i++) {
			if (i == 0)
			    try {        //Added try catch to print the first error
			        divResult = num1 / num2; 
			    } catch(ArithmeticException e) {
			        System.err.println("Error! " + e.getMessage());
			    }
			else
			    try {        //Added try catch to print the second error
			        chArr[4] = 'X';
			    } catch(ArrayIndexOutOfBoundsException ime) {
			        System.err.println("Error! " + ime.getMessage());
			    }
		
		}
		
		System.out.println("divResult=" + divResult);
		System.out.println("chArr=" + String.valueOf(chArr));
	}
}
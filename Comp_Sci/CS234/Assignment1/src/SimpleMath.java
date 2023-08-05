/*
 * Class name: SimpleMath
 * Author: Jose Ortega
 * Date: 2/5/21
 * Problem: SimpleMAth is an application that will resolve the issue of calculating
 * basic mathematical operations of two numbers by specifying them with the Constructor method.
 * Goals:
 *      - Calculate addition of two numbers
 *      - Calculate subtraction of two numbers
 *      - Calculate multiplication of two numbers
 *      - Calculate division of two numbers
 * Inputs:
 *      -int num1
 *      -int num2
 * Outputs:
 *      - num1 + num2
 *      - num1 - num2
 *      - num1 * num2
 *      - num1 / num2
 * Required packages: None
 * Test cases:
 *      - 12 + 5 = 17
 *		- 12 - 5 = 7
 *		- 12 * 5 = 60
 *		- 12 / 5 = 2.40...
 * Pseudo code:
 *     Step 1: Specify two numbers of the parameter.
 *     Step 2: Get addition of the two numbers.
 *     Step 3: Get subtraction of the two numbers.
 *     Step 4: Get multiplication of the two numbers.
 *     Step 5: Get division of the two numbers.
 *     Step 6: Deliver results
 */
public class SimpleMath {
	  private   int num1;
	    private  int num2;

	    /* 
		This Constructor is used to specify the two numbers which we want to operate
		*/
	    
	    public SimpleMath ( int n1 , int n2 ) {
	        num1 = n1 ;
	        num2 = n2 ;
	    }

	    /*
		 * This method is used to add the values specified in the constructor
		 * Inputs: num1 and num2
		 * Outputs: num1 + num2
		 * Pseudocode:
		 * 	- Simple addition
		 */
	    
	    public int add() {
	        return num1 + num2 ;
	    }

	    /*
		 * This method is used to subtract the values specified in the constructor
		 * Inputs: num1 and num2
		 * Outputs: num1 - num2
		 * Pseudocode:
		 * 	- Simple subtraction
		 */
	    
	    public int subtract() {
	    	return num1 - num2;	   
	    }

	    /*
		 * This method is used to multiply the values specified in the constructor
		 * Inputs: num1 and num2
		 * Outputs: num1 * num2
		 * Pseudocode:
		 * 	- Simple multiplication
		 */
	    
	    public int multiply() {
	    	return num1 * num2;  
	    }

	    /*
		 * This method is used to divide the values specified in the constructor
		 * Inputs: num1 and num2
		 * Outputs: num1 / num2
		 * Pseudocode:
		 * 	- Simple division
		 */
	    
	    public double divide() {
	    	return (double) num1 / (double) num2;
	    }

	    /*
		 * The main method calls all of the other methods above.
		 * It prints all of the results of the expressions. 
		*/
	    
	    public static void main ( String args [] ) {
	        SimpleMath calc = new SimpleMath(12, 5);
	        System.out.print(calc.num1 + " + " + calc.num2 + " = " + calc.add() + "\n");
	        System.out.print(calc.num1 + " - " + calc.num2 + " = " + calc.subtract() + "\n");
	        System.out.print(calc.num1 + " * " + calc.num2 + " = " + calc.multiply() + "\n");
	        System.out.print(calc.num1 + " / " + calc.num2 + " = " + calc.divide() + "\n");
	    }
}

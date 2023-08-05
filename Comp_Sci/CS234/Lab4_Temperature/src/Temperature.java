/*
 * Class name: Temperature
 * Author: Jose Ortega
 * Date: 2/8/21
 * Problem: Temperature is an application that will resolve the issue of converting
 * degrees Fahrenheit to Celsius.
 * Goals:
 *      - Convert degrees Fahrenheit to Celsius
 * Inputs:
 *      -double degree
 * Outputs:
 *      - double getFahrenheit
 *      - double getCelsius
 * Required packages: Scanner
 * Test cases:
 *      Enter the temperature in Fahrenheit: 77
 *      The temperature is 77.0 degree Fahrenheit
 *      The temperature is 25 degree Celsius

 * Pseudo code:
 *     Step 1: Read degree with Scanner method
 *     Step 2: Get Fahreneheit with input
 *     Step 3: Get Celsius with (5 * (degree - 32) /9)
 *     Step 4: Deliver results
 */

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Temperature {
	
	private double degree;
	 
	/*
	 * The constructor is used to define the parameter which is going to be the degree.	 
	 * Inputs: It will be inserted with the main.
	 * Outputs: none
	 * Pseudocode:
	 * 	- It will calls the scanner method to read the input from the keyboard in the main.
	 */
	
	public Temperature(double d) {
		degree = d;
	}
	
	/*
	 * This method is used to grab and return the input from the constructor.	 
	 * Inputs: It will be the one assigned to the constructor in the main.
	 * Outputs: double degree
	 * Pseudocode:
	 * 	- return degree.
	 */
	
	public double getFahrenheit() {
		return degree;
	}
	
	/*
	 * This method is used to transform and return the input from the constructor from Fahrenheit to Celsius.	 
	 * Inputs: It will be the one assigned to the constructor in the main.
	 * Outputs: double degree
	 * Pseudocode:
	 * 	- return (5 * (degree - 32) /9).
	 */
	
	public double getCelsius() {
		return (5 * (degree - 32) /9);
	}
	
	/*
	 * The main method imports a scanner method to insert the argument in the Constructor.
	 * Then, the other method above are called and print the results with them. 
	*/
	
	public static void main ( String argv [] ) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the temperature in Fahrenheit: ");
		double d = input.nextDouble();
		Temperature temp = new Temperature(d);
		System.out.println("The temperature is " + temp.getFahrenheit() + " degree Fahrenheit" );
		System.out.println("The temperature is " + temp.getCelsius() + " degree Celsius" );
	}
}

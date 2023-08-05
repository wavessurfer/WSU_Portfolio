/*
 * Class name: TemperatureApp
 * Author: Jose Ortega
 * Date: 2/8/21
 * Problem: TemperatureApp is an interactive application that will resolve the issue of converting
 * degrees Fahrenheit to Celsius.
 * Goals:
 *      - Convert degrees Fahrenheit to Celsius
 * Inputs:
 *      -double degree
 * Outputs:
 *      - double fDegree
 *      - double cDegree
 * Required packages: swing.JOptionPane
 * Test cases:
 *      Enter the temperature in Fahrenheit: 77
 *      The temperature is 77.0 degree Fahrenheit or 25.0 degree Celsius

 * Pseudo code:
 *     Step 1: Read degree with JOptionPane
 *     Step 2: Get Fahreneheit
 *     Step 3: Get Celsius
 *     Step 4: Deliver results
 */

import javax.swing.JOptionPane;

public class TemperatureApp {
	
	/*
	 * This method is used to grab the input from the user.	 
	 * Inputs: It will assigned by the user .
	 * Outputs: none
	 * Pseudocode:
	 * 	- Use JOptionPane.showInputDialog to get the input.
	 */
	
	public double readInputFromJOptionPane() {
		String strInput = JOptionPane.showInputDialog(null,
				"Enter the temperature in Fahrenheit:",
				"Temperature App by Jose Ortega",
				JOptionPane.QUESTION_MESSAGE);
				return Double.parseDouble(strInput);
	}
	
	/*
	 * This method is used to print the results based on the input from the user.	 
	 * Inputs: It will assigned by the user .
	 * Outputs: none
	 * Pseudocode:
	 * 	- Define its parameter to use fDegree and cDegree in the main
	 *  - Use JOptionPane.showMessageDialog to get the input.
	 */
	
	public void showTemperatureByJOptionPane(double fDegree, double cDegree) {
		JOptionPane.showMessageDialog(null,
				"The temperature is "
				+ fDegree + " degree Fahrenheit or "
				+ cDegree + " degree Celsius",
				"TemperatureApp by Jose Ortega",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	/*
	 * The main method calls the mehtod from above to get and print the results.
	 * Additionally, it creates a Temperature object from Temperature.java to convert the value. 
	*/
	
	public static void main(String[] args) {
		TemperatureApp app = new TemperatureApp();
		double temp = app.readInputFromJOptionPane();
		Temperature tempObj = new Temperature(temp);
		app.showTemperatureByJOptionPane(tempObj.getFahrenheit(), tempObj.getCelsius());	
	}
}

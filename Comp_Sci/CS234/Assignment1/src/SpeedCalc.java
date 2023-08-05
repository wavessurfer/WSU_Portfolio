/*
 * Class name: SpeedCalc
 * Author: Jose Ortega
 * Date: 2/5/21
 * Problem: SpeedCalc is an application that will resolve the issue of calculating
 * the speed of a trip in km/h and convert it to m/s.
 * Goals:
 *      - Calculate the speed in km/h
 *      - Calculate the speed in m/s
 * Inputs:
 *      -int travel_lenght
 *      -int time
 * Outputs:
 *      - speed_kmh
 *		- speed_ms
 * Required packages: Scanner
 * Test cases:
 *      Enter the road length (km): 100
 *		Enter the travel time (hour): 2
 * 		The travel speed in (km/h) is 50.0
 *		The travel speed in (m/s) is 13.88888888888889

 * Pseudo code:
 *     Step 1: Read Input with Scanner method
 *     Step 2: Get speed_kmh = travel_lenght / time
 *     Step 3: Get speed_ms = speed_kmh / 3.6
 *     Step 4: Deliver results
 */

import java.util.Scanner;

public class SpeedCalc {
	private int travel_lenght;
	private int time;
	private double aDbl = 1.0;

	private String aStr = "One byte has 8 bits.";
	/*
	 * This method is used to grab the values inserted by the user
	 * Inputs: travel_lenght and time
	 * Outputs: none
	 * Pseudocode:
	 * 	- Calls the scanner method to read the input from the keyboard
	 */
	
	public void readInput() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the road length (km): " );
		travel_lenght = input.nextInt();
		
		System.out.print("Enter the travel time (hour): ");
		time = input.nextInt();
	}
	
	/* This methods calculates the speed in km/h and in m/s.
	 * Inputs: None
	 * Outputs: Its return type is void but when the main is called, it prints the expression above.
	 * Pseudocode: 
	 * 	- speed_kmh = travel_lenght / time
	 *  - speed_ms = speed_kmh / 3.6
	 * 	- System.out.print
	 */
	
	public void calcSpeed() {
		System.out.print("The travel speed in (km/h) is " + travel_lenght / time + "\n");
		System.out.print("The travel speed in (m/s) is " + travel_lenght / time / 3.6 + "\n");	
	}
	
	/*
	 * The main method calls all of the other methods above.
	 * It reads the input and provides the  speed in km/h and m/s for the desired travel time and length. 
	*/
	
	public static void main(String [] args) {
		SpeedCalc calc = new SpeedCalc();
		calc.readInput();
		calc.calcSpeed();
	}
}
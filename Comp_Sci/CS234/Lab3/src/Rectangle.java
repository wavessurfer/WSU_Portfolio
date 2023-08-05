/*
 * Class name: Rectangle
 * Author: Jose Ortega
 * Date: 1/27/21
 * Problem: Lab 3 project is an application that will resolve the issue of calculating the area and perimeter
 * of rectangles after the user provides the desired lenght and widht.
 * Goals:
 *      - Calculate area of rectangle
 *      - Calculate perimeter of rectangles
 * Inputs:
 *      - int width
 *      - int lenght
 * Outputs:
 *      - int area
 *      - int perimeter
 * Required packages: Scanner
 * Test cases:
 *      - width 4 
 *      - lenght 10
 *      - area = 40
 *      - perimeter 28 
 * Pseudo code:
 *     Step 1: Read Input with Scanner method
 *     Step 2: Get area with = width * lenght
 *     Step 3: Get perimeter with = 2 * (width + lenght)
 *     Step 4: Deliver results
 */

import java.util.Scanner;

public class Rectangle {
	private int width;
	private int lenght;
	private int area;
	private int perimeter;
	private int ID;
	
	/* 
	This Constructor is to enumarete the desired number of rectangles. 
	Specified in the main method
	*/
	
	public Rectangle(int nID) { 
		ID = nID;
	}
	
	/*
	 * This method is used to grab the values inserted by the user
	 * Inputs: width and lenght
	 * Outputs: none
	 * Pseudocode:
	 * 	- Calls the scanner method to read thr input of the keyboard
	 */
	
	public void readInput() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the length of the rectangle " + ID + " : ");
		lenght = input.nextInt();
		
		System.out.print("Enter the width of the rectangle " + ID + " : ");
		width = input.nextInt();
	}
	/* This methods calculates the area of the rectamgle
	 * Inputs: None
	 * Outputs: Its return type is void but when the main is called, it prints the expression above.
	 * Pseudocode: 
	 * 	- area = width * lenght
	 * 	- System.out.print
	 */
	
	public void getArea() {	
		area = width * lenght;
		System.out.print("The area of the rectangle " + ID + " is " + area + "\n");
	}
	
	/*
	 * This methods calculates the perimeter of the rectamgle
	 * Inputs: None
	 * Outputs: Its return type is void but when the main is called, it prints the expression above.
	 * Pseudocode: 
	 * 	- perimeter = 2 * (width + lenght)
	 * 	- System.out.print
	 */
	
	public void getPerimeter() {
		perimeter = 2 * (width + lenght);
		System.out.print("The perimeter of the rectangle " + ID + " is " + perimeter + "\n");
	}
	
	/*
	 * The main method calls all of the other methods above.
	 * It reads the input and provides the area and perimeter of the desired rectangles. 
	*/
	
	public static void main(String [] args) {
		Rectangle rec1 = new Rectangle(1);
		rec1.readInput();
		rec1.getArea();
		rec1.getPerimeter();
		
		Rectangle rec2 = new Rectangle(2);
		rec2.readInput();
		rec2.getArea();
		rec2.getPerimeter();
	}
}


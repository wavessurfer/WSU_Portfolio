/*
 * Class name: AgeClassifier
 * Author: Jose Ortega
 * Date: 2/22/21
 * Problem: AgeClassifier is an application that will differentiate between users' age and print according age classifications.
 * Goals:
 *      - Print age classifications according to users' input of year of birth.
 * Inputs:
 *      -string name
 *      -int birthyear
 * Outputs:
 *      - int age
 * Required packages: Scanner
 * Test cases:
 *      Enter the name: Test Person
 *      Enter the year of birth: 1996
 *      -------------------------
 *      Name: Test Person
 *      Age: 25 years old
 *      Age Classification: Adult
 * Pseudo code:
 *     Step 1: Read name with Scanner method
 *     Step 2: Read year of birth with Scanner method
 *     Step 3: Get age (2021 - birthyear)
 *     Step 4: Deliver results of age classification
 */

import java.util.Scanner;

public class AgeClassifier {
	private String name;    //the name
    private int birthYear;  //the year

    /*
	 * The constructor's parameter defines the user's name and year of birth.
	 * Inputs: will be inserted with the main.
	 * Outputs: none
	 * Pseudocode:
	 * 	- It will be call in the main to use the scanner method to read the input from the keyboard.
	 */
    public AgeClassifier ( String sName, int year ) {
        name = sName ;
        birthYear = year ;
    }

    /* This method is used to grab and return the input from the constructor.	 
	 * Inputs: It will be the one assigned to the constructor in the main.
	 * Outputs: int 
	 * Pseudocode:
	 * 	- return 2021 - birthYear.
	 */
    public int getAge() {
    	return 2021 - birthYear;
    }

    /* This method reads the output from getAge() and return the age classification.	 
   	 * Inputs: output from getAge().
   	 * Outputs: String 
   	 * Pseudocode:
   	 * 	- if-else statement to return respective age classification.
   	 */
    public String getAgeClassification(int age) {
    	
    	if (age <= 19)
    		return " Minor";
    	else if (20 <= age && age <= 65) 
    		return " Adult";
    	else return " Senior";
    	}
    
    /*
	 * The main method imports a scanner method to insert the argument in the Constructor.
	 * Then, the other method above are called and print the results with them. 
	*/

    public static void main ( String args [] ) {
        Scanner user_inputs = new Scanner(System.in);
        System.out.print("Enter the name: ");
        String name = user_inputs.nextLine();
        System.out.print("Enter the year of birth: ");
        int year = user_inputs.nextInt();
        AgeClassifier app = new AgeClassifier(name, year);
        System.out.println("-------------------------");
        System.out.println("Name: " + name);
        System.out.println("Age: " + app.getAge() + " years old");
        System.out.println("Age Classification:" + app.getAgeClassification(app.getAge()));
        
    }
}
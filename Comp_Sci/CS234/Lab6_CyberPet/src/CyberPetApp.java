/*
 * Class name: CyberPet
 * Author: Jose Ortega
 * Date: 2/24/21
 * Problem: CyberPet is a consoled based application that allows the user to manipulate a CyberPet.
 * Goals:
 *      - Modify the state a of the cyberpet (playing, sleeping, eating) with console inputs.
 * Inputs:
 *      -String name
 * Outputs:
 *      - String (name + " is " + state)
 * Required packages: Scanner
 * Test cases:
 *      Enter pet name: Boo Boo
 *      Enter new state: 0
 *      Boo Boo is Sleeping
 *      Enter new state: 1
 *      Boo Boo is Eating
 *      Enter new state: 2
 *      Boo Boo is Playing
 *      Enter new state: -1
 *      Goodbye

 * Pseudo code:
 *     Create a Scanner object
 *     name = use Scanner to read user input of pet name
 *     pet = new CyberPet(name)
 *     state = use Scanner to read user input of new state
 *     while (state >= 0 && state <= 2) {
 *     if state = 0, call pet.sleep()
 *     if state = 1, call pet.eat()
 *     if state = 2, call pet.play()
 *     print name and current state of the pet
 *     state = use Scanner to read user input of new state
 *     }
 *     print "Goodbye"s
 */

import java.util.Scanner;

public class CyberPetApp {
	
	public static void main(String[] args) { 
	    //TODO: add code of this main method below>
		Scanner input = new Scanner(System.in);
		System.out.print("Enter pet name: ");
		String name = input.nextLine();
		CyberPet pet = new CyberPet(name);
		System.out.print("Enter new state: ");
		int state = input.nextInt();
		while ( state >= 0 && state <=2)
		{	if (state == 0) pet.sleep();
			else if (state == 1) pet.eat();
			else pet.play();
			System.out.print(pet.toString() + pet.getState() + "\n");	
			System.out.print("Enter new state: ");
			state = input.nextInt();
		}
	
		System.out.println("Goodbye");
			
		//TODO: add the following code at the end of this main method below
	    //1. create an instance of the CyberPetSwing named app
		CyberPetSwing app = new CyberPetSwing();
		
	    //2. call the setVisible method of the above instance with input argument true
		app.setVisible(true);
	}
}
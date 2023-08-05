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

public class CyberPet {
	String name;
	int state;
	
	public CyberPet(String p_name) {
		name = p_name;
	}
	
	public void setName(String p_name) { 
		name = p_name;
		}

		public String getName() { 
		return name;
		}

		public void eat() { 
		//TODO: add code of the eat method below
			state = 1;
		}

		public void sleep() { 
		//TODO: add code of the sleep method below
			state = 0;
		}

		public void play() { 
		//TODO: add code of the play method below
			state = 2;
		}

		public String getState() { 
		if (state == 0) return "Sleeping";
		else if (state ==1) return "Eating";
		else if (state == 2) return "Playing";
		else return "Error";
		}

		public String toString() { 
		//TODO: add code of the toString method below
			return (name + " is ");
		}
}

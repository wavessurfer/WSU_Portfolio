import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Welcome to your Course Management System");
		System.out.println("Please enter your name: ");
		String name = in.nextLine();
		
//		create the objects
		System.out.println("Enter the number of courses you want to add: ");
		int amount = in.nextInt();
		ArrayList <Course> Courses = new ArrayList<Course>();
//		add Course Info

		for(int i = 0; i < amount; i++) {
			Courses.add(new Course());
			System.out.println("Enter information for course #" + (i+1));
			Menus.setCourseInfo(Courses.get(i));
      System.out.println("__________________________________________");
			}
//		go to main menu
		Menus.mainMenu();
    System.out.println("__________________________________________");
		
		while (Menus.option >= 1 && Menus.option <= 3)
			if (Menus.option == 1) {
//				Add more Courses objects
				System.out.println("Enter the number of courses you want to add: ");
				int amount2 = in.nextInt();
				int finalamount = amount + amount2;
				for (int i = amount; i < finalamount; i++) {
					Courses.add(new Course());
					System.out.println("Enter information for course #" + (i+1));
					Menus.setCourseInfo(Courses.get(i));
          System.out.println("__________________________________________");
					}
//				update amount
				amount = finalamount;
//				return to main menu
				Menus.mainMenu();
        System.out.println("__________________________________________");

					
				}

			else if (Menus.option == 2) {
//				display courses
				for(int i = 0; i < amount; i++) 
					Menus.prtCourse(Courses.get(i));	
//				choose course to modify
				System.out.println("Enter the ID of the course you want to modify: ");
				String cID = in.next();	    
//		   		modifying menu
				Menus.modMenu();
				int opt = in.nextInt();
//		   choose course item to modify (1 to change credits, 2 to change professor, etc.) NOT WORKING
				for(int i = 0; i < amount;i++) {
					if (Courses.get(i).getCourseID().equals(cID)) {
							while (opt >= 1 && opt <= 7)  {
						if (opt == 1) Courses.get(i).setCourseID();
						else if (opt == 2) Courses.get(i).setCourseTitle();
						else if (opt == 3) Courses.get(i).setCredits();
						else if (opt == 4) Courses.get(i).setYear();
						else if (opt == 5) Courses.get(i).setTerm();
						else if (opt == 6) Courses.get(i).setGrade();
						else if (opt == 7) Courses.get(i).setInstructorName();
						else if (opt == 8) Menus.option = 2;
						else if (opt >= 1 && opt <= 7) Menus.prtCourse(Courses.get(i));
//				   		print the updated course info
						Menus.prtCourse(Courses.get(i));
						Menus.modMenu();
						opt = in.nextInt();
						if (opt > 8) Menus.mainMenu(); 		

			   			}
					break;
					}
					
				}
			}
		
			else if (Menus.option == 3) {
        System.out.println("___________________________________________________________________________________________________");
				System.out.println(name + "'s Transcipt Report");
				for(int i = 0; i < amount; i++)
					Menus.prtCourse(Courses.get(i));
        System.out.println("___________________________________________________________________________________________________");
//				Write it in a txt file
				Menus.mainMenu();
        System.out.println("__________________________________________");
		    	}
				
			else Menus.exit();
		}
}
import java.util.Scanner;

public class Menus {
	public static int option;
  
  static Scanner in = new Scanner(System.in);
  	
	public static void mainMenu(){
		System.out.println("Main Menu:                                ");
		System.out.println("Enter 1 to add more courses               ");
		System.out.println("Enter 2 to modify existing course info    ");
		System.out.println("Enter 3 to print course info              ");
		System.out.println("Enter 4 to exit                           ");

		option = in.nextInt();
	}
	
	public static void setCourseInfo(Course c1) {
		c1.setCourseID();
		c1.setCourseTitle();
		c1.setCredits();
		c1.setYear();
		c1.setTerm();
		c1.setGrade();
		c1.setInstructorName();
	}
	
	
	public static void prtCourse(Course c1) {
		System.out.println("ID\tCourse Title\t\t\t\t\t\tCredits\tTerm\tYear\tGrade\tLetterGrade\tInstructor Name" );
		System.out.println(c1.getCourseID() + "\t" + c1.getCourseTitle() + "\t\t\t\t\t\t" + c1.getCredits() + "\t" + c1.getTerm() +"\t"+ c1.getYear() + "\t" + c1.getGrade() + "\t" + c1.getLetterGrade() + "\t" + c1.getInstructorName() );
 	}
	
	public static void modMenu() {
		System.out.println("Modifying Menu:");
		System.out.println("Enter 1 to update course ID.");
		System.out.println("Enter 2 to update course title.");
		System.out.println("Enter 3 to update credit hours.");
		System.out.println("Enter 4 to update year.");
		System.out.println("Enter 5 to update term.");
		System.out.println("Enter 6 to update grade.");
		System.out.println("Enter 7 to update instructor name.");
		System.out.println("Enter 8 to modify another course.");
		System.out.println("Enter 9 to return to the main menu.");

	}
	public static void exit() {
//		print exit message
		System.out.println("Goodbye!");
		
	}
}
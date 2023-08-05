import java.util.Scanner;

public class Course {
	
	private String course_ID;
	
	private String course_title;
	
	private int credits;
	
	private String year;
	
	private String term;
	
	private int grade;
	
	private String instructor_name; 
	
	static  Scanner in = new Scanner(System.in); 

	static Scanner space = new Scanner(System.in);
	
	public void setCourseID() {
		System.out.println("Enter the course ID (example CS234): ");
		course_ID = in.next();
	}
	
	public String getCourseID() {
		return course_ID; 
	}
	
	public void setCourseTitle() {
		System.out.println("Enter the title (example Algorithms and Problem Solving): ");
		course_title = space.nextLine();
	}
	
	public String getCourseTitle() {
		return course_title;
	}
	
	public void setCredits() {
		System.out.println("Enter the amount of credit hours: ");
		credits = in.nextInt();

	}
	
	public int getCredits() {
		return credits;
	}
	
	public void setYear() {
		System.out.println("Enter the year of the course taken: ");
		year = in.next();

	}
	
	public String getYear() {
		return year;
	}
	
	public void setTerm() {
		System.out.println("Enter the term of the course taken:");
		term = in.next();

	}
	
	public String getTerm() {
		return term;
	}
	
	public void setGrade() {
		System.out.println("Enter the grade you recieved on a 100 point scale: ");
		grade = in.nextInt();


	}

  public int getGrade(){
    return grade;
  }
	
	public String getLetterGrade() {
		if (grade >= 90) return "A";
		else if (grade >=80 && grade <= 89)  return "B";
		else if (grade >= 70 && grade <= 79) return "C";
		else if (grade >= 60 && grade <= 69) return "D";
		else return "F";
	}
	
	public void setInstructorName() {
		System.out.println("Enter the course instructors name: ");
		instructor_name = space.nextLine();

	}
	
	public String getInstructorName() {
		return instructor_name;
	}
}
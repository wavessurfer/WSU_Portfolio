/*
*Author: Jose Ortega
*Assignment: Homework #3
*Date: 10/27/2021
*
*Problem Description: Develop a Java GUI application to read a text file containing students’ information into your program. Then, print several statistics measures with  student’s grades.
*Inputs:	students_grades.txt
*			int ID;
*			double grade;
			String name;
			847342, Kaitlin Goyette, 2.50
*Output:	Min grade: 1.99
			Max grade: 3.96
			Avg grade: 2.93
			Percentage od students who got A: 20.0%
			Percentage od students who got B: 20.0%
			Percentage od students who got C: 20.0%
			Percentage od students who got D: 10.0%
			Percentage od students who got F: 30.0%
*
*/
public class Student {
	int ID;
	String name;
	double grade;
	

	/**
	 * @param id
	 * @param name
	 * @param grade
	 */
	public Student(int id, String name, double grade) {
		ID = id;
		this.name = name;
		this.grade = grade;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return ID;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		ID = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the grade
	 */
	public double getGrade() {
		return grade;
	}


	/**
	 * @param grade the grade to set
	 */
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	


	@Override
	public String toString() {
		return "Student [ID=" + ID + ", Name=" + name + ", Grade=" + grade + "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		

	}

}

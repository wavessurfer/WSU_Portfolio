/*
*Author: Jose Ortega
*Assignment: Homework #3
*Date: 10/12/2021
*
*Problem Description: Develop a Java application to store students’ information into the project. 
*Goals: Accurately store multiple Students' info into objects
*Inputs:	students.txt
*			int ID, t, year;
			String name, email;
*Output:	Student: 847342, Kaitlin Goyette, 2015, kaitlin.goyette@test.edu
*
*/

public class Student {
	int ID, year;
	String name, email;

	Student(int ID, String name, int year, String email){
		this.ID = ID;
		this.year = year;
		this.name = name;
		this.email = email;
		
	}
		
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD the ID to set
	 */
	public void setID(int ID) {
		this.ID = ID;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "Student: " + ID + ", " + name + ", " + year + ", " + email;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

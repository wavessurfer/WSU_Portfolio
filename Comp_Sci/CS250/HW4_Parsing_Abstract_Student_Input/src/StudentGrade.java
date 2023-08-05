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

import java.io.*;
import java.util.*;

public class StudentGrade {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// Define a dynamic data structure variable named arrStudents to store a collection of Student objects
		ArrayList<Student>  arrStudents= new  ArrayList<>();
		
		//Write code that uses Java IO library to reads each line of the file students_grades.txt Remember to use try-catch to handle IO exceptions and parsing exceptions (could be thrown when parsing ID and grade)
		String filepath = "src/students_grades.txt";
		File inFile = new File(filepath);
		try (BufferedReader br = new BufferedReader(new FileReader(inFile));) {
			String line;
			while ((line = br.readLine()) != null) {
				//parse into multiple tokens
				String[] arr = line.split(",\\s+");
				int id = Integer.parseInt(arr[0]);
				String name = arr[1];
				double grade = Double.parseDouble(arr[2]);
				//create the Student object and add it to the arrStudents.
				Student stud = null;
				//Also, you should display an error message “Grade should be between 0.0 and 4.0” and exit if the grade in the file is not valid.
				if( grade < 4 && grade > 0) {
					stud = new Student(id,name,grade);
					arrStudents.add(stud);
				} else throw new Exception("Grade should be between 0.0 and 4.0");
				}
			
			//Loop through the Students objects in and print the max, min, average grade of all students, percentage of grades A, B, C, D, and F
			double max = 0,min = 4,sum = 0,avg = 0,a = 0, b = 0,c = 0,d = 0,f = 0;
			for(Student i: arrStudents) {
				if (i.getGrade() > max)
					max = i.getGrade();
				else if (i.getGrade() < min)
					min = i.getGrade();
				sum += i.getGrade();
				if (i.getGrade() >=3.6 && i.getGrade() <=4)
					a++;
				else if (i.getGrade() >=3.2 && i.getGrade() <=3.6)
					b++;
				else if (i.getGrade() >=2.8 && i.getGrade() <=3.2)
					c++;
				else if (i.getGrade() >=2.4 && i.getGrade() <=2.8)
					d++;
				else if (i.getGrade() <2.4)
					f++;
			}
			avg = sum / arrStudents.size();
			System.out.println("Min grade: " + min + "\nMax grade: " + max);
			System.out.printf("Avg grade: %.2f\n", avg);
			System.out.println("Percentage od students who got A: " + (a / arrStudents.size()*100)+"%");
			System.out.println("Percentage od students who got B: " + (b / arrStudents.size()*100)+"%");
			System.out.println("Percentage od students who got C: " + (c / arrStudents.size()*100)+"%");
			System.out.println("Percentage od students who got D: " + (d / arrStudents.size()*100)+"%");
			System.out.println("Percentage od students who got F: " + (f / arrStudents.size()*100)+"%");

			} catch(FileNotFoundException fnfe) {
				System.out.println("File " + filepath + "does not exist!");
			} catch(IOException ex) {
				System.out.println("File " + filepath + "could not be read!");
			} catch(NumberFormatException nfe) {
				System.out.println("Invalid inputs in the file " + filepath);
			} catch (ArrayIndexOutOfBoundsException aiobe) {
				System.out.println("Check the total number of records in the file " + filepath);
			}
		

	}

}
package lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class CourseRegistration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, List<String>> students = new HashMap<>();
		List <String> courselist = new ArrayList<>();
		System.out.println("Enter the list of course registration: ");
		while(true) {
			//Use scanner to read an input line as String
			String line = sc.nextLine();
			//Split line into a string array by space
			String[] arr = line.split(" ");
			//student_id = Parse the first element in the string array into Integer
			int student_ID = Integer.parseInt(arr[0]);
			//if student_ID == 1, exit the loop
			if (student_ID == -1) break;
			//course_name = the second element in the string array
			String courseName = arr[1];
			
			if(!courselist.contains(courseName))
				courselist.add(courseName);
			//If student_ID is not a key in the HashMap students
			if (!students.containsKey(student_ID)) {
				//Create an ArrayList of String and put course_name into it
				ArrayList<String> arl = new ArrayList<>();
				arl.add(courseName);
				//Put a new entry (student_ID, arl) into the HashMap
				students.put(student_ID, arl);
			}
			else {
				//Get the value corresponding to student_ID in the HashMap students
				List<String> arl = students.get(student_ID);
				//Append coursename into arl if such course name does not exist
				//in the list yet. Otherwise, output an error.
				if(!arl.contains(courseName)) arl.add(courseName);
				//put back the entry (student_ID, arl) into the HashMap students
				students.put(student_ID, arl);
			}
			
		}
		
		
		System.out.println("Enter course name to print students IDs:");
		Scanner s = new Scanner(System.in);
		String coursename = "";
		List <Integer> studs = new ArrayList<>();
		
		while (true) {
			String cn = s.nextLine();
			if (cn.equals("-1")) break;
			for (Entry<Integer, List<String>> entry : students.entrySet()) {
				
				for ( int i = 0; i < entry.getValue().size(); i++)
				if(cn.equals( entry.getValue().get(i)) ) {
					
					  coursename = entry.getValue().get(i); 
					 
					 studs.add(entry.getKey());
				}

			}
			System.out.println("Students in " + coursename + ": " + studs);
			studs.removeAll(studs);
			
		}
		
		System.out.println();
		int count = 0;
		String cn2 = "";
		
		for (String cn : courselist) {
			for (Entry<Integer, List<String>> entry : students.entrySet()) {
				
				for ( int i = 0; i < entry.getValue().size(); i++)
				if(cn.equals( entry.getValue().get(i)) ) {
										 
					 studs.add(entry.getKey());
					 
				}
				
				
			}
			
			if(count < studs.size()) {
				count = studs.size();
				cn2 = cn;
			}
			studs.removeAll(studs);
			
			
		}
		
		
		System.out.println("Course with maximum enrolled students is: " + cn2 + " with " + count + " students.");

		

		//loop to print the list of courses enrolled by each student
//		for(int sID :students.keySet()) {
//			List<String> arl = students.get(sID);
//			System.out.println("Student " + sID + ": " + arl);
//		}

	}

}

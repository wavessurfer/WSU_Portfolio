/*
*Author: Jose Ortega
*Assignment: Homework #5
*Date: 10/27/2021
*
*Problem Description: Develop a Java application to read a text file containing cars' information into your program. Then, sort all data based on different attributes of the cars.
*Inputs:	cars.txt
*			int ID, year;;
			String make, model, plate;
			[201, Toyota, Camry, 1985, VRX-6224]
*Output:	Sorted data based on each attribute (numerical descending order, or alphabetical descending order)
*
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CarSorting {
	//list of cars read from file cars.txt
	private static List<Car> listCars = new ArrayList<>(); 
	
	//Method reads file src/cars.txt and load the records into listCars
	private static void readCarsFile() {
		//Java IO library to reads each line of src/cars.txt
		//Using try-catch to handle IO exceptions 
		String filepath = "src/cars.txt";
		File inFile = new File(filepath);
		try (BufferedReader br = new BufferedReader(new FileReader(inFile));) {
			String line;
			while ((line = br.readLine()) != null) {
				//parse into multiple tokens
				String[] arr = line.split(",\\s+");
				int id = Integer.parseInt(arr[0]);
				String make = arr[1];
				String model = arr[2];
				int year = Integer.parseInt(arr[3]);
				String plate = arr[4];
				//create the Student object and add it to the arrStudents.
				Car car = new Car(id,year, model, make,plate);
					listCars.add(car);
			} 
		} catch(FileNotFoundException fnfe) {
			System.out.println("File " + filepath + "does not exist!");
		} catch(IOException ex) {
			System.out.println("File " + filepath + "could not be read!");
		} catch(NumberFormatException nfe) {
			System.out.println("Invalid inputs in the file " + filepath);
		}
	}
	
	/**
	* Sort the Object array using selection sort algorithm
	* @param n: integer referencing an attribute to sort the list
	* @return: none (this method will internally modify the order of elements of the array)
	*/
	public static <E extends Comparable<E>> void insertionSort(int n) {
		//TODO Add code below
		switch(n) {
			//ID
			case 0: {
				for(int i = 1; i < listCars.size(); i++) {
					int tmp = listCars.get(i).getID();
					int j = i-1;
					while ( j >= 0) {
						if(listCars.get(j).getID() > tmp ) {
							Collections.swap(listCars, j, j+1);		//shift the object at the index j to the right one slot
							j--;
						} else {
							break;
						}
					}
				}
				for (Object i : listCars)
					System.out.print(i + "\n");
			}

			break;
			
			//Make
			case 1: {
				for(int i = 1; i < listCars.size(); i++) {
					String tmp = listCars.get(i).getMake();
					int j = i-1;
					while ( j >= 0) {
						if(listCars.get(j).getMake().compareTo(tmp) > 0 ) {
							Collections.swap(listCars, j, j+1);		//shift the object at the index j to the right one slot
							j--;
						} else {
							break;
						}
					}
				}
				for (Object i : listCars)
					System.out.print(i + "\n");
				
			} break;
			
			//Model
			case 2: {
				for(int i = 1; i < listCars.size(); i++) {
					String tmp = listCars.get(i).getModel();
					int j = i-1;
					while ( j >= 0) {
						if(listCars.get(j).getModel().compareTo(tmp) > 0 ) {
							Collections.swap(listCars, j, j+1);		//shift the object at the index j to the right one slot
							j--;
						} else {
							break;
						}
					}
				}
				for (Object i : listCars)
					System.out.print(i + "\n");
				
			} break;
			
			//Year
			case 3: {
				for(int i = 1; i < listCars.size(); i++) {
					int tmp = listCars.get(i).getYear();
					int j = i-1;
					while ( j >= 0) {
						if(listCars.get(j).getYear() > tmp ) {
							Collections.swap(listCars, j, j+1);		//shift the object at the index j to the right one slot
							j--;
						} else {
							break;
						}
					}
				}
				for (Object i : listCars)
					System.out.print(i + "\n");
				
			} break;
			
			//Plate
			case 4: {
				for(int i = 1; i < listCars.size(); i++) {
					String tmp = listCars.get(i).getPlate();
					int j = i-1;
					while ( j >= 0) {
						if(listCars.get(j).getPlate().compareTo(tmp) > 0 ) {
							Collections.swap(listCars, j, j+1);		//shift the object at the index j to the right one slot
							j--;
						} else {
							break;
						}
					}
				}
				for (Object i : listCars)
					System.out.print(i + "\n");
				
			} break;
			
			//Exit program
			case -1: {
				System.out.println("Exit!");
				System.exit(0);
			}
		}
	}
			
	public static void main(String[] args) {
		// Read the cars.txt file to load the cars into listCars
		readCarsFile();
		for (Object i : listCars)
			System.out.print(i + "\n");
			
		System.out.println();
		
		// Sort the list of cars in different ways
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.print("Enter sort option: 0-ID, 1-Make, 2-Model, 3-Year, 4-LP, or -1 to Exit: ");
			int att = Integer.parseInt(sc.nextLine());
			insertionSort(att);

		}
	}
}

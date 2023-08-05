import java.util.*;
import java.io.*;

public class Hw6 {
	
	public static void maxOccurences(List<Integer> l) {
		HashMap<Integer, Integer> map = new HashMap<>();
		if (!l.isEmpty()) {
			
			for (int i = 0; i < l.size()-1;i++) {
				
				if (!map.containsKey(l.get(i))) {
					map.put(l.get(i),1);
					}
				else {
					//increase count
					int n = map.get(l.get(i));
					n++;
					//overwrite existing entry
					map.put(l.get(i),n);
				}
			}
			int mode = 0;
			int maxOcc = 0;
			for (int i : map.keySet()) {
				if(map.get(i) > maxOcc) {
					mode = i;
					maxOcc = map.get(i);
				}
			}
			System.out.println(mode +" has the maximum of "+ maxOcc +" occurrances.");
			
		} else System.out.println(0);
	}
	
	public static void methodA(int n) {
		if (n < 1) {
			System.out.print('B');
		} else {
			methodA(n - 1);
			System.out.print('R');
		}
	}
	
	private static void removeDuplicatesOfStringList() {
		//original list of names read from txt file
		 List<String> ol = new ArrayList<>();
		
		//Java IO library to reads each line of src/cars.txt
		//Using try-catch to handle IO exceptions 
		String filepath = "src/names.txt";
		File inFile = new File(filepath);
		try (BufferedReader br = new BufferedReader(new FileReader(inFile));) {
			String line;
			while ((line = br.readLine()) != null) {
			ol.add(line);
			}
		} catch(FileNotFoundException fnfe) {
			System.out.println("File " + filepath + "does not exist!");
		} catch(IOException ex) {
			System.out.println("File " + filepath + "could not be read!");
		} catch(NumberFormatException nfe) {
			System.out.println("Invalid inputs in the file " + filepath);
		}
		
		System.out.println("Original List: " + ol);
				
		//new list without duplicates
		List<String> l = new ArrayList<>();
		if(!ol.isEmpty()) {
			for(String name: ol) {
				if(!l.contains(name))
					l.add(name);
			}

		}
		
		System.out.println("List without Duplicates: " +l);	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l = new ArrayList<>(Arrays.asList(2, 3, 1, 3, 5, 4, 6, 3, 8));
		System.out.println("Question 1:\nArrayList: " + l);
		maxOccurences(l);
		System.out.println();
		System.out.println("Question 2:\nThe original output of methodA(3) is:");
		methodA(3);
		System.out.println("\nIf we swap line 39 with 40, the output would be RBRR because it would call the recursive after printing 'R'");
		System.out.println("\nQuestion 3:\nThe easiest way to sort an ArrayList (like the one in Q1) is by calling the sort() method in the Collections class and then reversing the  list by calling the reverse() method in the same Collections class");
		Collections.sort(l);
		Collections.reverse(l);
		System.out.print(l);
		System.out.println("\n\nQuestion 4: Remove duplicate names in a text file");
		removeDuplicatesOfStringList();
		
		
	}
}

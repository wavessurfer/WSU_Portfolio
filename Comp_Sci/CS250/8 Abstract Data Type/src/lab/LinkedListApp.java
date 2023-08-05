package lab;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class LinkedListApp {
	
	//Generate a LinkedList of Integer between 0-n
	private static LinkedList<Integer> genLLn(int n) {
	//TODO add code below
		LinkedList<Integer> ll = new LinkedList<>();
		if (n <= 0) {
			//throw new IllegalArgumentException("n should be positive!");
			for (int i = n; i <= 0; i++)
				ll.add(i);
		} else {
			for(int i = 0; i <= n; i++)
				ll.add(i);
		}
		return ll;
	}
	
	//Return the reverse of the input linked list
	private static LinkedList<Integer> reverse(LinkedList<Integer> list) {
	//TODO add code below
		LinkedList<Integer> newLL = new LinkedList<>();
		for (int i = list.size() - 1; i >= 0; i--)
			newLL.add(list.get(i));
		return newLL;
	}
	
	//Calculate the sum of the power of two of the elements in the input linked list
	//[0, 1, 2, 3] => return {0^2 + 1^2 + 2^2 + 3^2)
	private static double sumPower2LL(LinkedList<Integer> list) {
	//TODO add code below
		double sum = 0;
		for (int i = 0; i < list.size(); i++)
			sum += Math.pow(list.get(i), 2);
		return sum;
	}
	
	/**
	* Remove the duplicate elements in a linked list
	* @param list: the LinkedList of Integer
	* @return: the Set of Integer which containing no-duplicate elements from the input
	list
	*/
	private static Set <Integer> removeDuplicate(LinkedList<Integer> list) {
	//TODO add code below
		Set<Integer> set = new HashSet<>();
		for(Integer i : list) {
			if (!set.contains(i));
			set.add(i);
		}
		return set;
	}
	
	private static LinkedList <String> merge (LinkedList <String> l1, LinkedList <String> l2) {
	//TODO add code below	
		LinkedList<String> l = new LinkedList<>();
		for(String i : l1) {
			l.add(i);
		}
		
		for(String i : l2) {
			if(!l.contains(i))
			l.add(i);
		}
		return l;
	}

	public static Set<String> common(Set<String> set1, Set<String> set2) {
		//TODO Add code below
		Set <String> s = new HashSet<>();
		
		for(String i : set1) {
			if(set2.contains(i))
			s.add(i);
		}
		return s;
		}

	
	public static void main(String[] args) {
	//TODO add code below
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter n: ");
			int n = sc.nextInt();
			LinkedList<Integer> ll = genLLn(n);
			System.out.println("LinkedList: " + ll);
			System.out.println("Reverse LinkedList: " + reverse(ll) );
			System.out.println("Sum of LinkedList to the Power 2: " + sumPower2LL(ll));
			System.out.println();

			System.out.println("Enter the list of integer numbers");
			LinkedList<Integer> ll2 = new LinkedList<>();
			
			Scanner s = new Scanner(System.in);
			//Use the Scanner object to read an input line
			String line = s.nextLine();
			//Split the input line into a String array using the space delimiter
			String[] arr = line.split(" ");
			//Parse each string element in the String array into an Integer and add it to the LinkedList object
			for(String str : arr) {
				int num = Integer.parseInt(str);
				ll2.add(num);
			}
			//Remove the duplicate elements and get a Set object by calling the removeDuplicate() method
			Set<Integer> setObj = removeDuplicate(ll2);
			System.out.println("Set object with no duplicates: " + setObj);
			System.out.println();
			
			LinkedList <String> ll3 = new LinkedList<>(Arrays.asList("e", "f", "a"));
			System.out.println("ll3: " + ll3);
			LinkedList <String> ll4 = new LinkedList<>(Arrays.asList("b", "a", "d", "c"));
			System.out.println("ll4: " + ll4);
			System.out.println("Merge of ll3 & ll4: " + merge(ll3, ll4));
			System.out.println();
			
			Set <String> s1 = new HashSet <>(Arrays.asList("b", "a", "d", "c"));
			System.out.println("set1: " + s1);
			Set <String> s2 = new HashSet <>(Arrays.asList("e", "f", "a", "c"));
			System.out.println("set2: " + s2);
			System.out.println("Common of set1 & set2: " + common(s1,s2));
			
			
			} catch (IllegalArgumentException iae) {
			System.out.print(iae.getMessage());
		}
	}
}

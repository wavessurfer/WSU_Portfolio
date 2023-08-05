import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Part1 {
	
	/*
	This method receives a List of Integer parameter (list) and returns another List object that contains no duplicated elements from the list.
	*/
	public static List<Integer> removeDuplicates(List<Integer> list) { //TODO: add code below
		List<Integer> lst = new ArrayList<>();
		for(Integer i : list) {
			if (!lst.contains(i));
			lst.add(i);
		}
		return lst;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Character> charLL = new LinkedList<>();
		
		//a.	Add three characters ‘A’, ‘C’, ‘E’ to the linked list charLL.
		charLL.add('A');
		charLL.add('C');
		charLL.add('E');

		//b.	Assume charLL contains the three characters after the previous operations, write code to insert ‘B’ and ‘D’ into charLL so that ‘B’ is between ‘A’ and ‘C’, ‘D’ is between ‘C’ and ‘E’.
		charLL.add(1,'B');
		charLL.add(3,'D');
		//c.	Write code to print the characters in the linked list charLL in the reversed order (so, the sequence E, D, C, B, A should be displayed on the Console).
		LinkedList<Character> newLL = new LinkedList<>();
		for (int i = charLL.size() - 1; i >= 0; i--)
			newLL.add(charLL.get(i));
		System.out.println("newll: " + newLL);
		System.out.println();
		
		List<Integer> list = Arrays.asList(2, 3, 1, 3, 5, 4, 6, 3, 5);
		System.out.println(removeDuplicates(list) );

	}

}

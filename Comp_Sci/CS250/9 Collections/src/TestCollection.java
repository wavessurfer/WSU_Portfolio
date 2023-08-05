import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TestCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create a list with the following elements: 
		//2, 4, 5, , 10, 8, 7, 6, 1, 9
		
		//List<Integer> aList = new ArrayList<>();
		//aList.add(2); aList.add(2); ... TOO MANY STEPS
		
		//List <Integer> aList = (Arrays.asList(2, 4, 5, 0, 10, 8, 7, 6, 1, 9)); // => exceptions if trying to modify the list
		

		List <Integer> aList = new ArrayList<>(Arrays.asList(2, 4, 5, 0, 10, 8, 7, 6, 1, 9));
		System.out.println("List: " + aList);
		aList.remove(3); //cause the exception with the first attempt
		System.out.println("List: " + aList);
		
		Collections.reverse(aList); //reverse the order of the elements in the aList object
		System.out.println("Reversed list: " + aList);
		
		Collections.sort(aList);
		System.out.println("Sorted list: " + aList);
		
		System.out.println("Index of 6 in the list: " + Collections.binarySearch(aList, 6));
		
		System.out.println("Max of list: " + Collections.max(aList) + ", min of list: " + Collections.min(aList));

		Collections.shuffle(aList);
		System.out.println("Shuffled list: " + aList);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (Integer i : aList)
			pq.add(i);
		//Dequeue from pq
		System.out.println("Dequeue from PriorityQueue");
		while (!pq.isEmpty())
			System.out.print(pq.remove() + " ");
		System.out.println();
		
		//Map interface
		Map <String, List<String>> phoneMap = new HashMap<>();
		phoneMap.put("Stacy", new ArrayList <String> (Arrays.asList("789-123-4567", "143-536-8763")));
		phoneMap.put("Daniel",  new ArrayList <String> (Arrays.asList("789-812-3562")));
		phoneMap.put("Lucas", new ArrayList <String> (Arrays.asList("123-456-7890")));
		phoneMap.put("James", new ArrayList <String> (Arrays.asList("456-789-1237")));
		System.out.println("PhoneMap: " + phoneMap);
		if (phoneMap.containsKey("Lucas")) {
			System.out.println("Phone number of Lucas before inserting new one: " + phoneMap.get("Lucas"));
			List <String> list = phoneMap.get("Lucas");
			list.add("678-367-6543");
		}
		else System.out.println("No phone records of Lucas");
		System.out.println("PhoneMap: " + phoneMap); 
		
		
	}

}

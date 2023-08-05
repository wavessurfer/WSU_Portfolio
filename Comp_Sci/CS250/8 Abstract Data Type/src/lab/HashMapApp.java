package lab;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hash = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		while (true) {
//			Use the Scanner object to read an input line
			String line = sc.nextLine();
//			- String[] arr = Split the line using a space delimiter
			String[] arr = line.split(" ");
//			- If arr[0] equals “A”, then add an entry to the HashMap with key=arr[1], value=arr[2]
			if(arr[0].equals("A")) {
				int pId = Integer.parseInt(arr[1]);
				String pName = arr[2];
				hash.put(pId, pName);
			}
//			- If arr[0] equals “R”, then remove an entry to the HashMap with key=arr[1]
			else if (arr[0].equals("R")) {
				int pId = Integer.parseInt(arr[1]);
				if (hash.containsKey(pId)) {
					hash.remove(pId);
					System.out.println("Person ID " + pId + " has been removed");
				} else System.out.println("Person ID " + pId + " does not exist");
			}
//			- If arr[0] equals “SK”, then search and display an entry in the HashMap with key=arr[1]
			else if (arr[0].equals("SK")) {
				int pId = Integer.parseInt(arr[1]);
				if (hash.containsKey(pId)) {
					System.out.println("Person ID " + pId + " does exist. Name  = " + hash.get(pId));
				} else System.out.println("Person ID " + pId + " does not exist");
			}
//			- If arr[0] equals “SV”, then search and display an entry in the HashMap with value=arr[1]
			else if (arr[0].equals("SV")) {
				String pName = arr[1];
				if (hash.containsValue(pName)) {
					System.out.println("Person Name " + pName + " does exist");
				} else System.out.println("Person ID " + pName + " does not exist");
			}
//			- If arr[0] equals “V”, then display all entries in the HashMap
			else if (arr[0].equals("V")) {
				System.out.println("HashMap: " + hash);
			}
//			- Otherwise, exit
			else {
				break;
			}
		}
	}
}

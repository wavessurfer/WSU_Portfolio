import java.util.LinkedList;

public class Array_Linked_List {
	
	public static void printArray (int[] arr) {
		for (int i: arr)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arrInt = {3, 4, 5, 7};
		printArray(arrInt);
		
		int [] arrIntNew = new int [arrInt.length + 1];
		for (int i = 0; i < 3; i++)
			arrIntNew[i] = arrInt[i];
		arrIntNew[3] = 6;
		for (int i = 4; i < arrIntNew.length; i++)
			arrIntNew[i] = arrInt[i - 1];
		printArray(arrIntNew);
		
		LinkedList <Integer> list = new LinkedList<>();
		for (int i : arrInt)
			list.add(i);
		System.out.println("Before linked list: " + list);
		
		list.add(3, 6);
		System.out.println("After linked list: " + list);

	}

}

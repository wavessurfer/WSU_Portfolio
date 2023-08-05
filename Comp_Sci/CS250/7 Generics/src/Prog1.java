
public class Prog1 {
	
	private static void printObjArray(Object[] arrObj) {
		//TODO add code below
		for (Object object : arrObj)
			System.out.print(object + " ");
			
		System.out.println();
		}
	
	private static void printArray(Integer[] arrInt) {
		//TODO add code below
		for (Integer i : arrInt)
			System.out.print(i + " ");
		
		System.out.println();
		}
	
	private static void printArray(Double[] arrDbl) {
		//TODO add code below
		for (Double i : arrDbl)
			System.out.print(i + " ");
		
		System.out.println();
		}
	
	private static void printArray(Character[] arrChars) {
		//TODO add code below
		for (Character i : arrChars)
			System.out.print(i + " ");
		
		System.out.println();
		}
	
	private static void printArray(String[] arrStr) {
		//TODO add code below
		for (String i : arrStr)
			System.out.print(i + " ");
		
		System.out.println();
		}
	
	/**
	* The generic method to print an array of a generic type
	2
	* @param arrObj: the array of the generic type E
	* @return: none
	*/
	
	private static <E> void printArray(E[] arrObj, boolean newLine) {
		//TODO: add code below
		for (E i : arrObj)
			System.out.print(i + (newLine ? "\n" : " "));
		System.out.println();
	}
	
	/**
	* The generic method to search for the index of an array of a generic type
	* @param arrObj: the array of the generic type E
	* @param target: The element to search in the array
	* @return: the index of such an element in the given array, -1 if not found
	*/

	private static <E extends Comparable<E>> int linearSearch(E[] arrObj, E target) {
	//TODO add code below
		for (int i = 0 ; i < arrObj.length; i++) {
			if (arrObj[i].equals(target))
				return i;
		}
		
		return -1;
	}
	
	
	
	private static <E extends Comparable <E>> int binarySearch(E[] arrObj, E target) {
		//TODO add code below
		int low = 0;
		int high = arrObj.length-1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arrObj[mid] == target)
				return mid;
			else if (arrObj[mid].compareTo(target) < 0)
				low = mid + 1;		//Skip the left half from 0 to mid
			else
				high = mid - 1;		//Skip the right half from mid to current high index
			}
		return -1;		//Failed search
		 
	 }

	public static void main(String[] args) {
		//TODO add code below
		Integer [] intArr = {1, 2, 3, 4, 5 };
		Double [] dblArr = {1.1, 2.2, 3.3, 4.4};
		Character [] chrArr = {'H','E','L', 'L', 'O' };
		String [] strArr = {"once", "upon", "a", "time" };
		printObjArray(intArr);
		printObjArray(dblArr);
		printArray(chrArr);
		printArray(strArr);
		
		System.out.println();
		
		// The Person class from Project "6 ArraySearch" was copied and pasted to represent the newLine boolean variable and print it correctly
		Person[] arrPerson = new Person[5];
		arrPerson[0] = new Person("Callum", 1985, 237860451, "MN");
		arrPerson[1] = new Person("Blake", 1946, 867584562, "WI");
		arrPerson[2] = new Person("Kayden", 1999, 628457851, "UT");
		arrPerson[3] = new Person("Colin", 1946, 784583166, "IL");
		arrPerson[4] = new Person("James", 1965, 789451263, "SD");
		
		
		
		printArray(arrPerson, true);
		
		System.out.println("Index of 3 in  intArr: " + linearSearch(intArr, 3));
		System.out.println("Index of 3.0 in  dblArr: " + linearSearch(dblArr, 3.0));
		System.out.println("Index of E in  chrArr: " + linearSearch(chrArr, 'E'));
		System.out.println("Index of a in  strArr: " + linearSearch(strArr, "a"));
		System.out.println("The postion of 3 in intArr is: " + binarySearch(intArr, 3));

			
		}

}

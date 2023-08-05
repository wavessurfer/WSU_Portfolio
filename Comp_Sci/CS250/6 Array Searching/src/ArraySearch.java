import java.util.Arrays;
import java.util.Comparator;
public class ArraySearch {
	/** Search the index of a value in an integer array.
	* @param arrInt - an array containing the elements to be searched.
	* @param target - the element to be found in arrInt.
	* @return the index of the target element in the array if found; -1
	otherwise.
	*/
	public static void linearSearch(int[] arrInt, int target) {
		//TODO: add code below
		int count = 0;
		boolean n = false;
		for (int i = 0; i < arrInt.length; i++) {
			count++;
			
			if (arrInt[i] == target)  {	//Search is successful
				n = true;
			//System.out.println("The index of " + target + " in arrInt is " + i);
			System.out.println("linearSearch Found " + target + " with " + count + " comparisons");
			break;			
			}
		}
		
		if (n == false)
		System.out.println("linearSearch Not Found " + target + " with " + count + " comparisons");

		//Search failed -no such target on the input array
	}
		
	/** Search the index of a value in an array of Person object.
	* @param arrPerson - an array of Person objects containing the
	elements to be searched.
	* @param year - the birth year of the Person object to be found in
	arrPerson.
	* @return the index of the target element in the array if found; -1
	otherwise.
	*/
	
	public static int linearSearch(Person[] arrPerson, int year) {
		//TODO add code below
		for (int i = 0; i < arrPerson.length; i++) {
			if (arrPerson[i].getBirthYear() == year)
				return i;
		}
		return -1;
	}
	
	/**
	* Use binary search to search for the index target in arrInt.
	* Return -1 if not found
	*/
	public static void binarySearch(int[] arrInt, int target) {
		//TODO: add code below
		int count = 0;
		int low = 0;
		int high = arrInt.length-1;
		while (low <= high) {
			count++;
			int mid = (low + high) / 2;
			if (arrInt[mid] == target) {
				
				//System.out.println("BinarySearch found " + target + " in index" +mid);
				System.out.println("BinarySearch found: " + target + " with " + count + " comparisons");
				break;
			} 
			else if (arrInt[mid] < target)
				low = mid + 1;		//Skip the left half from 0 to mid
			else
				high = mid - 1;		//Skip the right half from mid to current high index
		}
		//Failed search
		if (low > high) {
		//System.out.println("BinarySearch found " + target + " in index" + -1);
		System.out.println("BinarySearch Not found: " + target + " with " + count + " comparisons");
		}				
	}
	
	 public static int binarySearch(Person[] arrPerson, int year) {
		int low = 0;
		int high = arrPerson.length-1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arrPerson[mid].getBirthYear() == year)
				return year;
			else if (arrPerson[mid].getBirthYear() < year)
				low = mid + 1;		//Skip the left half from 0 to mid
			else
				high = mid - 1;		//Skip the right half from mid to current high index
			}
		return -1;		//Failed search
		 
	 }

	
	/* the main application method */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arrInt = {9, 4, 13, 43, -17 };
		linearSearch(arrInt, 9);
		linearSearch(arrInt, 13);
		linearSearch(arrInt, -17);
		linearSearch(arrInt, 99);
		System.out.println();
		
		Person[] arrPerson = new Person[5];
		arrPerson[0] = new Person("Callum", 1985, 237860451, "MN");
		arrPerson[1] = new Person("Blake", 1946, 867584562, "WI");
		arrPerson[2] = new Person("Kayden", 1999, 628457851, "UT");
		arrPerson[3] = new Person("Colin", 1946, 784583166, "IL");
		arrPerson[4] = new Person("James", 1965, 789451263, "SD");
		
		System.out.println("Index of the person with birth year 1985 is " + linearSearch(arrPerson, 1985));
		System.out.println("Index of the person with birth year 1999 is " + linearSearch(arrPerson, 1999));
		System.out.println("Index of the person with birth year 1965 is " + linearSearch(arrPerson, 1965));
		System.out.println("Index of the person with birth year 1995 is " + linearSearch(arrPerson, 1995));
		System.out.println();


		//TEST binarySearch
		Arrays.sort(arrInt);
		for(Integer i : arrInt)
			System.out.print(i + " " );
		System.out.println();
		binarySearch(arrInt, 9);
		binarySearch(arrInt, 13);
		binarySearch(arrInt, -17);
		binarySearch(arrInt, 99);
		System.out.println();

		
		//TEST binarySearch of ArrPerson birthYear
		Arrays.sort(arrPerson, new Comparator <Person> () {
			public int compare(Person p1, Person p2) {
				return p1.getBirthYear() - p2.getBirthYear();
			}
		});
		for (Person obj : arrPerson)
			System.out.println(obj);
		System.out.println();
		System.out.println("binarySearch: Index of the person with birth year 1985 is " + binarySearch(arrPerson, 1985));
		System.out.println("binarySearch: Index of the person with birth year 1999 is " + binarySearch(arrPerson, 1999));
		System.out.println("binarySearch: Index of the person with birth year 1965 is " + binarySearch(arrPerson, 1965));
		System.out.println("binarySearch: Index of the person with birth year 1995 is " + binarySearch(arrPerson, 1995));
		System.out.println();
		
		int [] arrBigInt = new int [1000];
		for (int i = 0; i < arrBigInt.length; i++) {
			arrBigInt[i] = (int) (Math.random()*1000);
		}
		
		Arrays.sort(arrBigInt);
		
		for (int i = 0; i < 5; i++) {
			int random = (int) (Math.random()*1000);
			linearSearch(arrBigInt, random);
			binarySearch(arrBigInt, random);
		}
		
		
		
	}
}


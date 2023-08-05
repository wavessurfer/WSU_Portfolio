package labb;

public class CountNumInArray {
	/**
	* This method counts the number of occurrences of num in the given array
	* @param arr: the input array
	* @param num: the number to be counted in the array
	* @param index: the current index to search and count
	* @return: the number of occurrences of num in arr
	*/
	
	public static int countNumInArray(int[] arr, int num, int index) {
		//If arr is null or index < 0, throw a new IllegalArgumentException with the message “Invalid input!”
		if (arr.equals(null) || arr.length < 0)
			throw new IllegalArgumentException("Invaild input!");
		
		//If index is greater than or equal to the length of arr, then return 0
		else if (index >= arr.length)
			return 0;
		
		//If the element of array arr at index equals to num: return 1 + countNumInArray(arr, num, index + 1)
		else if (arr[index] == num)
			return 1 + countNumInArray(arr, num, index + 1);
		
		//Else return 0 + countNumInArray(arr, num, index + 1)
		else return 0 + countNumInArray(arr, num, index + 1);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1,6,4};
		System.out.println("Count of 6 in arr1: " + countNumInArray(arr1, 6, 0));
		
		int[] arr2 = {1,4};
		System.out.println("Count of 5 in arr2: " + countNumInArray(arr2, 5, 0));
		
		int[] arr3 = {};
		System.out.println("Count of 3 in arr3: " + countNumInArray(arr3, 3, 0));
		
		
	}


}

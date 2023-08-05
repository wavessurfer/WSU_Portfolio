import java.util.Arrays;
import java.util.Scanner;

public class SortingApp {
	//Print all elements of the array in one line and separated by space
	private static <E> void printArray(int[] arrInt) {
	//TODO add code below
		System.out.println(Arrays.toString(arrInt));
	}
	
	//Swap two elements at indexes i and j in array arrInt
	private static void swap(int[] arrInt, int i, int j) {
	//TODO add code below
		//arrInt[i] <-> arrInt[j];
		int tmp = arrInt[i];
		arrInt[i]=arrInt[j];
		arrInt[j] = tmp;
	}
	
	//sort the array using the bubble sort algorithm
	private static void bubbleSort(int[] arrInt) {
	/* TODO add code below
	 * for index i from 0 to less than the length of arrInt - 1
	 * for index j from 0
	 * to less than the length of arrInt - 1 - If arrInt[j] > arrInt[j+1], perform
	 * swapping two of them using the swap() method. Print the two indexes and two
	 * elements that are involved with this swapping action.
	 */
		int cmp =0, swp = 0;
		for (int i=0; i < arrInt.length-1; i++) {
			for (int j=0; j<arrInt.length-1; j++) {
				cmp++;
				if (arrInt[j] > arrInt[j+1]) {
					swap(arrInt,j,j+1);
					System.out.println("bubbleSort: sawp index " + j + " with " + (j+1) + " elements " + arrInt[j+1] + " <-> " + arrInt[j]);
					swp++;
				}
			}
		}
		System.out.println("bubbleSort: Total swaps: "+ swp + ". Total comparisons: " + cmp);
	}
	
	/**
	* Sort the integer array using selection sort algorithm
	* @param arrInt: the integer array to be sorted
	* @return: none (this method will internally modify the order of elements of the array)
	*/
	private static void selectionSort(int[] arrInt) {
		/*
		 * TODO add code below
		 * for index i from 0 to length of arrInt - 1
		 * Use a for loop with index j from i to length of arrInt to find the smallest element
		 * index min
		 * Perform swapping arrInt[i] with arrInt[min] using the swap()
		 * method. Print the two indexes and two elements that are involved with this
		 * swapping action.
		 */
		int cmp =0, swp = 0;
		for (int i=0; i<arrInt.length-1; i++) {
			cmp++;
			int minIndex = i, min = arrInt[i];
			for (int j=i+1; j<arrInt.length; j++) {
				if (arrInt[j] < min) {
					minIndex = j;
					min = arrInt[j];
				}
			}
			swap(arrInt, i, minIndex);
			swp++;
			System.out.println("SelectionSort: sawp index " + minIndex + ", elements " + arrInt[minIndex] + " <-> " + arrInt[i]);
		}
		System.out.println("SelectionSort: Total swaps: "+ swp + ". Total comparisons: " + cmp);
		
	}
	
	
	private static void insertionSort(int[] arrInt) {
		/*
		 * TODO add code below
		 * for index i from 1 to length of arrInt - 1 (inclusive)
		 * - Here, we try to insert the element arrInt[i] in the correct place between [0,
		 * i-1]. So, first store the element arrInt[i] as a temporary integer (temp).
		 * - Then, use a while loop with index j from i-1 to 0 to shift any elements
		 * arrInt[j] in the index range of [0, i-1] that are greater than temp to the
		 * right one slot.
		 * - Finally, put temp (which originally store arrInt[i]) at the
		 * index j+1
		 * - Print the two indexes and two elements that are involved with
		 * this shifting action.
		 */
		int cmp =0, swp = 0;
		for(int i = 1; i < arrInt.length; i++) {
			
			int tmp = arrInt[i];
			int j = i-1;
			while ( j >= 0) {
				cmp++;
				if(arrInt[j] > tmp) {
					arrInt[j+1] = arrInt[j];	//shift the element at the index j to the right one slot
					j--;
					
				} else {
					break;
				}
			}
			arrInt[j+1] = tmp;
			System.out.println("InsertionSort: sawp index " + i + " with " + (j+1) + " elements " + arrInt[j+1] + " <-> " + arrInt[i]);
			swp++;
		}
		System.out.println("InsertionSort: Total swaps: "+ swp + ". Total comparisons: " + cmp);

	}
	
	private static void descInsertSort(int[] arrInt) {
		/*
		 * TODO add code below
		 * for index i from 1 to length of arrInt - 1 (inclusive)
		 * - Here, we try to insert the element arrInt[i] in the correct place between [0,
		 * i-1]. So, first store the element arrInt[i] as a temporary integer (temp).
		 * - Then, use a while loop with index j from i-1 to 0 to shift any elements
		 * arrInt[j] in the index range of [0, i-1] that are greater than temp to the
		 * right one slot.
		 * - Finally, put temp (which originally store arrInt[i]) at the
		 * index j+1
		 * - Print the two indexes and two elements that are involved with
		 * this shifting action.
		 */
		int cmp =0, swp = 0;
		for(int i = 1; i < arrInt.length; i++) {
			
			int tmp = arrInt[i];
			int j = i-1;
			while ( j >= 0) {
				cmp++;
				if(arrInt[j] < tmp) {
					arrInt[j+1] = arrInt[j];	//shift the element at the index j to the right one slot
					j--;
					
				} else {
					break;
				}
			}
			arrInt[j+1] = tmp;
			System.out.println("InsertionSort: sawp index " + i + " with " + (j+1) + " elements " + arrInt[j+1] + " <-> " + arrInt[i]);
			swp++;
		}
		System.out.println("InsertionSort: Total swaps: "+ swp + ". Total comparisons: " + cmp);

	}
	
	public static <E extends Comparable<E>> void insertionSort(E[] arr) {
		//TODO Add code below
		int cmp =0, swp = 0;
		for(int i = 1; i < arr.length; i++) {
			E tmp = arr[i];
			int j = i-1;
			while ( j >= 0) {
				cmp++;
				if(arr[j].compareTo(tmp) > 0 ) {
					arr[j+1] = arr[j];	//shift the element at the index j to the right one slot
					j--;
				} else {
					break;
				}
			}
			arr[j+1] = tmp;
			System.out.println("InsertionSort: sawp index " + i + " with " + (j+1) + " elements " + arr[j+1] + " <-> " + arr[i]);
			swp++;

		}
		System.out.println("InsertionSort: Total swaps: "+ swp + ". Total comparisons: " + cmp);

	}

		

	
	
	
	/**
	* Merge two sorted arrays left and right into the result array
	* @param left: the left sorted array
	* @param right: the right sorted array
	* @param result: the merge sorted array from left and right
	* @return: none (this method will internally merge left and right into result)
	*/
	public static void merge(int[] left, int[] right, int[] result) {
		/*
		 * TODO add code below
		 * Initialize index1 and index2 as 0
		 * For an index i from 0 to less than the length of the result array:
		 * -If index2 is greater than or equal to the length of the right array or 
		 * 	 (index1 < length of the left array and left[index1] <= right[index2]): 
		 * 		-Assign left[index1] to result[i] 
		 * 		-Increase 1 to index1 
		 * -Otherwise, 
		 * 		-Assign right[index2] to result[i] 
		 * 		-Increase 1 to index2
		 */
		int index1 = 0, index2 = 0;
		for (int i=0; i < result.length; i++) {
			if (index2 >= right.length || (index1 < left.length && left[index1] <= right[index2])) {
				result[i] = left[index1];
				index1++;
			} else {
				result[i] = right[index2];
				index2++;
			}
		}
	}
	
	/**
	* Sort the integer array using merge sort algorithm
	* @param arrInt: the integer array to be sorted
	* @return: none (this method will internally modify the order of elements of the array)
	*/
	private static void mergeSort(int[] arrInt) {
	//TODO add code below
//		The base case: if the length of arrInt < 2, do nothing (we do not need to sort an
//		empty array or one-element array)
		if (arrInt.length < 2) {}
		else {
			int[] left = new int [arrInt.length/2];
			int[] right = new int [arrInt.length - arrInt.length/2];
		
//		Otherwise, do the following steps:
//		- Copy the left half with size of arrInt.length/2 of the arrInt into a left array using System.arraycopy() method
		System.arraycopy(arrInt, 0, left, 0, arrInt.length/2);
//		- Copy the right half of the arrInt (remaining arrInt.length - arrInt.length/2
//		elements) into a right array using System.arraycopy() method
		System.arraycopy(arrInt, arrInt.length/2, right, 0, arrInt.length-arrInt.length/2);

		mergeSort(left);	//Make a recursive call of mergeSort on the left array
		mergeSort(right);	//Make a recursive call of mergeSort on the right array
		merge(left, right, arrInt);		//Finally, merge the sorted left and sorted right by using the merge() method
		}
	}
	
	public static void main(String[] args) {
	//TODO add code below
		int[] arrInt = {22,18,12,-4,27,30,36,50,7,68,91,56,2,85,42,98};
		printArray(arrInt);
		Scanner sc = new Scanner(System.in);
		System.out.println("Select the sorting algorithm: 0-Bubble, 1-Selection, 2-Insertion, 3-Merge, 4-DescInsertion: ");
		int alg = sc.nextInt();
		switch(alg) {
		case 0: bubbleSort(arrInt); break;
		case 1: selectionSort(arrInt); break;
		case 2: insertionSort(arrInt); break;
		case 3: mergeSort(arrInt); break;
		case 4: descInsertSort(arrInt); break;
		}
		printArray(arrInt);
		
		System.out.println();
		
		String[] arrStr = {"b", "d", "c", "a", "f", "g", "e", "h"};
		System.out.println(Arrays.toString(arrStr));
		insertionSort(arrStr);
		System.out.println(Arrays.toString(arrStr));

	}

}
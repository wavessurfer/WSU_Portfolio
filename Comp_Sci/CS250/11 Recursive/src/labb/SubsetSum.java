package labb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {
	/**
	* This method determines if there exists a subset of the given array arr
	* that sum of the elements equals to a specific number (k)
	* @param arr: the given input array
	* @param target: the input number to check
	* @param index: the current index of the array
	* @return: true or false - whether there exists a subset of
	*/
	public static boolean subsetSum(int[] arr, int target, int index, List<Integer> subset) {
		//If index is greater than the length of arr, return true
		if (index > arr.length-1)
			return true;
		
		/*If length of the array is 0:
			- If target is 0, return true
			- Else return false*/
		if (arr.length == 0) {
			if (target == 0)
				return true;
			else return false;
		}
		
		/*Otherwise, if the index is the last position in arr
			- If the element at the index position equals the target or target is 0, return
			true
			- Else return false*/
		else if ( index == arr.length -1) {
			if (arr[index] == target) {
				subset.add(arr[index]);
				return true;
			} else if (target == 0)
				return true;
			else return false;
		}
		
		/*
		 * Otherwise: - Make a recursive call on with arr, target - arr[index], index +
		 * 1 - If the previous call returns false, return the result of the recursive
		 * call with arr, target, index+1 - Return the result of the last recursive
		 * call.
		 */
		else {
			boolean ret = subsetSum(arr, target - arr[index], index+1, subset);
			if (!ret)
				return subsetSum(arr, target, index+1, subset);
			else{
				subset.add(arr[index]);
				return ret;
			}
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1};
		int[] arr2 = {2};
		int[] arr3 = {};
		int[] arr4 = {2,4,8};
		boolean ret;
		
		List <Integer> subset = new ArrayList<>();
		
		ret = subsetSum(arr4, 10, 0, subset);
		System.out.println("Subset sum of {2,4,8} = 10  =>  " + ret);
		System.out.println(subset.toString());
		subset.clear();
		
		ret = subsetSum(arr4, 14, 0, subset);
		System.out.println("Subset sum of {2,4,8} = 14  =>  " + ret);
		System.out.println(subset.toString());
		subset.clear();
		
//		System.out.println("Subset sum of {2,4,8} = 9  =>  " + subsetSum(arr4, 9, 0));
//		System.out.println("Subset sum of {2,4,8} = 8  =>  " + subsetSum(arr4, 8, 0));
//		System.out.println("Subset sum of {} = 0  =>  " + subsetSum(arr3, 0, 0));
//		System.out.println("Subset sum of {1} = 1  =>  " + subsetSum(arr1, 1, 0));
//		System.out.println("Subset sum of {2} = 1 start from index 0  =>  " + subsetSum(arr4, 1, 0));







		


		
	}

}

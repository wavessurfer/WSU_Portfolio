
public class Part1 {
	
	public static int[] sumByColumns(int arr[][]){ 
		//TODO: add code below
		int intArr[] = new int[arr.length];
		for (int row = 0; row < arr.length; row++) 
			for (int col = 0; col < arr[row].length; col++) {	
				intArr[row] += arr[row][col] ;
			}
			return intArr;
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arrInt = {{15, 6, 78}, {45, 22, 14}, {4, -1, 8}};
		
		System.out.println(arrInt.toString());
		
		System.out.println();
		
		System.out.println(arrInt[1][0]);
		System.out.println(arrInt[0][1] );
		System.out.println(arrInt[2][2]);
		System.out.println();

		System.out.println(arrInt[1][0] + arrInt[0][1] + arrInt[2][2]);
		System.out.println(arrInt.length);
		
		System.out.println();
		
		for (int row = 0; row < arrInt.length; row++) {
			System.out.println();
			for (int col = 0; col < arrInt.length; col++) {	
				//intArr[row] = 0;
				System.out.print( arrInt[row][col] + " " ) ;
			}
		}
		
		System.out.println();

		
		int[][] arr = {{2, 4, 3, 4}, {7, 3, 4, 3}, {3, 3, 4, 3}, {9, 3, 4, 7}};
		int [] sum=sumByColumns(arr);
		for(int i: sum)
		System.out.println(i);
	}

}

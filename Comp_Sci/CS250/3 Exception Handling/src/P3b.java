import java.util.InputMismatchException;
import java.util.Scanner;

public class P3b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of the sequence: ");
		int len = 0;
		 
			try {
				len = sc.nextInt();
				} catch(InputMismatchException ime) {
				System.err.println("Error! Wrong input of length");
			}
				
		try {
			int[] arr = new int[len];
			for (int i = 0; i < len; i++) {
				String str = sc.next();
				arr[i] = Integer.parseInt(str);
			}
			
			//Calculate the sum
			int sum = 0;
			for (int i = 0; i < len; i++) {
				sum += arr[i];
			}
			
			System.out.println("The sum of the sequence is: " + sum);
		} catch (Exception e) {
			System.err.println("Error! Wrong input of sequence");
			
		}
		
		
		
	}

}

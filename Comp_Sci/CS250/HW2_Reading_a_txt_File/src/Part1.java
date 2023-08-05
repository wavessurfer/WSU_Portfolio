import java.util.Scanner;

public class Part1 {
	
	/**
	*	This method receives the height and weight of a person, calculate BMI,*         and classify the body mass
	*	@param weight: weight in pounds (lb)
	*	@param height: height in inches  (ft)
	*	@return: classification string: Underweight, Normal, Overweight, and Obese
	*/
	public static String calcBMI(double weight, double height) { //TODO add code below
		double bmi = 0;
		String state = null;

		
		
		if (weight > 0 && height > 0) {
			
		
				bmi = weight / (Math.pow(height,2)) * 703;
				
		if (bmi < 18.5) state = "Underweight";
		else if (bmi >= 18.5 && bmi < 25) state =  "Normal";
		else if (bmi >= 25 && bmi < 30) state = "Overweight";
		else state = "Obese";		

		}else {
			throw new IllegalArgumentException("Invalid inputs") ;
		
		}
		
		return state;
			}

	public static void hw2_q3(int num) {
		try {
			System.out.println( "Begin the try block code" ) ;
			if (num > 100) 
				throw new Exception (num + " is too large" );
			System.out.println( "End the try block code" ) ;
		} catch ( Exception e ) {
		System.out.println( "ERROR: " + e.getMessage ( ) ) ;
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println( calcBMI(200,70) + "\n" );
		
		hw2_q3(0);
		hw2_q3(101);
		hw2_q3(150);
		
		
		

	}

}

/**
 * Class Name: UnitConverter
 * Author: Jose Ortega
 * Date: 03/17/21
 * Purpose: To perform the conversion from kilometer to other units
 * Goals:
* - successfully calculate the equivalent of km to miles, meters, centimeter, inches
* Inputs:
* - double km
* Outputs:
* - double 
* Required packages: none
* Test cases:
* 100 km is equivalent to
* - 62.15 miles
* - 100000 meters
* - 3937000 inches
* - 10000000 cm
 */
public final class UnitConverter {
	/* this method converts from kilometer to Miles */
	public static double kmToMile(double km) {
		//TODO: return the input in km to miles
		return km / 1.609;
	}
	
	/* this method converts from kilometer to Meters */
	public static double kmToMeter(double km) {
		//TODO: return the input in km to meter
		return km * 1000;
	}
	
	/* this method converts from kilometer to Inches */
	public static double kmToInch(double km) {
		//TODO: return the input in km to inch
		return km * 39370;
	}
	
	/* this method converts from kilometer to Meter */
	public static double kmToCentimeter(double km) {
		//TODO: return the input in km to centimeter
		return km * 100000;
	}
}

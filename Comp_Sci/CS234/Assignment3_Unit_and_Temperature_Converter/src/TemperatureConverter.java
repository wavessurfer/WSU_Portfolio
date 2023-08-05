/* Class name: TemperatureConverter
* Author: Jose Ortega
* Date: 3/16/2021
* Problem: Print a table of common temperature degrees conversions between Fahrenheit and Celsius
* Goals:
* - print a table from celsius to fahrenheit
* - print another table from fahrenheit to celsius
* Inputs:
* - none
* Outputs:
* - print conversions fro predetermined values of Celsisu and Fahrenheit
* Required packages: none
* Test cases: 
* Table 1: Celsius to Fahrenheit conversion
* Celsius 	Fahrenheit
*0	 	32.00
*5	 	41.00
*10	 	50.00
*15	 	59.00
*20	 	68.00
*25	 	77.00
*30	 	86.00
*35	 	95.00
*40	 	104.00
*45	 	113.00
*
*Table 2: Fahrenheit to  Celsius conversion
*Fahrenheit 	Celsius
*20	 	-6.67
*25	 	-3.89
*30	 	-1.11
*35	 	1.67
*40	 	4.44
*45	 	7.22
*50	 	10.00
*55	 	12.78
*60	 	15.56
*65	 	18.33
*/
public class TemperatureConverter {

public static double CeltoFah( double cel){
	return ((cel * 9)/5) + 32;
	}

public static double FahtoCel(double fah) {
	return (5 * (fah - 32) /9);
	}

public static void main(String[] args) {
	System.out.println("Table 1: Celsius to Fahrenheit conversion");
	System.out.println("Celsius \tFahrenheit");
	int cel;
	for (  cel = 0; cel <= 45; cel += 5) {
		System.out.println(cel + "\t \t" + String.format("%.2f",TemperatureConverter.CeltoFah(cel)));
		}
	
	System.out.println("\nTable 2: Fahrenheit to  Celsius conversion");
	System.out.println("Fahrenheit \tCelsius");
	int fah;
	for (fah = 20; fah <=65; fah +=5) {
		System.out.println(fah + "\t \t" + String.format("%.2f", TemperatureConverter.FahtoCel(fah)));
		}
	}
}
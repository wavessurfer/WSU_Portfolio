/*Class name: InvoiceApp
 * Author: Jose Ortega
 * Date: 2/14/2021
* Problem:
* Goals:
* - maintain software purchasing information
* - print an invoice for a customer
* Inputs:
* - customer_name
* - software_code
* - software_name
* - software_price
* Outputs:
* - print out of invoice
* - calculate total purchase price
* Required packages: none
* Test cases: Verify the accuracy of the invoice outputs.
* - enter valid values for the instance variables
* - enter invalid values for the instance variables
* Pseudo code:
* Step 1: ...
* Step 2: ...
* Step 3: ...
*/
import java.util.Scanner;

public class InvoiceApp {

	public String readUserName() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the customer name: ");
		String c_name = input.next();
		return c_name;
		
		}
	
	public String readSoftwareCode() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the software code: ");
		String s_code = input.next();		
		return s_code;
		}
	
	public static void main(String[] args) {		
		InvoiceApp app = new InvoiceApp();
		String s_name = app.readUserName();
		String s_code = app.readSoftwareCode();
		Invoice obj = new Invoice(s_name, s_code);
			if (s_code.equals("SF001")) {
				obj.setSoftwareName("Chess for Beginners");
				obj.setSoftwarePrice(99);
				obj.printInvoice();
			}
			
			else if (s_code.equals("SF002")) {
				obj.setSoftwareName("Chess for Novices");
				obj.setSoftwarePrice(150);
				obj.printInvoice();
			}
			
			else { System.out.print("The software code is not exist!");
			}			
	}
}


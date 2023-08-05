/* Class name: Invoice
* Author: Jose Ortega
* Date: 2/14/2021
* Problem: Print invoice for two different products
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
*/


public class Invoice {
	private String customer_name;
	private String software_code;
	private String software_name;
	private double software_price;
	
	public Invoice (String c_name, String s_code){
		customer_name = c_name;
		software_code = s_code;
	}
	
	public void setSoftwareName (String s_name) {
		software_name = s_name;
	}
	
	public String getSoftwareName() {
		return software_name;
	}
	
	public void setSoftwarePrice(double s_price) {
		software_price = s_price;
	}
	
	public double getSoftwarePrice() {
		return software_price;
	}

	public void printInvoice() {
		System.out.println("-------------------------");
		System.out.println("Acme Software Invoice");
		System.out.println("Customer Name: " + customer_name);
		System.out.println("Software Code: " + software_code);
		System.out.println("Software Name: " + software_name);
		System.out.println("Amount Due : $" + software_price);
		System.out.println("-------------------------");

	}
	
	
	
}



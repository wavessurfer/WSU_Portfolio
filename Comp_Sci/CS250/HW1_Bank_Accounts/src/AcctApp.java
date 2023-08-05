/*
*Author: Jose Ortega
*Assignment: Homework #1
*Date: 9/7/2021
*
*Problem Description: Develop a Java application to manage different types of 
*Account (Checking and Saving ) in a bank through deposits, withdrawals and interest rates..
*Goals: Accurately calculate and print accounts information
*Inputs:	String account_no
*			Double balance
*			Double interest_rate
*Outputs:	Account number: 2, Current balance: $7083.33, Interest Rate: 5.0%
*
*/

public class AcctApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckingAccount check = new CheckingAccount("1", 1000);
		check.deposit(-500);
		System.out.println("$" + check.getBalance());
		check.deposit(200);
		System.out.println("$" + check.getBalance());
		check.withdraw(100);
		System.out.println("$" + check.getBalance());
		check.withdraw(250);
		System.out.println("$" + check.getBalance());
		check.applyInterest();
		System.out.printf("$%.2f\n", check.getBalance());
		System.out.println(check.toString());
		
		System.out.println();
		
		SavingAccount sav = new SavingAccount("2",1000);
		sav.deposit(-1000);
		System.out.println("$" + sav.getBalance());
		sav.deposit(2000);
		System.out.println("$" + sav.getBalance());
		sav.withdraw(-2000);
		System.out.println("$" + sav.getBalance());
		sav.withdraw(11000);
		System.out.println("$" + sav.getBalance());
		sav.withdraw(5000);
		System.out.println("$" + sav.getBalance());
		sav.applyInterest();
		System.out.printf("$%.2f\n", sav.getBalance());
		System.out.println(sav.toString());

	}

}

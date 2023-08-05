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
public class SavingAccount extends Account {
	private double interest_rate;

	//default constructor
	public SavingAccount() {
		interest_rate = 5;		//interest rate
	}

	//Constructor to initialize internal variables
	public SavingAccount(String acc_no, double bal) {
		super(acc_no, bal);
		interest_rate = 5;
	}

	//this method will increase the balance of the account based on the input.
	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		if (amount < 0) System.out.println("Please insert positive values");
		else super.setBalance(super.getBalance() + amount);

	}

	//this method will decrease the balance of the account based on the input.
	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		if (super.getBalance() > 100 && super.getBalance() > amount) super.setBalance(super.getBalance() - amount);
		else System.out.println("It is not allowed to withdraw money \r\n"
				+ "that will result in a balance of less than $100.");

	}

	//this method will apply interest to the account based on the interest rate.
	@Override
	public void applyInterest() {
		// TODO Auto-generated method stub
		if (super.getBalance() > 0 ) super.setBalance( super.getBalance() + (super.getBalance() * (interest_rate / 100/ 12)));
		else System.out.println("Interest Rate cannot be applied with a negative balance");

	}
	
	//This method will return a string representation of the current information on the account.
	public String toString() {
		return "Account number: " + super.getAccount_no() + ", Current balance: $" 
				+ String.format("%.2f", super.getBalance()) + ", Interest Rate: " + interest_rate + "%";
	}


}

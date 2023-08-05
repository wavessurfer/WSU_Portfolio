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

public abstract class Account {
	private String account_no;		//account number
	private double balance;			//account balance
	
	//default constructor
	Account(){}
	
	//Constructor to initialize internal variables
	Account(String acc_no, double bal){
		this.account_no = acc_no;
		this.balance = bal;
		}

	/**
	 * @return the account_no
	 */
	public String getAccount_no() {
		return account_no;
	}

	/**
	 * @param account_no the account_no to set
	 */
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	//this method will increase the balance of the account based on the input.
	public abstract void deposit(double amount);
	
	//this method will decrease the balance of the account based on the input.
	public abstract void withdraw(double amount);
	
	//this method will apply interest to the account based on the interest rate.
	public abstract void applyInterest();
	
}

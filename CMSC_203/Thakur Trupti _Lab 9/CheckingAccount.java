package com.java.cmsc_203.Lab9;
/**
 * CheckingAccount class inherits BankAccount class.
 * @author Trupti Thakur
 *
 */

public class CheckingAccount extends BankAccount {
	//cost of clearing one check.
private static final double FFE=0.15;

/**
 * constructor accepts name and initial amount.
 * @param name The name of the account holder.
 * @param amount initial amount   
 */
	
	public CheckingAccount(String name, double amount) 
	{
		super(name, amount);
		setAccountNumber(getAccountNumber() + "-10");  
	}
	
	/**allows you to remove money from the account if
	enough money is available,returns true if the transaction was
	completed, returns false if the there was not enough money.
	@param amount  the amount to withdraw from the account
	@return true if there was sufficient funds to complete
	the transaction, false otherwise*/
	@Override
	public boolean withdraw(double amount)
	{
		double claringAmount=FFE+amount;
		super.withdraw(claringAmount);
		boolean completed = true;
	
		return completed;
	}
	
	
	

}

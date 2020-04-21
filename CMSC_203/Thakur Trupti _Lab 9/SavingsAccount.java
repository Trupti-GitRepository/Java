package com.java.cmsc_203.Lab9;

public class SavingsAccount extends BankAccount {
	//represents annual interest rate.
	private double rate=2.5;
	private String savingsNumber="0";
	private String accountNumber ;
	
	/**
	 * The constructor accepts 
	 * @param name   Name of the accountHolder.
	 * @param amount  initial amount 
	 */

	public SavingsAccount(String name, double amount) {
		super(name, amount);
		this.accountNumber= super.getAccountNumber()+"-"+ savingsNumber;
		
		
	}
	/**
	 * constructor creates another savings account for the same person. 
	 * take the original savings account and an initial balance as parameters. 
	 * call the copy constructor of the superclass,
	 *  assign the savingsNumber to be one more than the savingsNumber of the original savings account.
	 * It should assign the accountNumber to be the accountNumber of the superclass concatenated with the hypen
	 *  and the savingsNumber of the new account.
	 * @param originalSavingAccount   accountHoloder's orginal account number 
	 * @param amount
	 */
	
	public SavingsAccount(SavingsAccount originalSavingAccount, double amount) {
		//calling constructor of the superclass.
		super(originalSavingAccount, amount);
		savingsNumber=originalSavingAccount.savingsNumber + 1;
		
		
		accountNumber=super.getAccountNumber()+"-"+savingsNumber;
		
		
	}
	
	
	/**
	 * The method postInterest calculate one month's worth of interest on the balance
	 * and deposite it into the accounts. 
	 */
	public void postInterest() 
	{
		//Calculate monthly interest.
		double interest=(getBalance()*(rate/100))/12;
		deposit(interest);
	}
	
	/**
	*This method override superclass method.
	@return the account number*/
	@Override
	public String getAccountNumber()
	{
		return accountNumber;
	}
	
}

package edu.gcu.bootcamp.java.herman.christina.gcucreditunion;



public class Checking  extends Account{
	
	private double overDraft;
	/**
	 * how to get the amount for overdraft
	 * @return
	 */
	public double getOverDraft() {
		return overDraft;
	}
	/**
	 * how to set the amount for overdraft 
	 * @param overDraft
	 */

	public void setOverDraft(double overDraft) {
		this.overDraft = overDraft;
	} 
	/**
	 * withdrawing from the account, including overdraft fees if statement 
	 */
	//here I am withdrawing from checking, i made this so that is the balance equals or is below 0 it will add the fee,
	//if not it will just withdraw
	
	public double doWithdraw() {
		System.out.print("Enter an amount");
		double amount = sc.nextDouble();
		double newBalance = this.getBalance()-amount;
		if(newBalance < 0 ) {
			newBalance = (this.getBalance()- amount)- this.getOverDraft();
			System.out.println(newBalance);
			this.setBalance(newBalance);
			System.out.printf("\nOVERDRAFT NOTICE: $%.2f fee assesed!\n", this.getOverDraft());
			TransactionHistory history = new TransactionHistory(java.time.LocalDate.now().toString(), this.getAccount(), Double.toString(this.getBalance()), 
					Double.toString(amount), this.getClass().getSimpleName());
			trans.createList(history);	
		}
		else {
			double result = this.getBalance()- amount;
			this.setBalance(result);
			TransactionHistory history = new TransactionHistory( java.time.LocalDate.now().toString(), this.getAccount(), Double.toString(this.getBalance()), 
					Double.toString(amount), this.getClass().getSimpleName());
			trans.createList(history);
		}
  		return amount; 
	
	}
	/**
	 * Constructor for the Checking class
	 * @param balance
	 * @param account
	 */
	//here is my constructor for checking you need a customer, blance and account number to create this account) 
	
	public Checking(Customer customer, double balance, String account){
		super(customer);
		super.setBalance(balance);
		super.setAccount(account);
	}

}

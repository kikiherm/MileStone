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
	
	public double doWithdraw() {
		System.out.print("Enter an amount");
		double amount = sc.nextDouble();
		double newBalance = this.getBalance()-amount;
		if(newBalance < 0 ) {
			newBalance = (this.getBalance()- amount)- this.getOverDraft();
			System.out.println(newBalance);
			this.setBalance(newBalance);
			System.out.printf("\nOVERDRAFT NOTICE: $%.2f fee assesed!\n", this.getOverDraft());
		}
		else {
			double result = this.getBalance()- amount;
			this.setBalance(result);
		}
		return amount; 
	
	}
	/**
	 * Constructor for the Checking class
	 * @param balance
	 * @param account
	 */
	
	
	public Checking(double balance, String account){
	}

}

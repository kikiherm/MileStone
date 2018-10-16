package edu.gcu.bootcamp.java.herman.christina.gcucreditunion;

public class Loan extends Account{
	private double interestRate;
	private double lateFee;
	private boolean paymentMade = false; 

	

	
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public double getLateFee() {
		return lateFee;
	}
	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	} 
	/**
	 * This method deposits money into the loan account 
	 * @param amount
	 * @return
	 */
	//This is where I deposit money into a loan and it takes out the amount you entered 
	//it is suposed to add the amount to an array but it is not working 
	public double doDeposit(double amount) {
		double result = this.getBalance()-amount;
		this.setBalance(result);
		paymentMade= true; 
		TransactionHistory history = new TransactionHistory(java.time.LocalDate.now().toString(), this.getAccount(), Double.toString(this.getBalance()), 
				Double.toString(amount), this.getClass().getSimpleName());
		trans.createList(history);	
		return result;  
	}
	/**
	 * this method adds the interest and late fee 
	 * @return amount
	 */
	//if the loan is not paid it adds a late fee and it adds interest. If the loan is paid it will just add interest 
	public double loanNotPaid() {
		double interest=  ((this.interestRate * this.getBalance())/12);
		if(paymentMade== false) {
			System.out.printf("You have been charged a late fee of $%.2f plus $%.2f interest.\n", this.lateFee, interest);
			double newAmount = this.getBalance() + interest + this.lateFee; 
			this.setBalance(newAmount);
			return newAmount; 
		}
		else {
			paymentMade=false; 
			System.out.printf("No late fee charged, charged $%.2f in interest.\n", interest);
			double newAmount2 = this.getBalance()+ interest;
			this.setBalance(newAmount2);
			return this.getBalance();
		}
		
	}
	
	/**
	 * this is my constructor for Loan
	 * @param customer
	 * @param balance
	 * @param account
	 */
	
	public Loan(Customer customer, double balance, String account) {
		super(customer);
		this.setBalance(balance);
		this.setAccount(account);
	}

}

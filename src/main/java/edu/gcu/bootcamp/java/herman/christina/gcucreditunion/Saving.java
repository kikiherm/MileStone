package edu.gcu.bootcamp.java.herman.christina.gcucreditunion;

public class Saving extends Account{
	
	private double serviceFee;
	private double annualInterestRate; 
	private double minimumBalance;
	/**
	 * how to get the service fee
	 * @return
	 */
	public double getServiceFee() {
		return serviceFee;
	}
	/**
	 * how to set the service fee
	 * @param serviceFee
	 */
	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}
	/**
	 * how to get the annual interest
	 * @return
	 */
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	/**
	 * how to set the annual interest rate 
	 * @param anualInterestRate
	 */
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	/**
	 * how to get the minimum balance 
	 * @return
	 */
	public double getMinimumBalance() {
		return minimumBalance;
	}
	/**
	 * how to set the minimum balance 
	 * @param minimumBalance
	 */
	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	} 
	/**
	 * this method does not return anything it is the end of month claculation for Savings
	 *
	 */
	
	//here I make sure that the account is above the minimum balance, If it is i gives you interest
	public void doEndOfMonth() {
		if(this.getMinimumBalance()> this.getBalance()) {
			double newBalance = this.getBalance()+ this.getServiceFee();
			this.setBalance(newBalance); 
		System.out.println("Calculate end of month items.\nYour account is below the minimum"
				+ "blalance of " + this.getMinimumBalance() + ".\nYou are being charged a service fee of "
				+ this.getServiceFee());
		}
		else {	
			double balanceWithInterest = (this.getBalance() * this.getAnnualInterestRate()) + this.getBalance();
			double interestRate = this.getBalance()* this.getAnnualInterestRate();
			this.setBalance(balanceWithInterest);
				
					System.out.printf("Calculate end of month items.\n"
					+ "You earned $%.2f of interest on your savings account.\n", this.getAnnualInterestRate() );
		}
		
	}
	/**
	 * the Constructor for Saving class  
	 * @param balance
	 * @param account
	 */
	public Saving(Customer customer, double balance, String account) {
		super(customer);
		super.setBalance(balance);
		super.setAccount(account);

		
	}
	
	}
	



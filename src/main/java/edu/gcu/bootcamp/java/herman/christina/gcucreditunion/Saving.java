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
	 * the Constructor for Saving class 
	 * @param balance
	 * @param account
	 */
	
	public Saving(double balance, String account) {}

	}
	



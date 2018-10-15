package edu.gcu.bootcamp.java.herman.christina.gcucreditunion;

import java.util.Scanner;

import edu.gcu.bootcamp.java.herman.christina.bank.BankDemo;

public class Account {
	
	Transaction trans = new Transaction();
	private double balance; 
	private String account;
	private Customer customer; 
	BankDemo bank = new BankDemo("GCU Credit Union");
	
	Scanner sc = new Scanner(System.in);
	
	/**
	 * 
	 * @return
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * 
	 * @param balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * 
	 * @return
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 
	 * @param account
	 */
	public void setAccount(String account) {
		this.account = account;
	} 
	/**
	 * withdraw from any account
	 * @return
	 */
	public double doWithdraw() {
		System.out.print("Enter an amount");
		double amount = sc.nextDouble();
		double result = this.getBalance()- amount;
		this.setBalance(result);
		TransactionHistory history = new TransactionHistory(java.time.LocalDate.now().toString(), this.getAccount(), Double.toString(this.getBalance()), 
				Double.toString(amount), this.getClass().getSimpleName());
		trans.createList(history);
		return amount;
	}
	/**
	 * deposit from any account
	 * @return
	 */
	public double doDeposit() {
		System.out.println("Enter an amount");
		double amount = sc.nextDouble();
		double result = this.getBalance()+amount;
		this.setBalance(result);
		TransactionHistory history = new TransactionHistory(java.time.LocalDate.now().toString(), this.getAccount(), Double.toString(this.getBalance()), 
				Double.toString(amount), this.getClass().getSimpleName());
		trans.createList(history);
		return amount; 
		 
	}
	
	public void displayTransactions() {
		System.out.printf("The transaction history for the month is: \n");
		trans.displayArray();
		}
	
	public void clearTransactions() {
		trans.clearTransactions();
	}
	/**
	 * Constructor for the Account class 
	 * @param customer
	 */
	
	public Account(Customer customer) {
		this.customer= customer; 
	}

}

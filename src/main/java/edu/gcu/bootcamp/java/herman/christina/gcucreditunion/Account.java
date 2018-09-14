package edu.gcu.bootcamp.java.herman.christina.gcucreditunion;

import java.util.Scanner;

import edu.gcu.bootcamp.java.herman.christina.bank.BankDemo;

public class Account {
	
	private double balance; 
	private String account;
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
	 * 
	 * @return
	 */
	public double doWithdraw() {
		System.out.print("Enter an amount");
		double amount = sc.nextDouble();
		double result = this.getBalance()- amount;
		this.setBalance(result);
		return amount;
	}
	/**
	 * 
	 * @return
	 */
	public double doDeposit() {
		System.out.println("Enter an amount");
		double amount = sc.nextDouble();
		double result = this.getBalance()+amount;
		this.setBalance(result);
		return amount; 
		 
	}

}

package edu.gcu.bootcamp.java.herman.christina.gcucreditunion;

public class TransactionHistory {
	String date; 
	String account;
	String type;
	String amount;
	String newAmount;
	
	public TransactionHistory(String date, String account, String type, String amount, String newAmount) {
		this.amount = amount; 
		this.date = date;
		this.type = type; 
		this.account = account; 
		this.newAmount = newAmount; 	
	}
	
	public void printOutTransactions() {
		System.out.println(amount + " "+ date+ " " + type+  " " + account + " " + newAmount);
	}
	

}

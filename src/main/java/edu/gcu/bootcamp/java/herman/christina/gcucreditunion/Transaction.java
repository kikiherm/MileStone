package edu.gcu.bootcamp.java.herman.christina.gcucreditunion;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
	

	public List<TransactionHistory> transactionHistory = new ArrayList<TransactionHistory>();
	
	
	
	public List<TransactionHistory> createList(TransactionHistory transaction) {
		transactionHistory.add(transaction);
		return transactionHistory; 
	}
	
	public void displayArray() {
		System.out.println("The amount of transactions: " + transactionHistory.size());
		for(TransactionHistory transactionHistories: transactionHistory ) {
			transactionHistories.printOutTransactions();
			
		}
		
	}
	public void clearTransactions() {
		transactionHistory.clear();
	}

}

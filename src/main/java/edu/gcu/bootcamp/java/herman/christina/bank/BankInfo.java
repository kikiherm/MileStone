package edu.gcu.bootcamp.java.herman.christina.bank;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import edu.gcu.bootcamp.java.herman.christina.gcucreditunion.Checking;
import edu.gcu.bootcamp.java.herman.christina.gcucreditunion.Customer;
import edu.gcu.bootcamp.java.herman.christina.gcucreditunion.Loan;
import edu.gcu.bootcamp.java.herman.christina.gcucreditunion.Saving;

public class BankInfo {
	 
	static Scanner sc = new Scanner(System.in);
	BankDemo bank = new BankDemo("GCU Credit Union");
	Customer customer = new Customer("Christina", "Herman");
	Checking check = new Checking(customer, 2500.00, "991773");
	Saving save = new Saving(customer, 5000.00, "191923");
	Loan loan =new Loan(customer, 10000.00, "12312314");

	SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
	Date now = new Date();
	String currentDay = day.format(now);
	/**
	 * This method is package private and cannot be accessed outside the package
	 * @param checking
	 * @param saving
	 * @param loan
	 */
	
	
	void displayMenu(Checking checking, Saving saving, Loan loan) { 
		
		int option;

		
		do {
		System.out.println("==================================="); 
		System.out.println("\tMAIN MENU FOR "+ customer.getFirstName());
		System.out.println("     "+ bank.getName().toUpperCase()); 
		System.out.println("==================================="); 
		System.out.println("\tPick an option: "); 
		System.out.println("---------------------");
		System.out.println(" 1: : Deposit to Checking");
		System.out.println(" 2: : Deposit to Savings");
		System.out.println(" 3: : Write a Check");
		System.out.println(" 4: : Withdraw from Savings");
		System.out.println(" 5: : Deposit to Loan");
		System.out.println(" 6: : Get balance");
		System.out.println(" 7: : Close month");
		
		System.out.println("---------------------");
		System.out.println(" 9: : Exit");
		option = sc.nextInt(); 
		this.actionMenu(option,checking, saving, loan);
		
		} while (option != 9); }
		
		private void actionMenu(int option, Checking checking, Saving save, Loan loan) {
			
			switch (option) {
			case 1: 
				displayDepositChecking(checking);
				break; 
			case 2: 
				
				displayDepositSavings(save);
				break;
			case 3: 
				displayWIthdrawChecking(checking);
				break;
			case 4: 
				displayWithdrawSavings(save);
				break;
			case 5: 
				displayDepsitLoan(loan);
				break;
			case 6: 
				displayBalanceScreen(checking, save, loan);
				break; 
			case 7: 
				doEndOfMonth(checking, save, loan);
				
				break;
			 
			case 9: 
				displayExitScreen();
				break; 
				
			}	
		}
		
		
		private void doEndOfMonth(Checking check, Saving save, Loan loan) {
			
			loan.loanNotPaid();
			save.doEndOfMonth();
			check.displayTransactions();
			loan.displayTransactions();
			save.displayTransactions();
			
			check.clearTransactions();
			loan.clearTransactions();
			save.clearTransactions();
			
		}
		
		
		private void displayExitScreen() {
				System.out.println("You have EXITED the menu");
		}
		
		private void displayBalanceScreen(Checking checking, Saving saving, Loan loan) {
			
			System.out.printf("The Accounts for %s %s.\n"
					+ "Your Checking (%s) blance is $%.2f! On %s. "
					+ "\nYour Saving (%s) balance is $%.2f! On %s. \n"
					+ "Your Loan (%s) balance is $%.2f! On %s.\n", customer.getFirstName(), customer.getLastName() , checking.getAccount(), checking.getBalance(), currentDay, 
					saving.getAccount(), saving.getBalance(), currentDay, loan.getAccount(), loan.getBalance(), currentDay);
			
		}

		private void displayWithdrawSavings(Saving saving) {
			System.out.println("Enter an amount");
			double amount = sc.nextDouble();
			System.out.printf("WITHDRAW FROM SAVINGS (%s) \nYour new Savings balance is $%.2f!"
					+ "\nYou will have a $%.2f service fee if balance is below $%.2f at the end of the month."
					+ "\nHow much to withdraw : $%.2f. On %s.\n", saving.getAccount(), saving.getBalance(), saving.getServiceFee(),
					saving.getMinimumBalance(), saving.doWithdraw(amount), currentDay);
		}

		private void displayWIthdrawChecking(Checking checking) {	
			System.out.printf("WITHDRAW FROM CHECKING (%s) \nYour Checking balance is $%.2f!"
					+ "\nYou will have a $%.2f overdarft fee if check amout is greater than the balance."
					+ "\nHow much to withdraw : $%.2f. On %s.\n", checking.getAccount(),checking.getBalance(), 
					checking.getOverDraft(), checking.doWithdraw(), currentDay);
			
		}
		
		
		private void displayDepositSavings(Saving saving) {
			double value = saving.doDeposit();
			System.out.printf("DEPOSIT INTO Savings (%s)\nYour Savings balance is $%.2f!"
					+ "\nhow much to deposit : $%.2f. On %s.\n", saving.getAccount(), saving.getBalance(), 
					value, currentDay);
		}
		
		private void displayDepositChecking(Checking checking) {
			double value = checking.doDeposit();
			System.out.printf("DEPOSIT INTO checking (%s)\nYour Checking balance is $%.2f!"
					+ "\nhow much to deposit : $%.2f. On %s.\n",checking.getAccount(), checking.getBalance(),
					value, currentDay);
		}
		private void displayDepsitLoan(Loan loan) {
			System.out.println("Enter an amount");
			double amount = sc.nextDouble();
			loan.doDeposit(amount);
			System.out.printf("DEPSOIT INTO YOUR LOAN ACCOUNT (%s) \nYour loan balance is $%.2f.\n"
					+ "How much to deposit : $%.2f. On %s.\n", loan.getAccount(), loan.getBalance(),
					amount, currentDay);
			
		}
		
		
}

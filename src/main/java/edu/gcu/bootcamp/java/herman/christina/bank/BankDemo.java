package edu.gcu.bootcamp.java.herman.christina.bank;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import edu.gcu.bootcamp.java.herman.christina.gcucreditunion.Checking;
import edu.gcu.bootcamp.java.herman.christina.gcucreditunion.Saving;

public class BankDemo {
	
	static Scanner sc = new Scanner(System.in);
	 
	private String name; 

	SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
	Date now = new Date();
	String currentDay = day.format(now);
	
	/**
	 * get the name
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * set the name 
	 * @param name
	 */
	public void setName(String name) {
		this.name= name; 
	}
	/**
	 * print out the methods and interact with the portal
	 * @param args
	 */
	public static void main(String[] args) {
	Checking check = new Checking(5000.00, "991773");
	BankDemo bank = new BankDemo("GCU Credit Union");
	Saving save = new Saving(5000., "191923");
	
	bank.setName("GCU Credit Union");
	save.setAnnualInterestRate(.06);
	save.setMinimumBalance(200.00);
	save.setServiceFee(25.00);
	save.setAccount("191923");
	save.setBalance(5000);
	check.setAccount("991773");
	check.setBalance(5000.00);
	check.setOverDraft(45.00);
	
	bank.displayMenu(check, save);
	
		
	}
	
	private void displayMenu(Checking checking, Saving saving) { 
		
	int option;

	
	do {
	System.out.println("==================================="); 
	System.out.println("\tMAIN MENU");
	System.out.println("     "+ this.name.toUpperCase()); 
	System.out.println("==================================="); 
	System.out.println("\tPick an option: "); 
	System.out.println("---------------------");
	System.out.println(" 1: : Deposit to Checking");
	System.out.println(" 2: : Deposit to Savings");
	System.out.println(" 3: : Write a Check");
	System.out.println(" 4: : Withdraw from Savings");
	System.out.println(" 5: : Get balance");
	System.out.println(" 6: : Close month"); 
	System.out.println("---------------------");
	System.out.println(" 9: : Exit");
	option = sc.nextInt(); 
	this.actionMenu(option,checking, saving);
	
	} while (option != 9); }
	
	private void actionMenu(int option, Checking checking, Saving save) {
		
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
			displayBalanceScreen(checking, save);
			break; 
		case 6: 
			doEndOfMonth(checking, save);
			break;
		case 9: 
			displayExitScreen();
			break; 
			
		}	
	}
	
	
	private void doEndOfMonth(Checking checking, Saving save) {
		
		if(save.getMinimumBalance()> save.getBalance()) {
			double newBalance = save.getBalance()+ save.getServiceFee();
			save.setBalance(newBalance); 
		System.out.println("Calculate end of month items.\nYour account is below the minimum"
				+ "blalance of " + save.getMinimumBalance() + ".\nYou are being charged a service fee of "
				+ save.getServiceFee());
		}
		else {		
			double newInterestRate= save.getAnnualInterestRate()/12;
			save.setAnnualInterestRate(newInterestRate);
			double balanceWithInterest = (save.getBalance() * save.getAnnualInterestRate()) + save.getBalance();
			double interestRate = save.getBalance()* save.getAnnualInterestRate();
			save.setAnnualInterestRate(interestRate);
			save.setBalance(balanceWithInterest);
				
					System.out.printf("Calculate end of month items.\n"
					+ "You earned $%.2f of interest on your savings account.\n", save.getAnnualInterestRate() );
		}
	}
	
	
	private void displayExitScreen() {
			System.out.println("You have EXITED the menu");
	}
	
	private void displayBalanceScreen(Checking checking, Saving saving) {
		
		System.out.printf("Your Checking (%s) blance is $%.2f! On %s "
				+ "\nYour Saving (%s) balance is $%.2f! On %s \n", checking.getAccount(), checking.getBalance(), currentDay, 
				saving.getAccount(), saving.getBalance(), currentDay);
		
	}

	private void displayWithdrawSavings(Saving saving) {
		System.out.printf("WITHDRAW FROM SAVINGS (%s) \nYour new Savings balance is $%.2f!"
				+ "\nYou will have a $%.2f service fee if balance is below $%.2f at the end of the month."
				+ "\nHow much to withdraw : $%.2f. On %s.\n", saving.getAccount(), saving.getBalance(), saving.getServiceFee(),
				saving.getMinimumBalance(), saving.doWithdraw(), currentDay);
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
				+ "\nhow much to deposit : $%.2f. On %s.\n",checking.getAccount(), checking.getBalance(), value, currentDay);
	}
	
	/**
	 * Constructor for the BankDemo class
	 * @param name
	 */
	public BankDemo(String name) {}





}

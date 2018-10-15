package edu.gcu.bootcamp.java.herman.christina.bank;



import edu.gcu.bootcamp.java.herman.christina.gcucreditunion.Checking;
import edu.gcu.bootcamp.java.herman.christina.gcucreditunion.Customer;
import edu.gcu.bootcamp.java.herman.christina.gcucreditunion.Loan;
import edu.gcu.bootcamp.java.herman.christina.gcucreditunion.Saving;

public class BankDemo {
	

	 
	private String name; 


	
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
	BankInfo bankInfo = new BankInfo();
	Customer customer = new Customer("Christina", "Herman");
	Checking check = new Checking(customer, 2500.00, "991773");
	Saving save = new Saving(customer, 5000.00, "191923");
	Loan loan =new Loan(customer, 10000.00, "12312314");

	loan.setInterestRate(.09);
	loan.setLateFee(25.00);
	
	save.setAnnualInterestRate(.03);
	double newInterestRate= save.getAnnualInterestRate()/12;
	save.setAnnualInterestRate(newInterestRate);
	
	save.setMinimumBalance(500.00);
	save.setServiceFee(25.00);
	check.setOverDraft(45.00);
	
	bankInfo.displayMenu(check, save, loan );
	
		
	}
	
	
	
	/**
	 * Constructor for the BankDemo class
	 * @param name
	 */
	public BankDemo(String name) {
		this.name = name; 
	}





}

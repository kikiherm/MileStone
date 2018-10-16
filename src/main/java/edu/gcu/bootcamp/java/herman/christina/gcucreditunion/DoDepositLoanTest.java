package edu.gcu.bootcamp.java.herman.christina.gcucreditunion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DoDepositLoanTest {
	int expectedResult; 
	int actualResult; 
	private double amount = 400; 
	Customer customer = new Customer("Christina", "Herman");
	Loan loan = new Loan(customer, 5000, "12312314");
	Saving save = new Saving(customer, 5000.00, "191923");
	
	@Test
	public void testDoDeposit() {
		int result = (int) (loan.getBalance() - amount); 
		
		expectedResult = result; 
		actualResult = (int)loan.doDeposit(amount); 
		
		assertEquals(expectedResult, actualResult);
		
	}
	@Test
	public void testDoWithdraw() {
		int result = (int) (save.getBalance() - amount); 
		expectedResult = result; 
		actualResult = (int) save.doWithdraw(amount);
		assertEquals(expectedResult, actualResult);
		
	}
	
}

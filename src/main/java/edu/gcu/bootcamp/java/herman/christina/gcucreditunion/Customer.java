package edu.gcu.bootcamp.java.herman.christina.gcucreditunion;

import java.util.Date;

public class Customer {
	
	private String firstName; 
	private String lastName; 
	private Date date;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	} 
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName; 
		this.lastName = lastName; 
		
	}

}

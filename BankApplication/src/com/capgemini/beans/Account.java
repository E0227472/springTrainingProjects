package com.capgemini.beans;

public class Account {
	private int accountNumber;
	private String name;
	private int amount;
	
	public Account(int accountNumber, String name, int amount) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.amount = amount;
	}
	
	public Account() {
		
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}

package com.capgemini.beans;

import java.util.Map;

public class Account {
	private int accountNumber;
	private String name;
	private int amount;
	private Map<String, Account>accounts;
	
	public Account(int accountNumber, String name, int amount) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.amount = amount;
	}
	
	public Account(Map<String,Account> accounts) {
		this.accounts = accounts;
	}
	
	public Account() {
		
	}
	
	public Map<String, Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Map<String, Account> accounts) {
		this.accounts = accounts;
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

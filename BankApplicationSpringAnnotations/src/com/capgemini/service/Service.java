package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;

public interface Service {

	public Account createAccount(int accountNumber, String name, int amount)
	throws InsufficientOpeningBalanceException;
	
	public Account depositAmount(int accountNumber, int amount)
	throws InvalidAccountNumberException;
	
	public Account withdrawAmount(int accountNumber, int amount)
	throws InvalidAccountNumberException, InsufficientBalanceException;
	
	public Account fundTransfer(int fromAccount,int amount)
	throws InvalidAccountNumberException, InsufficientBalanceException;

}

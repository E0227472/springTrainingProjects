package com.capgemini.repository;

import java.util.Map;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InvalidAccountNumberException;

public interface Repository {

	public Account save(Account a);
	
	public Account findAccount(Integer accountNumber)
	throws InvalidAccountNumberException;
	
	
	
}

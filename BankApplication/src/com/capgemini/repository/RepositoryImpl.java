package com.capgemini.repository;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InvalidAccountNumberException;

public class RepositoryImpl implements Repository {

	private Map<Integer,Account> data;
	
	 public RepositoryImpl() {
		this.data = new HashMap<Integer, Account>();
	}
	 
	 public RepositoryImpl(Map<Integer,Account> data) {
			this.data = data;
		}
	@Override
	public Account save(Account a) {
		// TODO Auto-generated method stub
		data.put(a.getAccountNumber(), a);
		return a;
	}

	@Override
	public Account findAccount(Integer accountNumber) throws InvalidAccountNumberException {
		// TODO Auto-generated method stub
		return data.get(accountNumber);
	}
	
}

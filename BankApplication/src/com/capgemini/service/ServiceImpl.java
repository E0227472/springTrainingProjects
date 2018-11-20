package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repository.Repository;
import com.capgemini.repository.RepositoryImpl;

public class ServiceImpl implements Service {

	private Repository r;

	public ServiceImpl() {
		r = new RepositoryImpl();
	}

	public ServiceImpl(Repository r) {
		this.r = r;
	}
	public Account createAccount(int accountNumber, String name, int amount)
			throws InsufficientOpeningBalanceException  {
		Account a = new Account(accountNumber, name, amount);

		if(amount < 500) {
			throw new InsufficientOpeningBalanceException("Please deposit at least $500");
		}
		Account a1 = r.save(a);
		return a1;
	}

	public Account depositAmount(int accountNumber, int amount)
			throws InvalidAccountNumberException {
		// get account object based on accountNumber
		Account accountDeposit = r.findAccount(accountNumber);
		if(accountDeposit == null) {
			throw new InvalidAccountNumberException("Account does not exist");
		}
		// set new balance for accountNumber
		accountDeposit.setAmount(amount + accountDeposit.getAmount());
		
		return accountDeposit;
	}

	public Account withdrawAmount(int accountNumber, int amount)
			throws InvalidAccountNumberException, InsufficientBalanceException {
		Account accountWithdraw = r.findAccount(accountNumber);
		if(accountWithdraw == null) {
			throw new InvalidAccountNumberException("Account does not exist ");
		}
		
		int balance  = accountWithdraw.getAmount() - amount;
		
		if(balance <0) {
			throw new InsufficientBalanceException("Insufficient balance in account");
		} else  {
			accountWithdraw.setAmount(accountWithdraw.getAmount() - amount);
		}
		return accountWithdraw;	
	}

	public Account fundTransfer(int fromAccount, int amount)
			throws InvalidAccountNumberException, InsufficientBalanceException {
		// getting account number for account that is transferring from
		Account fromAccountTransfer = r.findAccount(fromAccount);
		if(fromAccountTransfer ==  null) {
			throw new InvalidAccountNumberException("Account does not exist");
		}
		
		int balance = fromAccountTransfer.getAmount() - amount;
		
		if(balance <0) {
			throw new InsufficientBalanceException("Your balance is too low");
		} else  {
		// set new balance of the person transferring amount from
		fromAccountTransfer.setAmount(fromAccountTransfer.getAmount() - amount);
		}
		return fromAccountTransfer;
	}
}

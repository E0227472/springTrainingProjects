package com.capgemini.view;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.service.ServiceImpl;

public class MainApp {
	private static ServiceImpl s = new ServiceImpl();


	public static void main(String[] args) {
		Account a = null;
		Account a1 = null;
		Account a2 = null;
		try {
			a = s.createAccount(1234,"name1", 1000);
			a1 = s.createAccount(2345, "name2", 600);
			a2 = s.createAccount(3456, "name3", 7000);
		} catch (InsufficientOpeningBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// depositAmount Test 
		try {
			Account aDeposit = s.depositAmount(2345, 200);
			if(aDeposit != null) {
				System.out.println(aDeposit.getAccountNumber());
				System.out.println(aDeposit.getAmount());
				System.out.println(aDeposit.getName());
			}
		} catch (InvalidAccountNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// Fundtransfer test 
		
		try {
			Account aTransfer = s.fundTransfer(3456,20);
			if(aTransfer != null) {
				System.out.println(aTransfer.getAccountNumber());
				System.out.println(aTransfer.getAmount());
				System.out.println(aTransfer.getName());
			}
		} catch (InvalidAccountNumberException | InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Withdraw test
		
		try {
			Account aWithdraw = s.withdrawAmount(1234, 30);
			if(aWithdraw != null) {
				System.out.println(aWithdraw.getAccountNumber());
				System.out.println(aWithdraw.getAmount());
				System.out.println(aWithdraw.getName());
			}
		} catch (InvalidAccountNumberException | InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

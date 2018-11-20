package com.capgemini.view;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.beans.Account;
import com.capgemini.configuration.BeanDataConfig;
import com.capgemini.configuration.BeanServiceConfig;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.service.ServiceImpl;

public class MainApp {
	// private static ServiceImpl s = new ServiceImpl();

	public static void main(String[] args) {
		Account b = null;
		Account b1 = null;
		Account b2 = null;
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanDataConfig.class);

		Account accounts = ctx.getBean(Account.class);

		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(BeanServiceConfig.class);

		ServiceImpl s = ctx2.getBean(ServiceImpl.class);
		Account a = accounts.getAccounts().get("1");
		Account a1 = accounts.getAccounts().get("2");
		Account a2 = accounts.getAccounts().get("3");

		try {
			b = s.createAccount(a.getAccountNumber(), a.getName(), a.getAmount());
			b1 = s.createAccount(a1.getAccountNumber(), a1.getName(), a1.getAmount());
			b2 = s.createAccount(a2.getAccountNumber(), a2.getName(), a2.getAmount());
		} catch (InsufficientOpeningBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// depositAmount Test
		try {
			Account aDeposit = s.depositAmount(b.getAccountNumber(), 200);
			if (aDeposit != null) {
				System.out.println(aDeposit.getAccountNumber());
				System.out.println(aDeposit.getAmount());
				System.out.println(aDeposit.getName());
			}
		} catch (InvalidAccountNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Fundtransfer test

//		try {
//			Account aTransfer = s.fundTransfer(b1.getAccountNumber(),20);
//			if(aTransfer != null) {
//				System.out.println(aTransfer.getAccountNumber());
//				System.out.println(aTransfer.getAmount());
//				System.out.println(aTransfer.getName());
//			}
//		} catch (InvalidAccountNumberException | InsufficientBalanceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// Withdraw test

//		try {
//			Account aWithdraw = s.withdrawAmount(1234, 30);
//			if(aWithdraw != null) {
//				System.out.println(aWithdraw.getAccountNumber());
//				System.out.println(aWithdraw.getAmount());
//				System.out.println(aWithdraw.getName());
//			}
//		} catch (InvalidAccountNumberException | InsufficientBalanceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}

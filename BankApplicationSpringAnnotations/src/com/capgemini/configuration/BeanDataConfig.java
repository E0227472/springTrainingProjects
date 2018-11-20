package com.capgemini.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.capgemini.beans.Account;

@Configuration
public class BeanDataConfig {
	@Bean
	public Account accounts() {
		Map<String, Account> accts = new HashMap<String, Account>();
		
		Account a1 = new Account(1234, "name1", 1000);
		Account a2 = new Account(2345, "name2", 2000);
		Account a3 = new Account(3456, "name3", 3000);
		
		Account a4 = new Account();
		
		accts.put("1", a1);
		accts.put("2", a2);
		accts.put("3", a3);
		a4.setAccounts(accts);
		return a4;
	}

}

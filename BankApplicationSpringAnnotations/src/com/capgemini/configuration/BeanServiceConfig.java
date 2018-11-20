package com.capgemini.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.capgemini.beans.Account;

@Configuration
public class BeanServiceConfig {
	
	@Bean
	@Qualifier("mapAccounts")
	public Map<Integer, Account> accts (){
		return new HashMap<Integer, Account>();
	}

}

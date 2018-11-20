package com.capgemini.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.capgemini.service.Service;
import com.capgemini.service.ServiceImpl;

@Configuration
public class BeanServiceConfig {
	@Bean
	public Service service() {
		
		ServiceImpl serviceimpl = new ServiceImpl();
		
		return serviceimpl;
	}

}

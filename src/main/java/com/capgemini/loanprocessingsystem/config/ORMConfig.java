package com.capgemini.loanprocessingsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class ORMConfig {
	@Bean 
	public LocalEntityManagerFactoryBean getLocalEntityManagerFactory() {
	LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
	bean.setPersistenceUnitName("loansystem-unit");
	return bean;

}

}

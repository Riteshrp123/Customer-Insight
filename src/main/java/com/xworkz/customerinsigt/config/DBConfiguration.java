package com.xworkz.customerinsigt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class DBConfiguration {
	
	public DBConfiguration() {
		System.out.println("Create" + this.getClass().getSimpleName());
	}
	
	@Bean
	public LocalEntityManagerFactoryBean getEntityManager() {
		System.out.println("Create Bean of Entity Manager");
		LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
			emfb.setPersistenceUnitName("customerInsight-details");
			return emfb;	
		}
	}
	

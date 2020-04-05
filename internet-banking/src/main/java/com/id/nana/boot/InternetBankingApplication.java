package com.id.nana.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

@SpringBootApplication
public class InternetBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternetBankingApplication.class, args);
	}

	/* 
	 * Pagenable engine
	 * 
	 * */
	
	@Bean
	public SpringDataDialect springDataDialect() {
		return new SpringDataDialect();
	}
}

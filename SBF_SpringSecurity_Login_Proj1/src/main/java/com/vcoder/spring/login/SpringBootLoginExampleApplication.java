package com.vcoder.spring.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SpringBootLoginExampleApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoginExampleApplication.class, args);
	}

}

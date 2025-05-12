package com.example.yede;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.lifecycle.ABB_Bean;
import com.example.lifecycle.SetterDependency;
import com.example.lifecycle.SetterDependency2;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Configuration
@ComponentScan("com.example.lifecycle")
public class MppConfig {

	static {
		System.out.println("### MppConfig Class Loaded");
	}

	public MppConfig() {
		System.out.println("### MppConfig instantiated");
	}

	@Bean
	public SetterDependency setterDependency() {
		System.out.println("### AppConfig.setterDependency() called");
		return new SetterDependency();
	}

	@Bean
	public SetterDependency2 setterDependency2() {
		System.out.println("### AppConfig.setterDependency2() called");
		return new SetterDependency2();
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("-- ### MppConfig :: @PostConstruct called");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("-- ### MppConfig :: @PreDestroy called");
	}
}

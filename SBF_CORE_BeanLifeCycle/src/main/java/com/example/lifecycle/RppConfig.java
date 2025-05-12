package com.example.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.lifecycle.ABB_Bean;
import com.example.lifecycle.SetterDependency;
import com.example.lifecycle.SetterDependency2;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Configuration
@ComponentScan("com.example.yede")
public class RppConfig {

	static {
		System.out.println("### RppConfig Class Loaded");
	}

	public RppConfig() {
		System.out.println("### RppConfig instantiated");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("-- ### RppConfig :: @PostConstruct called");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("-- ### RppConfig :: @PreDestroy called");
	}
}

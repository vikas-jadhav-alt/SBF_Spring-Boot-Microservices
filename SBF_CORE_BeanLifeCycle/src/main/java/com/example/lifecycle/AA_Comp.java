package com.example.lifecycle;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class AA_Comp {

	static {
		System.out.println("-- AA_Comp Class Loaded");
	}

	public AA_Comp() {
		System.out.println("-- AA_Comp instantiated");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("-- AA_Comp :: @PostConstruct called");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("-- AA_Comp :: @PreDestroy called");
	}
}


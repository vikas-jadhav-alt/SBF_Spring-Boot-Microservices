package com.example.lifecycle;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Lazy
public class AC_LazyComp2 {

	static {
		System.out.println("-- AC_LazyComp2 Class Loaded");
	}

	public AC_LazyComp2() {
		System.out.println("-- AC_LazyComp2 instantiated");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("-- AC_LazyComp2 :: @PostConstruct called");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("-- AC_LazyComp2 :: @PreDestroy called");
	}

}


package com.example.lifecycle;

import org.springframework.stereotype.Component;

@Component
public class FieldDependency2 {

	static {
		System.out.println("-- FieldDependency2 Class Loaded");
	}

	public FieldDependency2() {
		System.out.println("-- FieldDependency2 instantiated");
	}
}


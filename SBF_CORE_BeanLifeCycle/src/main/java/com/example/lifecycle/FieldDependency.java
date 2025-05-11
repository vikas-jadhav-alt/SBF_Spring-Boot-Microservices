package com.example.lifecycle;

import org.springframework.stereotype.Component;

@Component
public class FieldDependency {

	static {
		System.out.println("-- FieldDependency Class Loaded");
	}

	public FieldDependency() {
		System.out.println("-- FieldDependency instantiated");
	}
}


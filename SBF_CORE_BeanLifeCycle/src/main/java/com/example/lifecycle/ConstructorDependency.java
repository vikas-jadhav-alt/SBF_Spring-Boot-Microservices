package com.example.lifecycle;

public class ConstructorDependency {

	static {
		System.out.println("--| ConstructorDependency Class Loaded");
	}
	public ConstructorDependency() {
		System.out.println("--| ConstructorDependency instantiated");
	}
}

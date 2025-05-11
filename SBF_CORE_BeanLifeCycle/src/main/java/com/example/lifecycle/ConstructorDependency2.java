package com.example.lifecycle;

public class ConstructorDependency2 {

	static {
		System.out.println("--| ConstructorDependency2 Class Loaded");
	}
	public ConstructorDependency2() {
		System.out.println("--| ConstructorDependency2 instantiated");
	}
}

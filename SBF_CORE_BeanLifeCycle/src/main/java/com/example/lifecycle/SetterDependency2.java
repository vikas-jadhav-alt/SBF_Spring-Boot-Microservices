package com.example.lifecycle;

public class SetterDependency2 {

	static {
		System.out.println("--# SetterDependency2 Class Loaded");
	}

	public SetterDependency2() {
		System.out.println("--# SetterDependency2 instantiated");
	}
}

package com.example.lifecycle;

public class SetterDependency3 {

	static {
		System.out.println("--# SetterDependency3 Class Loaded");
	}

	public SetterDependency3() {
		System.out.println("--# SetterDependency3 instantiated");
	}

}

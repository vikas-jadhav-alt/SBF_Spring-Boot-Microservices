package com.example.lifecycle;

public class SetterDependency {

	static {
		System.out.println("--# SetterDependency Class Loaded");
	}

	public SetterDependency() {
		System.out.println("--# SetterDependency instantiated");
	}
}

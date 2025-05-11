package com.example.lifecycle;

import org.springframework.stereotype.Component;

@Component
public class BD_Component {

	static {
		System.out.println("-- BD_Component Class Loaded");
	}

	public BD_Component() {
		System.out.println("-- BD_Component instantiated");
	}
}


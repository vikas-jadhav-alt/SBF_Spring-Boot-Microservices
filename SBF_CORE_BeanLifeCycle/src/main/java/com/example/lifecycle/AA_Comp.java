package com.example.lifecycle;

import org.springframework.stereotype.Component;

@Component
public class AA_Comp {

	static {
		System.out.println("-- AA_Comp Class Loaded");
	}

	public AA_Comp() {
		System.out.println("-- AA_Comp instantiated");
	}
}


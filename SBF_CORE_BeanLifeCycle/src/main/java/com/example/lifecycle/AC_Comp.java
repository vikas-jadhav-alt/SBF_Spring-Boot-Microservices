package com.example.lifecycle;

import org.springframework.stereotype.Component;

@Component
public class AC_Comp {

	static {
		System.out.println("-- AC_Comp Class Loaded");
	}

	public AC_Comp() {
		System.out.println("-- AC_Comp instantiated");
	}
}


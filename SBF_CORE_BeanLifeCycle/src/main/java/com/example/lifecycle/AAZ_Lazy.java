package com.example.lifecycle;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class AAZ_Lazy {

	static {
		System.out.println("-- AAZ_Lazy Class Loaded");
	}

	public AAZ_Lazy() {
		System.out.println("-- AAZ_Lazy instantiated");
	}
}


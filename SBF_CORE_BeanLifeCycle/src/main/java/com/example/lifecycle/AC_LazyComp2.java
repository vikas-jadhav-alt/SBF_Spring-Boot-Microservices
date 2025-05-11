package com.example.lifecycle;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class AC_LazyComp2 {

	static {
		System.out.println("-- AC_LazyComp2 Class Loaded");
	}

	public AC_LazyComp2() {
		System.out.println("-- AC_LazyComp2 instantiated");
	}
}


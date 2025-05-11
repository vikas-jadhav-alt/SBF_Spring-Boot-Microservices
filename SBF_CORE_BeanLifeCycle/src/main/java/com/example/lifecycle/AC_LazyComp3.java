package com.example.lifecycle;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class AC_LazyComp3 {

	static {
		System.out.println("-- AC_LazyComp3 Class Loaded");
	}

	public AC_LazyComp3() {
		System.out.println("-- AC_LazyComp3 instantiated");
	}

}

package com.example.lifecycle;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class AC_LazyComp {

	private int check = 5;

	@Override
	public String toString() {
		return "AC_LazyComp [check=" + check + "]";
	}

	static {
		System.out.println("-- AC_LazyComp Class Loaded");
	}

	public AC_LazyComp() {
		System.out.println("-- AC_LazyComp instantiated");
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}
}


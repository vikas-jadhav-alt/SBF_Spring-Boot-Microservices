package org.projA1_proxy_desing_pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ITEmployee implements IEmployee {

	private double salary;

	@Override
	public double giveHike(double ammount) {
		this.salary = this.salary + ammount;
		return this.salary;
	}

	@Override
	public double payCut(double ammount) {
		this.salary = this.salary - ammount;
		return this.salary;

	}

	@Override
	public double getSalary() {
		return salary;
	}

	@Override
	public void setSalary(double salary) {
		this.salary = salary;
	}


}

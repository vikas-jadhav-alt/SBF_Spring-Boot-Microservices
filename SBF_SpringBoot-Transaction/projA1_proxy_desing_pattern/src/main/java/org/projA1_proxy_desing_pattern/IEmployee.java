package org.projA1_proxy_desing_pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public interface IEmployee {

	public double giveHike(double ammout);

	public double payCut(double amount);

	public double getSalary();

	public void setSalary(double salary);

	public static IEmployee createProxy(InvocationHandler inc) {

		IEmployee newProxyInstance = (IEmployee) Proxy.newProxyInstance(IEmployee.class.getClassLoader(),
				new Class[] { IEmployee.class }, inc);
		return newProxyInstance;
	}

}

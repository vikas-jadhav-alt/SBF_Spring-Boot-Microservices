package org.projA1_proxy_desing_pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ITEmployeeInvocationHandler implements InvocationHandler {

	private IEmployee targetObj;

	public ITEmployeeInvocationHandler(IEmployee targetObj) {
		super();
		this.targetObj = targetObj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("Invocation Handler Start");
		if (method.getName().equals("giveHike")) {
			double hike = (double) args[0];

			if (hike < 0) {
				throw new RuntimeException("Hike Can Not Be Negative");
			}
		}

		Object returnValue = method.invoke(targetObj, args);

		System.out.println("Invocation Handler End");

		return returnValue;
	}

}

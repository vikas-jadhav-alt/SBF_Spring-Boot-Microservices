package com.projB1_txProp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

public class ConnectionInvocationHandler implements InvocationHandler {

	private Connection targetObj;

	public ConnectionInvocationHandler(Connection targetObj) {
		super();
		this.targetObj = targetObj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		if (method.getName().contains("commit") || method.getName().contains("rollback")
				|| method.getName().contains("close"))
			System.out.println("--> connection trace: " + method.toGenericString());

		Object returnValue = method.invoke(targetObj, args);

		return returnValue;
	}

}

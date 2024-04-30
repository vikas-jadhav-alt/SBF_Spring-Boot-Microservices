package com.projB1_txProp.aop;

import java.lang.reflect.Proxy;
import java.sql.Connection;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.mysql.cj.jdbc.ConnectionImpl;
import com.projB1_txProp.proxy.ConnectionInvocationHandler;

@Component
@Aspect
public class DataSourceAspect {

	@Pointcut("target(javax.sql.DataSource)")
	public void logDataSource() {

	}

	@Around("logDataSource()")
	public Object logAroundMethodCall(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("*** DataSource Method: " + pjp.getSignature().getName());

		Object returnValue = pjp.proceed(); // getConnection()

		if (returnValue instanceof Connection) {
			Connection con = (Connection) Proxy.newProxyInstance(ConnectionImpl.class.getClassLoader(),
					new Class[] { Connection.class }, new ConnectionInvocationHandler((Connection) returnValue));

			System.out.println("Connection Def: " + con);
			return con;
			// Here instead of directly returning the COnnection Object: we sent its Proxy
			// Object instead
		}
		return returnValue;
	}
}

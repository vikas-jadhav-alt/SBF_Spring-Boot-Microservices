package com.projB1_txProp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CallTrakerAspect {

	@Pointcut("within(com..service.*) || within(com..repo.*)")
	public void logMethodPointCut() {

	}

//	@Before("logMethodPointCut()")
//	public void logBefoerMethodCall() {
//		// ...
//	}
//
//	@After("logMethodPointCut()")
//	public void logAfterMethodCall() {
//		// ...
//	}

//	@Around = @Befoer AND @After

	@Around("logMethodPointCut()")
	public Object logAroundMethodCall(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("method start : " + pjp.getSignature().getName());

		Object returnValue = pjp.proceed();

		// When return type is ‘void’: Object returnValue = null;
//		System.out.println("---> Returned Val: " + returnValue);

		System.out.println("method completed : " + pjp.getSignature().getName());

		return returnValue;
	}
}

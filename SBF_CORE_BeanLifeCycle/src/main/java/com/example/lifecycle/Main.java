package com.example.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		System.out.println("---- Starting Spring Context ----");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("---- AnnotationConfigApplicationContext Configured ----");

		context.getBean(AD_LifeCycleDemoBean.class);

		AB_Comp abc = (AB_Comp) context.getBean("AB_Comp");
		System.out.println("==> Fetching Lazy AC_Lazy_Comp from AB_Comp");
		AC_LazyComp aclc = abc.getaC_LazyComp();
		System.out.println("===>=> calling AC_LazyComp.check");
		System.out.println("Check Value is: " + aclc.getCheck());

		System.out.println("==> GetBean of AC_Lazy_Comp2");
		context.getBean("AC_LazyComp2");

		System.out.println("==== Shutting Down Spring Context ====");
		context.close();
	}
}

package org.projA1_proxy_desing_pattern;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		ITEmployee i = new ITEmployee();
		i.setSalary(5000);

		IEmployee proxy = IEmployee.createProxy(new ITEmployeeInvocationHandler(i));

		System.out.println(proxy.giveHike(2000));

		System.out.println(proxy.giveHike(-8000));

	}
}

/** Output: **/

//Hello World!
//Invocation Handler Start
//Invocation Handler End
//7000.0
//Invocation Handler Start
//Exception in thread "main" java.lang.RuntimeException: Hike Can Not Be Negative
//	at org.projA1_proxy_desing_pattern.ITEmployeeInvocationHandler.invoke(ITEmployeeInvocationHandler.java:23)
//	at jdk.proxy1/jdk.proxy1.$Proxy0.giveHike(Unknown Source)
//	at org.projA1_proxy_desing_pattern.App.main(App.java:18)

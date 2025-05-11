package com.example.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.lifecycle")
public class AppConfig {

	static {
		System.out.println("### AppConfig Class Loaded");
	}

	public AppConfig() {
		System.out.println("### AppConfig instantiated");
	}

	@Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
	public ABB_Bean aBB_Bean() {
		System.out.println("### AppConfig.aBB_Bean() called");
		return new ABB_Bean();
	}

	@Bean
	public SetterDependency setterDependency() {
		System.out.println("### AppConfig.setterDependency() called");
		return new SetterDependency();
	}

	@Bean
	public SetterDependency2 setterDependency2() {
		System.out.println("### AppConfig.setterDependency2() called");
		return new SetterDependency2();
	}

	@Bean
	public SetterDependency3 setterDependency3() {
		System.out.println("### AppConfig.setterDependency3() called");
		return new SetterDependency3();
	}

	@Bean
	public ConstructorDependency constructorDependency() {
		System.out.println("### AppConfig.constructorDependency() called");
		return new ConstructorDependency();
	}

	@Bean
	public ConstructorDependency2 constructorDependency2() {
		System.out.println("### AppConfig.constructorDependency2() called");
		return new ConstructorDependency2();
	}
}

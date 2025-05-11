package com.example.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


public class ABB_Bean implements InitializingBean, DisposableBean {

	static {
		System.out.println("-- ABB_Bean Class Loaded");
	}

	public ABB_Bean() {
		System.out.println("-- ABB_Bean() instantiated");
	}

	public void initMethod() {
		System.out.println("-- ABB_Bean() custom:initMethod");

	}

	public void destroyMethod() {
		System.out.println("-- ABB_Bean() custom:destroyMethod");

	}

	@Override
	public void destroy() throws Exception {
		System.out.println("-- ABB_Bean() interface:destroy");

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("-- ABB_Bean() interface:afterPropertiesSet");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("-- ABB_Bean() annotation:postConstruct");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("-- ABB_Bean() annotation:preDestroy");
	}
}

package com.example.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyPostProcessor implements BeanPostProcessor {

	static {
		System.out.println("==> MyPostProcessor Class Loaded");
	}

	public MyPostProcessor() {
		System.out.println("==> MyPostProcessor instantiated");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof AD_LifeCycleDemoBean) {
			System.out.println(">> BeanPostProcessor:AD_LifeCycleDemoBean: BEFORE initialization of " + beanName);
		}
		System.out.println(">> BeanPostProcessor:Other: BEFORE initialization of " + beanName);

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof AD_LifeCycleDemoBean) {
			System.out.println(">> BeanPostProcessor:AD_LifeCycleDemoBean: AFTER initialization of " + beanName);
		}
		System.out.println(">> BeanPostProcessor:Other: AFTER initialization of " + beanName);

		return bean;
	}
}

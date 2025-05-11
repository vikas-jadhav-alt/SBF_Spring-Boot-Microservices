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
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class AB_Comp implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, ApplicationContextAware,
		EnvironmentAware, InitializingBean, DisposableBean {

	static {
		System.out.println("-- AB_Comp Class Loaded");
	}

	private SetterDependency3 setterDependency3;

	@Autowired
	@Lazy
	private AC_LazyComp aC_LazyComp;

	@Autowired
	@Lazy
	private AC_LazyComp3 aC_LazyComp3;

	@Autowired
	private AAZ_Lazy aAZ_Lazy;

	public AC_LazyComp getaC_LazyComp() {
		return aC_LazyComp;
	}

	public void setaC_LazyComp(AC_LazyComp aC_LazyComp) {
		this.aC_LazyComp = aC_LazyComp;
	}

	public AB_Comp() {
		System.out.println("-- AB_Comp() instantiated");
	}


	@Override
	public void setBeanName(String name) {
		System.out.println("3. AB_Comp :: BeanNameAware: setBeanName()");
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("4. AB_Comp :: BeanClassLoaderAware: setBeanClassLoader()");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("5. AB_Comp :: BeanFactoryAware: setBeanFactory()");
	}

	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("6. AB_Comp :: EnvironmentAware: setEnvironment()");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("7. AB_Comp :: ApplicationContextAware: setApplicationContext()");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("8. AB_Comp :: @PostConstruct called");
	}

	@Override
	public void afterPropertiesSet() {
		System.out.println("9. AB_Comp :: InitializingBean: afterPropertiesSet()");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("10. AB_Comp :: @PreDestroy called");
	}

	@Override
	public void destroy() {
		System.out.println("11. AB_Comp :: DisposableBean: destroy()");
	}

	@Autowired
	public void setSetterDependency3(SetterDependency3 setterDependency3) {
		this.setterDependency3 = setterDependency3;
		System.out.println("2. AB_Comp :: Setter: SetterDependency3 injected");
	}
}


package com.example.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AD_LifeCycleDemoBean implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware,
		ApplicationContextAware, EnvironmentAware, InitializingBean, DisposableBean {

	static {
		System.out.println("-- AD_LifeCycleDemoBean Class Loaded");
	}

	private SetterDependency setterDependency;

	private SetterDependency2 setterDependency2;

	@Autowired
	private FieldDependency fieldDependency;

	@Autowired
	private FieldDependency2 fieldDependency2;

//	private final ConstructorDependency constructorDependency;
//	private final ConstructorDependency2 constructorDependency2;

	private  ConstructorDependency constructorDependency;
	private  ConstructorDependency2 constructorDependency2;

	@Autowired
	public AD_LifeCycleDemoBean(ConstructorDependency constructorDependency,
			ConstructorDependency2 constructorDependency2) {
		this.constructorDependency = constructorDependency;
		this.constructorDependency2 = constructorDependency2;
		System.out.println("1. AD_LifeCycleDemoBean::Constructor created");
	}

	public AD_LifeCycleDemoBean() {
		System.out.println("1. AD_LifeCycleDemoBean::Constructor() created");
	}

	@Autowired
	public void setSetterDependency(SetterDependency setterDependency) {
		this.setterDependency = setterDependency;
		System.out.println("2. AD_LifeCycleDemoBean :: Setter: SetterDependency injected");
	}

	@Autowired
	public void setSetterDependency2(SetterDependency2 setterDependency2) {
		this.setterDependency2 = setterDependency2;
		System.out.println("2. AD_LifeCycleDemoBean :: Setter: SetterDependency2 injected");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("3. AD_LifeCycleDemoBean :: BeanNameAware: setBeanName()");
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("4. AD_LifeCycleDemoBean :: BeanClassLoaderAware: setBeanClassLoader()");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("5. AD_LifeCycleDemoBean :: BeanFactoryAware: setBeanFactory()");
	}

	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("6. AD_LifeCycleDemoBean :: EnvironmentAware: setEnvironment()");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("7. AD_LifeCycleDemoBean :: ApplicationContextAware: setApplicationContext()");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("8. AD_LifeCycleDemoBean :: @PostConstruct called");
	}

	@Override
	public void afterPropertiesSet() {
		System.out.println("9. AD_LifeCycleDemoBean :: InitializingBean: afterPropertiesSet()");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("10. AD_LifeCycleDemoBean :: @PreDestroy called");
	}

	@Override
	public void destroy() {
		System.out.println("11. AD_LifeCycleDemoBean :: DisposableBean: destroy()");
	}
}

package com.projB1_txProp;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.projB1_txProp.config.ProductConfig;
import com.projB1_txProp.service.ProductService;


public class App {
	public static void main(String[] args) throws Exception {

		System.out.println("App Main Running...");
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ProductConfig.class);

		context.registerShutdownHook();

		ProductService bean = context.getBean("productService", ProductService.class);
		bean.saveProductInfoServiceMethod();

		context.close();

		System.out.println("App Main Complete...");

	}
}

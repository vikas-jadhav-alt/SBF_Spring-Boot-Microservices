package com.projB1_txIsol;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.projB1_txIsol.config.ProductConfig;
import com.projB1_txIsol.service.ProductService;

public class App {
	public static void main(String[] args) throws Exception {

		System.out.println("App Main Running...");
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ProductConfig.class);

		context.registerShutdownHook();

		ProductService bean = context.getBean("productService", ProductService.class);

		bean.outerMethod();

		context.close();

		System.out.println("App Main Complete...");

	}
}

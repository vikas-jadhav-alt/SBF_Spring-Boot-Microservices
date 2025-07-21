package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.Person;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		System.out.println("##### Starting Main Method");
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("##### Finishing Main Method");
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("----> Welcome To CommandLineRunner <--------");
		Person person = context.getBean(Person.class);
		person.introduction();

	}

//	@Bean
//	Person person() {
//		return new Person();
//	}

}

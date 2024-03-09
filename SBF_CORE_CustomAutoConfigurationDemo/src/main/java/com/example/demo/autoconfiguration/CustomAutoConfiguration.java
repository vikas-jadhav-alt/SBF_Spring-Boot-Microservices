package com.example.demo.autoconfiguration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import com.example.demo.Atom;
import com.example.demo.dao.Person;
import com.example.demo.dao.TestDao;

@AutoConfiguration
@ConditionalOnClass(Atom.class)
//@ConditionalOnBean(TestDao.class)
@ConditionalOnProperty(name = "enable.customAuto", havingValue = "true")
public class CustomAutoConfiguration {

	@Bean
	@ConditionalOnBean(TestDao.class)
//	@ConditionalOnMissingBean(TestDao.class)
	Person person() {
		System.out.println(".....Person Bean Getting Created");
		return new Person();
	}
}

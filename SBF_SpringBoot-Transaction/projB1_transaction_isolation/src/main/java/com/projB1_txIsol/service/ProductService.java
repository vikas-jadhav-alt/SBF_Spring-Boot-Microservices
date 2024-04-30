package com.projB1_txIsol.service;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.projB1_txIsol.mapper.ProductRowMapper;
import com.projB1_txIsol.model.Product;
import com.projB1_txIsol.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo repo;

	@Autowired
	ProductService productService;;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	RowMapper rowMapper;


	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void outerMethod() throws Exception {

		System.out.println("Outer Method Start....");

		java.util.List<Product> query = jdbcTemplate.query("select * from product", rowMapper);
		System.out.println("1st Time: " + query);

		java.util.List<Product> query2 = jdbcTemplate.query("select * from product", rowMapper);
		System.out.println("2nd Time: " + query2);

		productService.innerMethod();

		java.util.List<Product> query3 = jdbcTemplate.query("select * from product", rowMapper);
		System.out.println("6th Time: " + query3);

		java.util.List<Product> query4 = jdbcTemplate.query("select * from product", rowMapper);
		System.out.println("7th Time: " + query4);


		System.out.println("End");

	}

//	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_UNCOMMITTED)
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
	public void innerMethod() throws Exception {

		System.out.println("Inner Method Start....");

		java.util.List<Product> query = jdbcTemplate.query("select * from product", rowMapper);
		System.out.println("3rd Time: " + query);

		java.util.List<Product> query2 = jdbcTemplate.query("select * from product", rowMapper);
		System.out.println("4th Time: " + query2);

		java.util.List<Product> query3 = jdbcTemplate.query("select * from product", rowMapper);
		System.out.println("5th Time: " + query3);

		System.out.println("End - This");

	}
}

package com.projB1_txProp.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.projB1_txProp.model.Product;

@Repository
public class ProductRepo {

	@Autowired
	JdbcTemplate jdbcTemplate;

//	@Transactional
//	@Transactional(propagation = Propagation.SUPPORTS)
//	@Transactional(propagation = Propagation.MANDATORY)
//	@Transactional(propagation = Propagation.NEVER)
//	@Transactional(propagation = Propagation.NOT_SUPPORTED)
//	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Transactional(propagation = Propagation.NESTED)
	public void saveProductRepoMethod(Product product) {

		String sql = "INSERT INTO product VALUES(?,?)";

		Object[] args = { product.getId(), product.getName() };

		System.out.println("repo-jdbc after this...");
		jdbcTemplate.update(sql, args);

		// Throw Error for ID = even
		if (product.getId() % 2 == 0)
			throw new RuntimeException("ID: " + product.getId());

		System.out.println("product saved: " + product.getId());
	}
}

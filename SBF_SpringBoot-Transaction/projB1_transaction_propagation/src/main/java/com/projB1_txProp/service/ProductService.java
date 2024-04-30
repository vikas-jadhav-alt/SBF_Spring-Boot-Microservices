package com.projB1_txProp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.projB1_txProp.model.Product;
import com.projB1_txProp.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo repo;

	@Autowired
	JdbcTemplate jdbcTemplate;

//	@Transactional(noRollbackFor = { RuntimeException.class })
//	@Transactional // Start Tx

//	@Transactional(propagation = Propagation.REQUIRED)
	public void saveProductInfoServiceMethod() throws Exception {

		System.out.println("service-jdbc after this...");
		jdbcTemplate.update("INSERT INTO product VALUES(101,'name:101'), (102,'name:10') ");

		for (int i = 1; i <= 10; i++) {

//			if (i == 7)
//				throw new RuntimeException("Some Error Occured");

			Product prd = new Product();
			prd.setId(i);
			prd.setName("name:" + i);

//			repo.saveProductRepoMethod(prd);

			try {
				repo.saveProductRepoMethod(prd);
			} catch (Exception e) {
				System.out.println("Exception thrown from repo method: " + e.getMessage());
			}

		}

		throw new RuntimeException("Some Error Occured");

	}

	// Commit Tx

}

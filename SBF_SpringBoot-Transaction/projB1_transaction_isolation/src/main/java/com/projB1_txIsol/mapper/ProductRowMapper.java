package com.projB1_txIsol.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.projB1_txIsol.model.Product;

@Component
public class ProductRowMapper implements RowMapper<Product> {

	public Product mapRow(ResultSet resultSet, int i) throws SQLException {

		Product product = new Product();
		product.setPid(resultSet.getInt("pid"));
		product.setPrice(resultSet.getDouble("price"));
		product.setQuantity(resultSet.getInt("quantity"));

		return product;
	}
}
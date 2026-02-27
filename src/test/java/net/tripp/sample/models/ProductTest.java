package net.tripp.sample.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import net.tripp.sample.db.TestQueryExecutor;

class ProductTest {

	@Test
	void testAll() throws SQLException {
		TestQueryExecutor db = new TestQueryExecutor();
		
		List<Product> products = Product.all(db);
		
		String[] expectedQueries = {"getAll"};
		assertEquals(db.getQueries(), Arrays.asList(expectedQueries));
		
		List<Product> expectedProducts = new ArrayList<>();
		expectedProducts.add(new Product("1", "Product 1"));
		expectedProducts.add(new Product("2", "Product 2"));
		assertEquals(products, expectedProducts);
	}

	@Test
	void testCreate() throws SQLException {
		TestQueryExecutor db = new TestQueryExecutor();
		
		Product.create(db, "New Product");
		
		String[] expectedQueries = { "insert New Product" };
		assertEquals(db.getQueries(), Arrays.asList(expectedQueries));
	}
}

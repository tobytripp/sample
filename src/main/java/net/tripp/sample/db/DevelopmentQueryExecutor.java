package net.tripp.sample.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
@Profile("dev")
public class DevelopmentQueryExecutor implements QueryExecutor {
	private static final String url = "jdbc:postgresql://localhost/development";
	private Connection connection;
	
	public DevelopmentQueryExecutor() throws SQLException {
		this.connection = DriverManager.getConnection(url, "development", "development");
	}

	@Override
	public List<Map<String,String>> getAll() throws SQLException {
		Statement statement = this.connection.createStatement();
		List<Map<String,String>> products = new ArrayList<>();
		ResultSet results = 
				statement.executeQuery("SELECT id, name FROM products");
		
		while (results.next()) {
			products.add(Map.of(
					"id",   results.getString(1),
					"name", results.getString(2)
				));
		}
		
		return products;
	}

	@Override
	public void insert(String newName) throws SQLException {
		Statement statement = this.connection.createStatement();
		statement.executeUpdate(
				String.format("INSERT INTO products (name) VALUES ('%s')", newName));
	}

}

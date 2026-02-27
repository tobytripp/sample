package net.tripp.sample.models;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import net.tripp.sample.db.QueryExecutor;

public record Product(String id, String name) {

	public static List<Product> all(QueryExecutor db) throws SQLException {
		return db.getAll().stream().
				map(attrs -> new Product(attrs.get("id"), attrs.get("name"))).
				collect(Collectors.toList());
	}

	public static Product create(QueryExecutor db, String newName) throws SQLException {
		db.insert(newName);
		return new Product("unknown", newName);
	}
}

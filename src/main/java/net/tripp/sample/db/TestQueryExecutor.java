package net.tripp.sample.db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class TestQueryExecutor implements QueryExecutor {
	private List<String> queries;
	
	public TestQueryExecutor() {
		this.queries = new ArrayList<>();
	}
	
	@Override
	public List<Map<String, String>> getAll() {
		queries.add("getAll");
		List<Map<String, String>> names = new ArrayList<>();
		names.add(Map.of("name", "Product 1", "id", "1"));
		names.add(Map.of("name", "Product 2", "id", "2"));
		return names;
	}

	@Override
	public void insert(String newName) throws SQLException {
		queries.add("insert " + newName);
	}
	
	public List<String> getQueries() {
		return this.queries;
	}
}

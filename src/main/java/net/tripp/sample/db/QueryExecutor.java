package net.tripp.sample.db;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface QueryExecutor {

	public List<Map<String, String>> getAll() throws SQLException;

	public void insert(String newName) throws SQLException;

}
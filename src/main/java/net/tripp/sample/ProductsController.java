package net.tripp.sample;

import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.tripp.sample.db.QueryExecutor;
import net.tripp.sample.models.Product;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ProductsController {
	@Autowired
	private QueryExecutor db;
	
	@GetMapping("/products")
	public String index() throws SQLException {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		List<Product> products = Product.all(db);
		
		products.stream().forEach(product -> {
			JSONObject obj = new JSONObject();
			obj.put("id", product.id());
			obj.put("name", product.name());
			jsonArray.add(obj); 
		});
		
		jsonObject.put("products", jsonArray);
		
		return jsonObject.toJSONString();
	}
	
	@PostMapping("/products")
	public String create(@RequestBody String json) throws SQLException {
		JSONObject obj = (JSONObject) JSONValue.parse(json);
		JSONObject attrs = (JSONObject) obj.get("product");
		String name = (String) attrs.get("name");
		
		Product.create(db, name);
		
		return "{ \"status\": \"ok\" }";
	}
}

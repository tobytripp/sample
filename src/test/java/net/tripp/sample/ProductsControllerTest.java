package net.tripp.sample;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ProductsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testIndex() throws Exception {
		mockMvc.perform(get("/api/products").accept(MediaType.APPLICATION_JSON)).
			andExpect(status().isOk()).
			andExpect(content().string(equalTo("{\"products\":[{\"name\":\"Product 1\",\"id\":\"1\"},{\"name\":\"Product 2\",\"id\":\"2\"}]}")));
	}

	@Test
	void testInsert() throws Exception {
		mockMvc.perform(post("/api/products").
			contentType(MediaType.APPLICATION_JSON).
			content("""
					{ "product": { "name": "New Product" }}
					""")).
		 	andExpect(status().isOk());
	}
}

package com.virtusa.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtusa.demo.web.rest.Product;
import com.virtusa.demo.web.rest.ProductController;

public class ProductControllerTest {

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new ProductController())
				.build();
	}

	@Test
	public void testSaveJson() throws Exception {

		ObjectMapper mapper = new ObjectMapper();

		mockMvc.perform(
				post("/savejson").content(
						mapper.writeValueAsString(new Product(1L, "Java")))
						.contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk());

	}

}

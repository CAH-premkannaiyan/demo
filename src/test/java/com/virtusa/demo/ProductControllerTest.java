package com.virtusa.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.collections.ListUtil;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtusa.demo.service.ProductService;
import com.virtusa.demo.web.rest.Product;
import com.virtusa.demo.web.rest.ProductController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class ProductControllerTest {

	private MockMvc mockMvc;

	@Mock
	private ProductService productService;
	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		ProductController productController = new ProductController(productService);
		this.mockMvc = MockMvcBuilders.standaloneSetup(productController)
				.build();
	}

	@Test
	public void testSaveJson() throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		

		
		Product product = new Product(1L, "Java");
		String[] features = {"Lambda","Funcational Interface"};
		product.setFeatures(CollectionUtils.arrayToList(features));
		mockMvc.perform(
				post("/savejson").content(
						mapper.writeValueAsString(product))
						.contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk());

	}
	
	@Test
	public void getProducts() throws Exception{
		
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1000L,"Junit"));
		products.add(new Product(2000L,"Apache"));
		when(productService.listProducts()).thenReturn(products);
		mockMvc.perform(get("/list").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(jsonPath("$[0].id").value("1000"))
        .andExpect(jsonPath("$[0].name").value("Junit"));
	}

}

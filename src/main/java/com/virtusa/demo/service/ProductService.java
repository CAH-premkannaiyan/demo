package com.virtusa.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.virtusa.demo.web.rest.Product;

@Service
public class ProductService {

	public List<Product> listProducts(){
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1L, "Java"));
		products.add(new Product(2L, "Spring"));
		return products;
	}
	
}

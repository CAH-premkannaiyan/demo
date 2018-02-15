package com.virtusa.demo.web.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.virtusa.demo.config.DemoBean;
import com.virtusa.demo.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private DemoBean demoBean;
	
	private ProductService productService;
	
	public ProductController(ProductService productService){
		this.productService = productService;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> list() {

		List<Product> products = productService.listProducts();
		
		return ResponseEntity.ok().body(products);

	}

	@RequestMapping(value = "/list/mvc", method = RequestMethod.GET)
	public String listmvc(Model model) {

		List<Product> products = productService.listProducts();

		model.addAttribute("products", products);
		model.addAttribute("values", "productvalue");

		return "product";

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {

		model.addAttribute("product", new Product());
		return "add";

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("product") Product product,
			Model model) {
		System.out.println("Id:" + product.getId() + "Name:"
				+ product.getName()+ "features:" + (product.getFeatures()!=null?product.getFeatures().size():null));
		demoBean.doPrint();
		model.addAttribute("products", productService.listProducts());
		return "product";
	}

	@RequestMapping(value = "/savejson", method = RequestMethod.POST)
	public ResponseEntity<?> saveJson(@RequestBody Product product) {
		System.out.println("Id:" + product.getId() + "Name:"
				+ product.getName());
		return ResponseEntity.ok().build();
	}
}

package com.virtusa.demo.web.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.demo.config.DemoBean;

@Controller
public class ProductController {

	@Autowired
	private DemoBean demoBean;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> list() {

		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1L, "Java"));
		products.add(new Product(2L, "Spring"));

		return ResponseEntity.ok().body(products);

	}

	@RequestMapping(value = "/list/mvc", method = RequestMethod.GET)
	public String listmvc(Model model) {

		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1L, "Java"));
		products.add(new Product(2L, "Spring"));

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
				+ product.getName());
		demoBean.doPrint();
		return "product";
	}

	@RequestMapping(value = "/savejson", method = RequestMethod.POST)
	public ResponseEntity<?> saveJson(@RequestBody Product product) {
		System.out.println("Id:" + product.getId() + "Name:"
				+ product.getName());
		return ResponseEntity.ok().build();
	}
}

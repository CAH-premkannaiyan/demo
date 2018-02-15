package com.virtusa.demo.web.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.virtusa.demo.service.ProductService;

public class WebController implements Controller {

	@Autowired
	private ProductService productService;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView("product");
		model.addObject("products", productService.listProducts());
		// TODO Auto-generated method stub
		return model;
	}

}

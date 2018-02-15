package com.virtusa.demo.web.rest;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Product {

	@NotNull
	private Long id;
	@NotNull
	@Length(min = 1, max = 5)
	private String name;
	private List<String> features;


	public Product() {

	}

	public Product(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getFeatures() {
		return features;
	}

	public void setFeatures(List<String> features) {
		this.features = features;
	}

	
	public void printAll() {
		System.out.println("id:" + id + ";Name:" + name);
	}

}
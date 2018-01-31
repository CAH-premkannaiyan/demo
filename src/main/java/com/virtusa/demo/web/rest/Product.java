package com.virtusa.demo.web.rest;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Product{
	public Product(){
		
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
	public void printAll(){
		System.out.println("id:"+id+";Name:"+name);
	}
	@NotNull	
	private Long id;
	@NotNull
	@Length(min = 1,max=5 )
	private String name;
	
	
	
}
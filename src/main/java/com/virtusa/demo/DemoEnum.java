package com.virtusa.demo;

public enum DemoEnum {

	SPRING(100),STRUTS(102),JAVA(103);
	
	private int code;
	
	DemoEnum(int code){
		this.code=code;
	}
	
	public int getCode(){
		return this.code;
	}
}

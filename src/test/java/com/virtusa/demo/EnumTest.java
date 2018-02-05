package com.virtusa.demo;

import org.junit.Test;

public class EnumTest {
	
	@Test
	public void testEnum(){
		DemoEnum de = DemoEnum.JAVA;
		System.out.println(de.getCode());
	}

}

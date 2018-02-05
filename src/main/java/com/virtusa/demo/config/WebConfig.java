package com.virtusa.demo.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(value="com.virtusa.demo.config")
public class WebConfig {
	
	@Bean
	public DemoBean demoBean(){
		return new DemoBean();
	}

}

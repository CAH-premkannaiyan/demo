package com.virtusa.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import com.virtusa.demo.web.rest.WebController;

@Configuration
//@ComponentScan(value="com.virtusa.demo.config")
public class WebConfig {
	
	@Bean
	public DemoBean demoBean(){
		return new DemoBean();
	}
	
	
	@Bean
	public SimpleUrlHandlerMapping simpleUrlHandlerMapping(){
		SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
		Map urlMap = new HashMap();
		urlMap.put("/controllerinterface", welcome());
		simpleUrlHandlerMapping.setUrlMap(urlMap);
		return simpleUrlHandlerMapping;
	}
	
    @Bean
    BeanNameUrlHandlerMapping beanNameUrlHandlerMapping() {
        return new BeanNameUrlHandlerMapping();
    }
 
    @Bean("/controllerinterfacebean")
    public WebController welcome() {
        return new WebController();
    }

}

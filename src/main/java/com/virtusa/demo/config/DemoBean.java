package com.virtusa.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoBean {
	
    private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public void doPrint(){
		log.debug("Inside Bean");
	}

}

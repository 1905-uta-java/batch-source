package com.revature.service;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
	/*
	 * This is my Service Endpoint Interface (SEI)
	 */
	
	String sayHi(String text);
	
}

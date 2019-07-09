package com.revature.service;

import javax.jws.WebService;

@WebService(endpointInterface="com.revature.service.HelloWorld")
public class HelloWorldImpl implements HelloWorld{
	/*
	 * (non-Javadoc)
	 * @see com.revature.service.HelloWorld#sayHi(java.lang.String)
	 * 
	 * This is our Service Implementing Bean 
	 */

	@Override
	public String sayHi(String text) {
		System.out.println(text);
		return text;
	}

}

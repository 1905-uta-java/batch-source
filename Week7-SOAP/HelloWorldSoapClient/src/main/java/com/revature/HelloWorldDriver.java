package com.revature;

import com.revature.service.HelloWorld;
import com.revature.service.HelloWorldImplService;

public class HelloWorldDriver {
	
	// we ran wsimport -Xnocompile http://10.182.67.105:8080/HelloWorldSoapService/hello?wsdl
	// to generate the code for our client

	public static void main(String[] args) {
		
		HelloWorldImplService helloService = new HelloWorldImplService();
		HelloWorld helloWorld = helloService.getHelloWorldImplPort();
		
		String message = "Hello World";
		System.out.println("sending message from my client: "+ message);
		helloWorld.sayHi(message);

	}

}

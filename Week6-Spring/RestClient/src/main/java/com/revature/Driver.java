package com.revature;

import org.springframework.web.client.RestTemplate;

import com.revature.model.Restaurant;

public class Driver {

	
	
	public static void main(String[] args) {
		String requestUrl = "http://localhost:8082/restaurants/2";
		
		// create an instance of RestTemplate, provided by Spring Web
		RestTemplate restTemplate = new RestTemplate();
		
		Restaurant r = restTemplate.getForObject(requestUrl, Restaurant.class);
		System.out.println(r);
		
	}

}

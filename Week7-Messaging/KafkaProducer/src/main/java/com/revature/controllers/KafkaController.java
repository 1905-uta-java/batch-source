package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.service.ProducerService;

@RestController
public class KafkaController {
	
	@Autowired
	ProducerService producerService;
	
	@PostMapping("/publish")
	public void sendMessageToKafkaTopic(@RequestParam("message")String message) {
		producerService.sendMessage(message);
	}

}

package com.revature.service;

import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

	private static Logger log = Logger.getLogger(ConsumerService.class);
	
	@KafkaListener(topics="test")
	public void consume(String message) {
		log.info("consumed message ----->" + message);
	}
	
}

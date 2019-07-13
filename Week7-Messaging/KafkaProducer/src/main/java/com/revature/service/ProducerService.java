package com.revature.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
	
	private static Logger log = Logger.getLogger(ProducerService.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message) {
		log.info("producing message ----->" + message);
		kafkaTemplate.send("test", message);
	}

}

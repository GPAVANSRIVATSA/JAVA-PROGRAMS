package com.KafkaConsumer.SpringKafkaConsumer.Consumer;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class Consumer {
	
	private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(Consumer.class);
	
	@KafkaListener(topics="illustration3",groupId="consumer-group-1")
	public void consume1(String message)
	{
		LOGGER.info("Consumer 1 recieved messages "+message);
	}
	@KafkaListener(topics="illustration3",groupId="consumer-group-1")
	public void consume2(String message)
	{
		LOGGER.info("Consumer 2 recieved messages "+message);
	}
	@KafkaListener(topics="illustration3",groupId="consumer-group-1")
	public void consume3(String message)
	{
		LOGGER.info("Consumer 3 recieved messages "+message);
	}
	@KafkaListener(topics="illustration3",groupId="consumer-group-1")
	public void consume4(String message)
	{
		LOGGER.info("Consumer 4 recieved messages "+message);
	}

}

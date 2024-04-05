package com.Example.KafkaExample.Configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicCreation {
	
	@Bean
	public NewTopic createTopic()
	{
		return new NewTopic("illustration3",5,(short)1);
	}

}

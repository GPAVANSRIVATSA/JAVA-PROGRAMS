package springKafka.springKafkaDemo.Kafka;

import java.util.HashMap;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KeyKafkaConsumer {
	
	private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(KeyKafkaConsumer.class);
	@KafkaListener(topics="illustrate",groupId="myGroup")
	public void showOut(ConsumerRecord<String,String>record)
	{
		String key=record.key();
		String value=record.value();
		LOGGER.info(key);
		LOGGER.info(value);
	}

}

package springKafka.springKafkaDemo.Kafka;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KeyKafkaProducer {
	private static final Logger LOGGER=LoggerFactory.getLogger(KeyKafkaProducer.class);
	private KafkaTemplate<String,String> theKafkaTemplate;
	
	public KeyKafkaProducer(KafkaTemplate theKafkaTemplate)
	{
		this.theKafkaTemplate=theKafkaTemplate;
	}
	public void sendKeyValue(String Key,String Value)
	{
		theKafkaTemplate.send("illustrate",Key,Value);
	}
}

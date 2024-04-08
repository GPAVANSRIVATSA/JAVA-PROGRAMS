package springKafka.springKafkaDemo.Kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KeyValueConsumer {
	private static final Logger LOGGER=LoggerFactory.getLogger(KeyValueConsumer.class);
	
	@KafkaListener(topics="illustration",groupId="myGroup")
	public void consume1(ConsumerRecord<String,String>record)
	{
		String key=record.key();
		String value=record.value();
		LOGGER.info("Consumer1 key value pair is "+record.key()+record.value());
	}
	@KafkaListener(topics="illustration",groupId="myGroup")
	public void consume2(ConsumerRecord<String,String>record)
	{
		String key=record.key();
		String value=record.value();
		LOGGER.info("Consumer2 key value pair is "+record.key()+record.value());
	}
	@KafkaListener(topics="illustration",groupId="myGroup")
	public void consume3(ConsumerRecord<String,String>record)
	{
		String key=record.key();
		String value=record.value();
		LOGGER.info("Consumer3 key value pair is "+record.key()+record.value());
	}

}

package springKafka.springKafkaDemo.Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
	private static final Logger LOGGER=LoggerFactory.getLogger("JsonKafkaConsumer.class");
	
	@KafkaListener(topics="example",groupId="myGroup")
	public void publish(User theUser)
	{
		LOGGER.info(String.format("Json message recived %s",theUser.toString()));
	}
	
	

}

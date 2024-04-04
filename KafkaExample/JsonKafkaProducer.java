package springKafka.springKafkaDemo.Kafka;

import  springKafka.springKafkaDemo.UserCredientials.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
	private static final Logger LOGGER=LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	private KafkaTemplate<String,User> theKafkaTemplate;
	
	public JsonKafkaProducer(KafkaTemplate<String,User>theKafkaTemplate)
	{
		this.theKafkaTemplate=theKafkaTemplate;
	}
	public void sendMessage(User theUser)
	{
		LOGGER.info(String.format("Message sent is %s"+theUser.toString()));
		Message<User>message=MessageBuilder.withPayload(theUser).setHeader(KafkaHeaders.TOPIC,"example").build();
		theKafkaTemplate.send(message);
	}
	
	

}

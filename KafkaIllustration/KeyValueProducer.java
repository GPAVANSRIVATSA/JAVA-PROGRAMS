package springKafka.springKafkaDemo.Kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KeyValueProducer {
	
	private KafkaTemplate<String,String> theKafkaTemplate;
	
	public KeyValueProducer(KafkaTemplate theKafkaTemplate)
	{
		this.theKafkaTemplate=theKafkaTemplate;
	}
	public void sendData(String key,String value)
	{
		theKafkaTemplate.send("illustration",key,value);
	}
}

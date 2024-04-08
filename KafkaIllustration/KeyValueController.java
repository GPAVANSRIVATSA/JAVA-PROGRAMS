package springKafka.springKafkaDemo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springKafka.springKafkaDemo.Kafka.KeyValueProducer;

@RestController
@RequestMapping("/api")
public class KeyValueController {
	
	KeyValueProducer theKeyValueProducer;
	
	public KeyValueController(KeyValueProducer theKeyValueProducer)
	{
		this.theKeyValueProducer=theKeyValueProducer;
	}
	@GetMapping("/sendKeyValueToTopic/{key}/{value}")
	public ResponseEntity<String> sendToTopic(@PathVariable("key")String key,@PathVariable("value")String value)
	{
		theKeyValueProducer.sendData(key, value);
		return ResponseEntity.ok("Data sent to the topic");
	}
	

}

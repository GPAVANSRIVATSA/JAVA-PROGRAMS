package springKafka.springKafkaDemo.Controller;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springKafka.springKafkaDemo.Kafka.KeyKafkaProducer;

@RestController
@RequestMapping("/api")
public class KeyController {
	private KeyKafkaProducer theKeyKafkaProducer;
	
	public KeyController(KeyKafkaProducer theKeyKafkaProducer)
	{
		this.theKeyKafkaProducer=theKeyKafkaProducer;
	}
	@GetMapping("/sendKeyValue/{key}/{value}")
	public ResponseEntity<String> sendKeyValue(@PathVariable("key") String key,@PathVariable("value") String value)
	{
		theKeyKafkaProducer.sendKeyValue(key,value);
		return ResponseEntity.ok("Message sent to the Kafka Topic");
	}

}

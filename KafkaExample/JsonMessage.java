package springKafka.springKafkaDemo.Controller;

import org.apache.catalina.User;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import springKafka.springKafkaDemo.Kafka.JsonKafkaProducer;

@RestController
@RequestMapping("/api")
public class JsonMessage {
	
	private JsonKafkaProducer theJsonKafkaProducer;
	
	public JsonMessage(JsonKafkaProducer theJsonKafkaProducer)
	{
		this.theJsonKafkaProducer=theJsonKafkaProducer;
	}
	@PostMapping("/sendObject")
	public ResponseEntity<String> publish(@RequestBody User theUser)
	{
		theJsonKafkaProducer.sendMessage((springKafka.springKafkaDemo.UserCredientials.User) theUser);
		return ResponseEntity.ok("Json message sent to Kafka topic");
	}

}

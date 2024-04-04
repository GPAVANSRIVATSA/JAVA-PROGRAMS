package springKafka.springKafkaDemo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springKafka.springKafkaDemo.Kafka.KafkaProducer;

@RestController
@RequestMapping("/api")
public class MessageController {
	
	private KafkaProducer theKafkaProducer;
	
	public MessageController(KafkaProducer theKafkaProducer)
	{
		this.theKafkaProducer=theKafkaProducer;
	}
	
	@GetMapping("/send")
	public ResponseEntity<String> send(@RequestParam("message")String message)
	{
		theKafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent to Kafka Topic;");
	}
}

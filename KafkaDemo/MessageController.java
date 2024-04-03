package springKafka.springKafkaDemo.Controller;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {
	
	private KafkaProducer theKafkaProducer;
	@Autowired
	public MessageController(KafkaProducer theKafkaProducer)
	{
		this.theKafkaProducer=theKafkaProducer;
	}
	@GetMapping("/send")
	public ResponseEntity<String> publish(@RequestParam("message")String message)
	{
		theKafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent to the topic");
	}
	

}

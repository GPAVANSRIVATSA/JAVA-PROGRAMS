package com.Example.KafkaExample.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Example.KafkaExample.Config.Producer;

@RestController
@RequestMapping("/api")
public class MessageController {
	
	private Producer theProducer;
	
	public MessageController(Producer theProducer)
	{
		this.theProducer=theProducer;
	}
	@GetMapping("/send")
	public ResponseEntity<String> send(@RequestParam("message")String message)
	{
		try
		{
		theProducer.push(message);
		return ResponseEntity.ok("Message sent to the Topic");
		}
		catch(Exception ex)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}

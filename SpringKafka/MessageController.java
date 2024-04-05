package com.Example.KafkaExample.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/send/{message}")
	public ResponseEntity<String> send(@PathVariable String message)
	{
		try
		{
		for(int i=0;i<100;i++)
		{
		theProducer.push(message+" "+i);
		}
		return ResponseEntity.ok("Message sent to the Topic");
		}
		catch(Exception ex)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}

package com.Example.KafkaExample.Config;

import java.util.concurrent.CompletableFuture;

import org.apache.kafka.common.internals.KafkaCompletableFuture;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class Producer {
	
	private KafkaTemplate<String,Object>theKafkaTemplate;
	
	public Producer(KafkaTemplate theKafkaTemplate)
	{
		this.theKafkaTemplate=theKafkaTemplate;
	}
	
	public void push(String message)
	{
		CompletableFuture<SendResult<String,Object>>future=theKafkaTemplate.send("illustration",message);
		future.whenComplete((result,ex)->{
			if(ex==null)
			{
				System.out.println("Sent message=["+message+"]with offset=["+result.getRecordMetadata().offset()+"]");
			}
			else
			{
				System.out.println("Unable to send message=["+message+ex.getMessage());
			}
		});
	}
	

}

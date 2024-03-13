package com.restMapping.RestMappingDemo.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class RestControllerDemo {
	@GetMapping("/test")
	public String sayHello()
	{
		return "Hello";
	}

	
}

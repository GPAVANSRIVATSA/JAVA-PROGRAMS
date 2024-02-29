package com.Acutator.Security.AcutatorSecDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActuatorSecurityDemo {
	@GetMapping("/")
	public String greet()
	{
		return "Hello";
	}
	

}

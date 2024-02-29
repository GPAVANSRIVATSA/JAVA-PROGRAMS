package com.Acutator.Example.AcutatorDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActuatorIllustration {
	@GetMapping("/")
	public String Greeting()
	{
		return "Hello";
	}

}

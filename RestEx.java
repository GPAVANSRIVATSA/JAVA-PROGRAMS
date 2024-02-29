package com.Illustrate.Example.Demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestEx {
	@GetMapping("/")
	public String greet()
	{
		return "Hello";
	}
	@GetMapping("/work")
	public String working()
	{
		return "Working";
	}
	@GetMapping("/automobile")
	public String automobile()
	{
		return "Car is the automobile";
	}

}

package com.properties.PropertiesDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProperiesIllustration {
	
	@Value("${company.name}")
	public String companyName;
	
	@Value("${automobile.name}")
	public String automobileName;
	@GetMapping("/")
	public String greeting()
	{
		return "Hello";
	}
	@GetMapping("/automobile")
	public String automobile()
	{
		return automobileName;
	}
	@GetMapping("/company")
	public String company()
	{
		return companyName;
	}

}

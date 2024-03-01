package com.constructor.injection.ConstructorInjectionIllustration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerDemo {
	Automobile au;
	@Autowired
	RestControllerDemo(Automobile am)
	{
		au=am;
	}
	@GetMapping("/")
	public String name()
	{
		return au.name();
	}

}

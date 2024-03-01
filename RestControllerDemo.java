package com.setter.injection.SetterInjectionDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerDemo {
	Automobile au;
	@Autowired
	public void setAutomobile(Automobile am)
	{
		au=am;
	}
	@GetMapping("/")
	public String name()
	{
		return au.name();
	}

}

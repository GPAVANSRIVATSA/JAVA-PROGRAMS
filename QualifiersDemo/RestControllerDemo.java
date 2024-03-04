package com.Qualifiers.QualifiersDemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerDemo {
	Food f;
	public RestControllerDemo(@Qualifier("breakFast")Food fo)
	{
		f=fo;
	}
	@GetMapping("/")
	public String item()
	{
		return f.item();
	}

}

package com.Lazy.LazyDemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerDemo {
	Action a;
	public RestControllerDemo(Action at)
	{
	    System.out.println(getClass().getSimpleName());
		this.a=at;
	}
	@GetMapping("/")
	public String action()
	{
		return a.doAction();
	}

}

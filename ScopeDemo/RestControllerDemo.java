package com.Scope.ScopeDemo;

import org.springframework.web.bind.annotation.GetMapping;

public class RestControllerDemo {
	Action a1;
	Action a2;
	public RestControllerDemo(Action at,Action ac)
	{
		a1=at;
		a2=ac;
	}
	@GetMapping("/")
	public String action()
	{
		return a1.doAction();
	}
	@GetMapping("/same")
	public boolean same()
	{
		return (a1==a2);
	}

}

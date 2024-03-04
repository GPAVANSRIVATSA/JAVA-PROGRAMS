package com.Lazy.LazyDemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Dance implements Action{
	public Dance()
	{
		System.out.println(getClass().getSimpleName());
	}
	@Override
	public String doAction()
	{
		return "dance";
	}
	

}

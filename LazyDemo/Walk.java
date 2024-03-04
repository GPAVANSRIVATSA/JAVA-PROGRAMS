package com.Lazy.LazyDemo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Walk implements Action{
	public Walk()
	{
		System.out.println(getClass().getSimpleName());
	}
	@Override
	public String doAction()
	{
		return "Walk";
	}

}

package com.Primary.PrimaryDemo;

import org.springframework.stereotype.Component;

@Component
public class Cricket implements Game {
	@Override
	public String play()
	{
		return "Play the game Cricket";
	}
	

}

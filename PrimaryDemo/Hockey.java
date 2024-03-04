package com.Primary.PrimaryDemo;

import org.springframework.stereotype.Component;

@Component
public class Hockey implements Game {
	@Override
	public String play()
	{
		return "Play the game Hockey";
	}
	

}

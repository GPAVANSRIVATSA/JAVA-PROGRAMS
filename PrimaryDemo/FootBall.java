package com.Primary.PrimaryDemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FootBall implements Game {
	@Override
	public String play()
	{
		return "Play the game Football";
	}

}

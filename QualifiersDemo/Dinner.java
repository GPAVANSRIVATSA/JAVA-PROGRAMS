package com.Qualifiers.QualifiersDemo;

import org.springframework.stereotype.Component;

@Component
public class Dinner implements Food {
	@Override
	public String item()
	{
		return "Eat Chapati";
	}

}

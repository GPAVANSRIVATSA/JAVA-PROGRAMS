package com.Qualifiers.QualifiersDemo;

import org.springframework.stereotype.Component;

@Component
public class Lunch implements Food {
	@Override
	public String item()
	{
		return "Eat Rice";
	}

}

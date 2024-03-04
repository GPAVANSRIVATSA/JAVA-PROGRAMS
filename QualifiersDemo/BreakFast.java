package com.Qualifiers.QualifiersDemo;

import org.springframework.stereotype.Component;

@Component
public class BreakFast implements Food{
	@Override
	public String item()
	{
		return "Eat dosa";
	}

}

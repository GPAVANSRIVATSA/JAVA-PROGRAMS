package com.Scope.ScopeDemo;

import org.springframework.stereotype.Component;

@Component
public class Walk implements Action {
	@Override
	public String doAction()
	{
		return "Walk";
	}

}

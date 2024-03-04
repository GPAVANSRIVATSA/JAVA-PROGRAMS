package com.Scope.ScopeDemo;

import org.springframework.stereotype.Component;

@Component
public class Dance implements Action {
	@Override
	public String doAction()
	{
		return "dance";
	}
}

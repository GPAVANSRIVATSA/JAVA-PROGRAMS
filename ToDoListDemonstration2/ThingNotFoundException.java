package com.Example.ToDoListDemonstration.Exception;

public class ThingNotFoundException extends RuntimeException {
	
	public ThingNotFoundException(String message)
	{
		super(message);
	}

}

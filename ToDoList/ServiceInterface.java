package com.List.ToDoListDemo.Service;

import java.util.List;

import com.List.ToDoListDemo.Things.ToDoThings;

public interface ServiceInterface {
	public List<ToDoThings>listThings();
	public void add(ToDoThings theToDoThings);
	public void delete(int id);
	

}

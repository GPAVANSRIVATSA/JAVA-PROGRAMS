package com.Example.ToDoListDemonstration.Service;

import java.util.List;

import com.Example.ToDoListDemonstration.Entity.ListOfThings;


public interface ServiceInterface {
	public List<ListOfThings>listThings();
	public void add(ListOfThings theToDoThings);
	public void delete(int id);

}

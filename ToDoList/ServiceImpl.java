package com.List.ToDoListDemo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.List.ToDoListDemo.Dao.ThingRepository;
import com.List.ToDoListDemo.Things.ToDoThings;

import jakarta.transaction.Transactional;
@Service
public class ServiceImpl implements ServiceInterface{
	
	public ThingRepository theThingRepository;
	
	@Autowired
	public ServiceImpl()
	{
		this.theThingRepository=theThingRepository;
	}
	@Override
	public List<ToDoThings> listThings() {
		List<ToDoThings>li=theThingRepository.findAll();
		return li;
	}

	@Override
	@Transactional
	public void delete(int id) {
		Optional<ToDoThings> theOptional=theThingRepository.findById(id);
		ToDoThings theToDoThings=theOptional.get();
		theThingRepository.delete(theToDoThings);
		
	}
	@Override
	@Transactional
	public void add(ToDoThings theToDoThings) {
		theThingRepository.save(theToDoThings);
		
	}

}

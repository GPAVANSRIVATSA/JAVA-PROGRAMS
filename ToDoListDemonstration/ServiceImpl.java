package com.Example.ToDoListDemonstration.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Example.ToDoListDemonstration.Dao.ThingsRepository;
import com.Example.ToDoListDemonstration.Entity.ListOfThings;

import jakarta.transaction.Transactional;

@Service
public class ServiceImpl implements ServiceInterface {

	public ThingsRepository theThingsRepository;
	
	@Autowired
	public ServiceImpl(ThingsRepository theThingsRepository)
	{
		this.theThingsRepository=theThingsRepository;
	}
	@Override
	public List<ListOfThings> listThings() {
		// TODO Auto-generated method stub
		List<ListOfThings>li=theThingsRepository.findAll();
		return li;
	}

	@Override
	@Transactional
	public void add(ListOfThings theToDoThings) {
		// TODO Auto-generated method stub
		theThingsRepository.save(theToDoThings);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		Optional<ListOfThings> theOptional=theThingsRepository.findById(id);
		ListOfThings theListOfThings=theOptional.get();
		theThingsRepository.delete(theListOfThings);
		
	}

}

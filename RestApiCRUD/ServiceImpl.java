package com.RestApi.RestApiCrudDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestApi.RestApiCrudDemo.DAO.EmployeeDAO;
import com.RestApi.RestApiCrudDemo.Entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class ServiceImpl implements ServiceInterface{

	EmployeeDAO ed;
	
	@Autowired
	public ServiceImpl(EmployeeDAO em)
	{
		ed=em;
	}
	
	@Override
	public List<Employee> findAll() {
		
		return ed.findAll();
	}
	@Override
	public Employee findById(int id)
	{
		return ed.findById(id);
	}
	@Override
	@Transactional
	public Employee add(Employee emp)
	{
		return ed.add(emp);
	}
	@Override
	@Transactional
	public void deleteById(int id)
	{
		ed.deleteById(id);
	}

}

package com.JpaRepository.JpaRepositoryDemo.Service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JpaRepository.JpaRepositoryDemo.DAO.EmployeeRepository;
import com.JpaRepository.JpaRepositoryDemo.Entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class ServiceImpl implements ServiceInterface{

	EmployeeRepository er;
	
	@Autowired
	public ServiceImpl(EmployeeRepository ey)
	{
		er=ey;
	}
	
	@Override
	public List<Employee> findAll() {
		
		return er.findAll();
	}
	@Override
	public Employee findById(int id)
	{
		Optional<Employee>result=er.findById(id);
		Employee emp=null;
		if(result.isPresent())
		{
			emp=result.get;
		}
		else
		{
			throw new RuntimeException("Didnt find the id "+id);
		}
		return emp;
	}
	@Override
	public Employee add(Employee emp)
	{
		return er.add(emp);
	}
	@Override
	public void deleteById(int id)
	{
		er.deleteById(id);
	}

}

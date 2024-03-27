package com.MVCCrud.MVCCrudDemoApplication.Service;

import java.util.List;
import java.util.Optional;

import com.MVCCrud.MVCCrudDemoApplication.Dao.EmployeeRepository;
import com.MVCCrud.MVCCrudDemoApplication.Entity.Employee;

public class ServiceInterfaceImpl implements ServiceInterface {
	
	EmployeeRepository employeeRepository;
	
	public ServiceInterfaceImpl(EmployeeRepository er)
	{
		employeeRepository=er;
	}
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result=employeeRepository.findById(id);
		Employee emp=null;
		if(result.isPresent())
		{
			 emp=result.get();
		}
		else
		{
			throw new RuntimeException("Didn't find the id "+id);
		}
		return emp;
	}

	@Override
	public Employee add(Employee emp) {
		return (Employee) employeeRepository.save(emp);
	}
	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
		
	}

}

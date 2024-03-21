package com.MVCCRUD.MVCCRUDDemo2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.MVCCRUD.MVCCRUDDemo2.DAO.EmployeeRepository;
import com.MVCCRUD.MVCCRUDDemo2.Entity.Employee;
@Service
public class ServiceImpl implements ServiceInterface {

	EmployeeRepository employeeRepos;
	public ServiceImpl(EmployeeRepository er)
	{
		employeeRepos=er;
	}
	@Override
	public List<Employee> findAll() {
		return employeeRepos.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> em=employeeRepos.findById(id);
		Employee emp=null;
		if(em.isPresent())
		{
			emp=em.get();
		}
		else
		{
			throw new RuntimeException("Id not found "+id);
		}
		return emp;
	}

	@Override
	public void add(Employee emp) {
		employeeRepos.save(emp);
	}

	@Override
	public void delete(int id) {
		Optional<Employee>emp=employeeRepos.findById(id);
		Employee employee=null;
		if(emp.isPresent())
		{
			employee=emp.get();
		}
		else
		{
			throw new RuntimeException("Id not found "+id);
		}
		employeeRepos.delete(employee);
	}

}

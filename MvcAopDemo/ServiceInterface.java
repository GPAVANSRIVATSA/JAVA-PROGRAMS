package com.MVCCrud.MVCCrudDemoApplication.Service;

import java.util.List;

import com.MVCCrud.MVCCrudDemoApplication.Entity.Employee;


public interface ServiceInterface {
	public List<Employee> findAll();
	public Employee findById(int id);
	public Employee add(Employee emp);
	public void deleteById(int id);

}

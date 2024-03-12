package com.RestApi.RestApiCrudDemo.DAO;

import java.util.List;

import com.RestApi.RestApiCrudDemo.Entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
	public Employee findById(int id);
	public Employee add(Employee emp);
	//public void update(Employee emp);
	public void deleteById(int id);

}

package com.Exception.ExceptionHandler.dao;

import java.util.List;

import com.Exception.ExceptionHandler.Entity.Employee;

public interface EmployeeDAO {
	List<Employee> getEmployees();
	Employee getEmployeeById(int id);
	Employee addEmployee(Employee emp);
	void deleteEmployeeById(int id);
}

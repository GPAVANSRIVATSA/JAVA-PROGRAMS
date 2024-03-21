package com.MVCCRUD.MVCCRUDDemo2.Service;

import java.util.List;

import com.MVCCRUD.MVCCRUDDemo2.Entity.Employee;

public interface ServiceInterface {
	public List<Employee>findAll();
	public Employee findById(int id);
	public void add(Employee emp);
	public void delete(int id);

}

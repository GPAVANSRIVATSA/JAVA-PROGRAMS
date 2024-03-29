package com.Exception.ExceptionHandler.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Exception.ExceptionHandler.Entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImpl(EntityManager em)
	{
		entityManager=em;
	}
	@Override
	public List<Employee> getEmployees() {
		TypedQuery<Employee>theQuery=entityManager.createQuery("FROM Employee",Employee.class);
		List<Employee>li=theQuery.getResultList();
		return li;
	}

	@Override
	public Employee getEmployeeById(int id) {
		TypedQuery<Employee>theQuery=entityManager.createQuery("FROM Employee WHERE id=:data",Employee.class);
		theQuery.setParameter("data",id);
		Employee theEmp=theQuery.getSingleResult();
		return theEmp;
	}
	@Override
	public Employee addEmployee(Employee emp) {
		Employee theEmployee=entityManager.merge(emp);
		return theEmployee;
	}
	@Override
	public void deleteEmployeeById(int id) {
		Employee emp=entityManager.find(Employee.class,id);
	}

}

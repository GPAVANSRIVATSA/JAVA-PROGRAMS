package com.RestApi.RestApiCrudDemo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.RestApi.RestApiCrudDemo.Entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOimpl implements EmployeeDAO {

	EntityManager em;
	@Autowired
	public EmployeeDAOimpl(EntityManager er)
	{
		em=er;
	}
	
	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee>theQuery = em.createQuery("FROM Employee",Employee.class);
		return theQuery.getResultList();
	}
	@Override
	public Employee findById(int id)
	{
		Employee emp = new Employee();
		emp=em.find(Employee.class, id);
		return emp;
	}
	@Override
	public Employee add(Employee emp)
	{
		Employee eml=em.merge(emp);
		return eml;
	}
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Employee emp=em.find(Employee.class,id);
		em.remove(emp);
		
	}
}

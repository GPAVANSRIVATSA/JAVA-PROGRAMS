package com.Exception.ExceptionHandler.EmployeeController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Exception.ExceptionHandler.Entity.Employee;
import com.Exception.ExceptionHandler.Exception.EmployeeNotFoundException;
import com.Exception.ExceptionHandler.dao.EmployeeDAO;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	EmployeeDAO employeeDao;
	
	@Autowired
	public EmployeeController(EmployeeDAO edao)
	{
		employeeDao=edao;
	}
	@GetMapping("/employees")
	public List<Employee> getEmployees()
	{
		List<Employee> theList=employeeDao.getEmployees();
		return theList;
	}
	@GetMapping("/employees/{id}")
	public List<Employee> getEmployee(@PathVariable int id)
	{
		List<Employee>li=new ArrayList<Employee>();
		Employee temp=new Employee();
		Employee theEmp=employeeDao.getEmployeeById(id);
//		System.out.println(theEmp);
		/*if(theEmp.getStatus().equals("terminated"))
		{
			throw new EmployeeNotFoundException("Employee not found with the id "+id);
		}*/
		temp=theEmp;
		li.add(temp);
		while(true)
		{
			if(temp.getMid()!=0)
			{
				Employee theEmployee=employeeDao.getEmployeeById(temp.getMid());
				li.add(theEmployee);
				temp=theEmployee;
			}
			else
			{
				break;
			}	
		}
		return li;
	}
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee emp)
	{
	    emp.setId(0);
	    return employeeDao.addEmployee(emp);
	}
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee emp)
	{
		return employeeDao.addEmployee(emp);
	}
	@DeleteMapping("/employees/{id}")
	public void delete(@PathVariable int id)
	{
		employeeDao.deleteEmployeeById(id);
	}
	

}

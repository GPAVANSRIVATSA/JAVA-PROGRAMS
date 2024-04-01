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
import com.Exception.ExceptionHandler.Entity.EmployeeFilter;
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
	public List<EmployeeFilter> getEmployee(@PathVariable int id)
	{
		List<Employee>l1=new ArrayList<Employee>();
		List<EmployeeFilter>l2=new ArrayList<EmployeeFilter>();
		List<EmployeeFilter>l3=new ArrayList<EmployeeFilter>();
		EmployeeFilter temp1=new EmployeeFilter();
		Employee temp2=new Employee();
		Employee emp=employeeDao.getEmployeeById(id);
		l1=employeeDao.getEmployees();
		for(Employee temp:l1)
		{
			if(emp.getId()==temp.getMid())
			{
				EmployeeFilter empFilter=new EmployeeFilter();
				empFilter.setId(temp.getId());
				empFilter.setFirstName(temp.getFirstName());
				empFilter.setLastName(temp.getLastName());
				empFilter.setEmail(temp.getEmail());
				empFilter.setStatus(temp.getStatus());
				empFilter.setEmployee(null);
				l2.add(empFilter);
				
			}
		}
		
		for(int i=0;i<l2.size();i++)
		{
			temp1=l2.get(i);
			for(int j=0;j<l1.size();j++)
			{
				temp2=l1.get(j);
				if(temp1.getId()==temp2.getMid())
				{
					EmployeeFilter empFilter=new EmployeeFilter();
					empFilter.setId(temp2.getId());
					empFilter.setFirstName(temp2.getFirstName());
					empFilter.setLastName(temp2.getLastName());
					empFilter.setEmail(temp2.getEmail());
					empFilter.setStatus(temp2.getStatus());
					empFilter.setEmployee(null);
					temp1.setEmployee(empFilter);
					temp1=empFilter;
					j=-1;
				}
			}	
		}
		
		return l2;
		
		
		/*if(theEmp.getStatus().equals("terminated"))
		{
			throw new EmployeeNotFoundException("Employee not found with the id "+id);
		}*/
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

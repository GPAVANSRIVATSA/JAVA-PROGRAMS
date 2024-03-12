package com.RestApi.RestApiCrudDemo.Rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestApi.RestApiCrudDemo.DAO.EmployeeDAO;
import com.RestApi.RestApiCrudDemo.DAO.EmployeeDAOimpl;
import com.RestApi.RestApiCrudDemo.Entity.Employee;
import com.RestApi.RestApiCrudDemo.Service.ServiceImpl;
import com.RestApi.RestApiCrudDemo.Service.ServiceInterface;

@RestController
@RequestMapping("/api")
public class RestControllerDemo {
	
	private ServiceInterface si;
	Employee emp = new Employee("Alice","Bob","alicebob@gmail.com");
	public RestControllerDemo(ServiceInterface sl)
	{
		si=sl;
	}
	
	@GetMapping("/employees")
	public List<Employee> retriveAll()
	{
		return si.findAll();
	}
	/*@GetMapping("/employees/{id}")
	public Employee find(@PathVariable int id)
	{
		return si.findById(id);
	}*/
	@GetMapping("/employees/{id}")
	public Employee find(@PathVariable int id)
	{
		Employee theEmp = si.findById(id);
		if(theEmp==null)
			throw new RunTimeException("Employee id not found "+id);
		return theEmp;
	}
	@GetMapping("employees/add")
	public void add(Employee emp)
	{
		si.add(emp);
	}

}

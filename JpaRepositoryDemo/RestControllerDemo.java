package com.JpaRepository.JpaRepositoryDemo.Rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestApi.RestApiCrudDemo.DAO.EmployeeDAO;
import com.RestApi.RestApiCrudDemo.DAO.EmployeeDAOimpl;
import com.JpaRepository.JpaRepositoryDemo.Entity.Employee;
import com.JpaRepository.JpaRepositoryDemo.Service.ServiceImpl;
import com.JpaRepository.JpaRepositoryDemo.Service.ServiceInterface;

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
			throw new RuntimeException("Employee id not found "+id);
		return theEmp;
	}
	@PostMapping("/employees")
	public Employee add(@RequestBody Employee emp)
	{
		emp.setId(0);
		Employee eml=si.add(emp);
		return eml;
	}
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee emp)
	{
		Employee eml=si.add(emp);
		return eml;
	}
	@DeleteMapping("/employees/{id}")
	public String delete(@PathVariable int id)
	{
		Employee emp=si.findById(id);
		if(emp==null)
			throw new RuntimeException("Id not found "+id);
		si.deleteById(id);
		return "Deleted employee with id: "+id;
	}
}

package com.Crud.RestApiCrudDemo2.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Crud.RestApiCrudDemo2.Dao.Dao;
import com.Crud.RestApiCrudDemo2.Entity.Student;

@RestController
@RequestMapping("/api")
public class ControllerDemo {
	Dao dao;
	
	public ControllerDemo(Dao dao)
	{
		this.dao=dao;
	}
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		return dao.retriveAll();
	}
	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable int id)
	{
		return dao.retriveById(id);
	}
	@PostMapping("/students")
	public Student add(@RequestBody Student std)
	{
		std.setId(0);
		return dao.add(std);
	}
	@PutMapping("/students")
	public Student update(@RequestBody Student std)
	{
		return dao.add(std);
	}
	@DeleteMapping("/students/{id}")
	public void delete(@PathVariable int id)
	{
		Student std=dao.retriveById(id);
		dao.delete(std);
	}

}

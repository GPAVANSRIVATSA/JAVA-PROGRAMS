package com.restMapping.RestMappingDemo.Rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restMapping.RestMappingDemo.Entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student>al;
	
	@PostConstruct
	public void loadData()
	{
		Student temp1 = new Student("John","doe");
		Student temp2 = new Student("Lucas","Jam");
		Student temp3 = new Student("Steve","Har");
		al = Arrays.asList(temp1,temp2,temp3);
		
	}
	
	
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		
		return al;
	}
	
	@GetMapping("/students/{Id}")
	public Student getStudentById(@PathVariable int Id)
	{
		if(Id>al.size()||Id<0)
		{
			throw new StudentNotFoundException("Student Id not found "+Id);
		}
		return al.get(Id);
	}
	
	

}

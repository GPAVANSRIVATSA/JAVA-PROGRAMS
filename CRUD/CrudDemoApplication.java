package com.CrudDemo.CrudDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.CrudDemo.CrudDemo.Dao.StudentDAO;
import com.CrudDemo.CrudDemo.entity.Student;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner->{
			//createStudent(studentDAO);
			readStudent(studentDAO);
			
		};
	}
	
	private void readStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		System.out.println(studentDAO.findById(1));
		
	}
	private void createStudent(StudentDAO studentDAO)
	{
		System.out.println("Creating Student object");
		Student tempStudent1=new Student("John","Doe","johndoe@gmail.com");
		Student tempStudent2=new Student("Steve","Har","stevehar@gmail.com");

		
		System.out.println("Saving the object");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);

		
		System.out.println("Displaying the id "+tempStudent1.getId());
		
		
	}

}

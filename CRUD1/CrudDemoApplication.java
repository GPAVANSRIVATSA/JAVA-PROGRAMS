package com.CrudDemo.CrudDemo;

import java.util.ArrayList;

import org.hibernate.mapping.List;
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
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//retriveByLastName(studentDAO);
			//updateById(studentDAO);
			//deleteById(studentDAO);
			delete(studentDAO);
			
		};
	}
	
	private void delete(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		int n=studentDAO.deleteAll();
		System.out.println(n);
		
	}
	/*private void deleteById(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		int id=1;
		studentDAO.delete(id);
		
	}*/
	private void updateById(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		int id=1;
		Student theStudent = studentDAO.findById(id);
		theStudent.setFirstName("Jim");
		studentDAO.update(theStudent);
		System.out.println(theStudent);
	}
	private void retriveByLastName(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		ArrayList<Student>l=studentDAO.findByLastName("Doe");
		for(Student tempStudent:l)
		{
			System.out.println(tempStudent);
		}
		
	}
	private void queryForStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		ArrayList<Student>l=(ArrayList<Student>) studentDAO.findAll();
		for(Student tempStudent:l)
		{
			System.out.println(tempStudent);
		}
		
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

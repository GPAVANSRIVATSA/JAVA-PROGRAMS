package com.Mapping.CRUDDemoMapping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Mapping.CRUDDemoMapping.Entity.Course;
import com.Mapping.CRUDDemoMapping.Entity.Instructor;
import com.Mapping.CRUDDemoMapping.Entity.InstructorDetail;
import com.Mapping.CRUDDemoMapping.dao.AppDAO;

@SpringBootApplication
public class CrudDemoMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoMappingApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO)
	{
		return runner->{
			//createInstructor(appDAO);
			//findInstructorById(appDAO);
			//deleteById(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
			//createInstructorWithCourses(appDAO);
			findInstructorWithCourses(appDAO);
		};
	}
	private void findInstructorWithCourses(AppDAO appDAO) {
		int id=1;
		System.out.println(id);
		Instructor tempInstructor=appDAO.findById(id);
		System.out.println(tempInstructor);
		System.out.println(tempInstructor.getCourses());
	}
	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor1=new Instructor("Jim","Hop","jimhop@gmail.com");
		InstructorDetail tempInstructorDetail1=new InstructorDetail("http://www.youtube.com","Gaming");
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);
		Course tempCourse1=new Course("Air Guitar");
		Course tempCourse2=new Course("Pinball");
		tempInstructor1.add(tempCourse1);
		tempInstructor1.add(tempCourse2);
		
		System.out.println(tempInstructor1);
		System.out.println(tempInstructor1.getCourses());
		appDAO.save(tempInstructor1);
				
	}
	private void createInstructor(AppDAO appDAO) {
		Instructor tempInstructor1=new Instructor("John","Doe","johndoe@gmail.com");
		InstructorDetail tempInstructorDetail1=new InstructorDetail("http://luv2code.com","Dancing");
		Instructor tempInstructor2=new Instructor("Lucas","Har","lucashar@gmail.com");
		InstructorDetail tempInstructorDetail2=new InstructorDetail("http://luv2code.com","Singing");
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);
		tempInstructor2.setInstructorDetail(tempInstructorDetail2);
		appDAO.save(tempInstructor1);
		appDAO.save(tempInstructor2);	

	}
	private void findInstructorById(AppDAO appDAO) {
		int id=1;
		Instructor tempInstructor=appDAO.findById(id);
		System.out.println(tempInstructor);
		System.out.println(tempInstructor.getInstructorDetail());
	}
	private void deleteById(AppDAO appDAO) {
		int id=2;
		System.out.println("Deleting Instructor with id "+id);
		appDAO.delete(id);
	}
	private void deleteInstructorDetail(AppDAO appDAO) {
		int id=1;
		System.out.println("Deleting InstructorDetail with id "+id);
		appDAO.deleteById(id);
	}
	private void findInstructorDetail(AppDAO appDAO) {
		int id=1;
		InstructorDetail instructorDetail=appDAO.findByIdInstructorDetail(id);
		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
	}

}

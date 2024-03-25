package com.Mapping.CRUDDemoMapping;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Mapping.CRUDDemoMapping.Entity.Course;
import com.Mapping.CRUDDemoMapping.Entity.Instructor;
import com.Mapping.CRUDDemoMapping.Entity.InstructorDetail;
import com.Mapping.CRUDDemoMapping.Entity.Review;
import com.Mapping.CRUDDemoMapping.Entity.Student;
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
			//findInstructorWithCourses(appDAO);
			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructorById(appDAO);
			//updateCourseById(appDAO);
			//findCourseById(appDAO);
			//deleteInstructorById(appDAO);
			//deleteCourseWithId(appDAO);
			//createCourseAndReviews(appDAO);
			//findCourseAndReviewById(appDAO);
			//deleteCourseAndReviews(appDAO);
			//createCourseAndStudents(appDAO);
			//findCourseAndStudents(appDAO);
			//findStudentAndCourse(appDAO);
			//updateStudent(appDAO);
			deleteStudent(appDAO);
		};
	}
	private void deleteStudent(AppDAO appDAO) {
		int id=1;
		appDAO.deleteStudentById(id);
		System.out.println("Deleting Student With id: "+id);
	}
	private void updateStudent(AppDAO appDAO) {
		int id=2;
		Student tempStudent=appDAO.findStudentAndCourseByStudentId(id);
		Course tempCourse1=new Course("Rubik's cube");
		Course tempCourse2=new Course("Rubik's cube");
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);
		System.out.println("Updating Student with id "+id);
		System.out.println(tempStudent);
		System.out.println(tempStudent.getCourses());
		appDAO.update(tempStudent);
	}
	private void findStudentAndCourse(AppDAO appDAO) {
		int id=1;
	    Student tempStudent=appDAO.findStudentAndCourseByStudentId(id);
	    System.out.println(tempStudent);
	    System.out.println(tempStudent.getCourses());
	
	}
	private void findCourseAndStudents(AppDAO appDAO) {
		int id=1;
		Course tempCourse=appDAO.findCourseAndStudentByCourseId(id);
		System.out.println(tempCourse);
		System.out.println(tempCourse.getStudents());
	}
	private void createCourseAndStudents(AppDAO appDAO) {
		Course tempCourse=new Course("A new Thing");
		Student tempStudent1=new Student("John","Doe","johndoe@gmail.com");
		Student tempStudent2=new Student("Mary","Jim","maryjim@gmail.com");
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		System.out.println("Saving course: "+tempCourse);
		System.out.println(tempCourse.getStudents());
		appDAO.saveCourse(tempCourse);
	}
	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id=10;
		appDAO.deleteCourseById(id);
		System.out.println("Deleting Course With id: "+id);
	}
	private void findCourseAndReviewById(AppDAO appDAO) {
		int id=10;
		Course tempCourse=appDAO.findCourseAndReviewsById(id);
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
	}
	private void createCourseAndReviews(AppDAO appDAO) {
		Course tempCourse=new Course("Its a Tree");
		Review tempReview1=new Review("Its an excellent book");
		Review tempReview2=new Review("Very nice book");
		tempCourse.addReview(tempReview1);
		tempCourse.addReview(tempReview2);
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		appDAO.saveCourse(tempCourse);
	}
	private void deleteCourseWithId(AppDAO appDAO) {
		int id=10;
		System.out.println("Deleting Course with id "+id);
		appDAO.deleteCourseById(id);
	}
	private void deleteInstructorById(AppDAO appDAO) {
		int id=1;
		appDAO.delete(id);
		System.out.println("Deleting Instructor With Id: "+id);
	}
	private void findCourseById(AppDAO appDAO) {
		int id=10;
		System.out.println("Finding course by id: "+id);
		Course tempCourse=appDAO.findCourseById(id);
		System.out.println(tempCourse);
	}
	private void updateCourseById(AppDAO appDAO) {
		int id=1;
		Course tempCourse=appDAO.findCourseById(id);
		tempCourse.setTitle("Lights in Sun");
		appDAO.updateCourse(tempCourse);
		
	}
	private void updateInstructorById(AppDAO appDAO) {
		int id=1;
		System.out.println("Finding Instructor with id: "+id);
		Instructor tempInstructor=appDAO.findById(id);
		tempInstructor.setLastName("Kim");
		appDAO.update(tempInstructor);
	}
	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id=1;
		System.out.println(id);
		Instructor tempInstructor=appDAO.findInstructorByIdJoinFetch(id);
		System.out.println(tempInstructor);
		System.out.println(tempInstructor.getCourses());
	}
	private void findCoursesForInstructor(AppDAO appDAO) {
		int id=1;
		System.out.println(id);
		Instructor tempInstructor=appDAO.findById(id);
		System.out.println(tempInstructor);
		System.out.println("Finding courses with Instructor id "+id);
		ArrayList<Course>li=(ArrayList<Course>) appDAO.findCoursesByInstructorId(id);
		tempInstructor.setCourses(li);
		System.out.println(tempInstructor.getCourses());
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

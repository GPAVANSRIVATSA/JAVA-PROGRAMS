package com.Mapping.CRUDDemoMapping.dao;

import java.util.List;

import com.Mapping.CRUDDemoMapping.Entity.Course;
import com.Mapping.CRUDDemoMapping.Entity.Instructor;
import com.Mapping.CRUDDemoMapping.Entity.InstructorDetail;
import com.Mapping.CRUDDemoMapping.Entity.Student;

public interface AppDAO {
	void save(Instructor theInstructor);
	Instructor findById(int id);
	void delete(int id);
	
	InstructorDetail findByIdInstructorDetail(int id);
	void deleteById(int id);
	
	List<Course> findCoursesByInstructorId(int id);
	Instructor findInstructorByIdJoinFetch(int id);
	
	void update(Instructor tempInstructor);
	
	void updateCourse(Course tempCourse);
	Course findCourseById(int id);
	void deleteCourseById(int id);
	
	void saveCourse(Course tempCourse);
	
	Course findCourseAndReviewsById(int id);
	
	Course findCourseAndStudentByCourseId(int id);
	
	Student findStudentAndCourseByStudentId(int id);
	
	void update(Student tempStudent);
	
	void deleteStudentById(int id);
		
	
}

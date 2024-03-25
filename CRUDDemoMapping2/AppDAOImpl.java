package com.Mapping.CRUDDemoMapping.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.Mapping.CRUDDemoMapping.Entity.Course;
import com.Mapping.CRUDDemoMapping.Entity.Instructor;
import com.Mapping.CRUDDemoMapping.Entity.InstructorDetail;
import com.Mapping.CRUDDemoMapping.Entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {
	
	private EntityManager entityManager;
	
	public AppDAOImpl(EntityManager er)
	{
		entityManager=er;
	}

	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		entityManager.persist(theInstructor);
	}

	@Override
	public Instructor findById(int id) {
		return entityManager.find(Instructor.class,id);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		Instructor tempInstructor=entityManager.find(Instructor.class,id);
		List<Course>li=tempInstructor.getCourses();
		for(Course tempCourse:li)
		{
			tempCourse.setInstructor(null);
		}
		entityManager.remove(tempInstructor);
	}

	@Override
	public InstructorDetail findByIdInstructorDetail(int id) {
		return entityManager.find(InstructorDetail.class,id);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		InstructorDetail instructorDetail=entityManager.find(InstructorDetail.class,id);
		instructorDetail.getInstructor().setInstructorDetail(null);
		entityManager.remove(instructorDetail);
		
	}

	@Override
	public List<Course> findCoursesByInstructorId(int id) {
		TypedQuery<Course>theQuery=entityManager.createQuery("FROM Course where instructor.id=:data",Course.class);
		theQuery.setParameter("data", id);
		List<Course>courses=theQuery.getResultList();
		return courses;
	}

	@Override
	public Instructor findInstructorByIdJoinFetch(int id) {
		TypedQuery<Instructor>theQuery=entityManager.createQuery("select i from Instructor i "+"JOIN FETCH i.courses "+"JOIN FETCH i.instructorDetail"+"where i.id=:data",Instructor.class);
		theQuery.setParameter("data",id);
		Instructor instructor=theQuery.getSingleResult();
		return instructor;
	}

	@Override
	@Transactional
	public void update(Instructor tempInstructor) {
		entityManager.merge(tempInstructor);
	}

	@Override
	@Transactional
	public void updateCourse(Course tempCourse) {
		entityManager.merge(tempCourse);
	}

	@Override
	public Course findCourseById(int id) {
		return entityManager.find(Course.class,id);
	}

	@Override
	@Transactional
	public void deleteCourseById(int id) {
		Course tempCourse=entityManager.find(Course.class,id);
		entityManager.remove(tempCourse);
		
	}

	@Override
	@Transactional
	public void saveCourse(Course tempCourse) {
		entityManager.persist(tempCourse);	
	}

	@Override
	public Course findCourseAndReviewsById(int id) {
		TypedQuery<Course>theQuery=entityManager.createQuery("select c from Course c "+"JOIN FETCH c.reviews "+"where c.id=:data",Course.class);
		theQuery.setParameter("data",id);
		Course tempCourse=theQuery.getSingleResult();
		return tempCourse;
	}

	@Override
	public Course findCourseAndStudentByCourseId(int id) {
		TypedQuery<Course>theQuery=entityManager.createQuery("select c from Course c "+"JOIN FETCH c.students "+"where c.id=:data",Course.class);
		theQuery.setParameter("data",id);
		Course tempCourse=theQuery.getSingleResult();
		return tempCourse;
		
	}

	@Override
	public Student findStudentAndCourseByStudentId(int id) {
		TypedQuery<Student>theQuery=entityManager.createQuery("select s from Student a "+"JOIN FETCH s.courses "+"where s.id=:data",Student.class);
		theQuery.setParameter("data",id);
		Student tempStudent=theQuery.getSingleResult();
		return tempStudent;
	}

	@Override
	@Transactional
	public void update(Student tempStudent) {
		entityManager.merge(tempStudent);
	}

	@Override
	@Transactional
	public void deleteStudentById(int id) {
		Student tempStudent=entityManager.find(Student.class,id);
		entityManager.remove(tempStudent);
	}
}

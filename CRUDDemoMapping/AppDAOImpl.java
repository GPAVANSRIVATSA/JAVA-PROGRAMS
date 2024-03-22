package com.Mapping.CRUDDemoMapping.dao;

import org.springframework.stereotype.Repository;

import com.Mapping.CRUDDemoMapping.Entity.Instructor;
import com.Mapping.CRUDDemoMapping.Entity.InstructorDetail;

import jakarta.persistence.EntityManager;
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

}

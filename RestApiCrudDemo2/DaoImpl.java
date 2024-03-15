package com.Crud.RestApiCrudDemo2.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.Crud.RestApiCrudDemo2.Entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class DaoImpl implements Dao{
	
	EntityManager em;
	
	public DaoImpl(EntityManager er)
	{
		em=er;
	}

	@Override
	public List<Student> retriveAll() {
		// TODO Auto-generated method stub
		TypedQuery<Student>query=em.createQuery("FROM Student",Student.class);
		return query.getResultList();
	}

	@Override
	public Student retriveById(int id) {
		// TODO Auto-generated method stub
		Student std=em.find(Student.class,id);
		return std;
	}

	@Override
	@Transactional
	public Student add(Student std) {
		// TODO Auto-generated method stub
		Student student=em.merge(std);
		return student;
		
	}

	@Override
	@Transactional
	public void delete(Student std) {
		// TODO Auto-generated method stub
		em.remove(std);
		
	}

}

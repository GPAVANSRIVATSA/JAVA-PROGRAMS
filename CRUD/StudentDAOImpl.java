package com.CrudDemo.CrudDemo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CrudDemo.CrudDemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {
	private EntityManager em;
	
	@Autowired
	public StudentDAOImpl(EntityManager er)
	{
		em=er;
	}
	@Override
	@Transactional
	public void save(Student theStudent)
	{
		em.persist(theStudent);
	}
	@Override
	public Student findById(int id)
	{
		return em.find(Student.class, id);
	}
}

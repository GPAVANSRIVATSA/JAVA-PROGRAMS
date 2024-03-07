package com.CrudDemo.CrudDemo.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CrudDemo.CrudDemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
	@Override
	public ArrayList<Student> findAll()
	{
		TypedQuery<Student> theQuery = (TypedQuery<Student>) em.createQuery("FROM Student order by lastName desc",Student.class);
		return (ArrayList<Student>) theQuery.getResultList();
	}
	@Override
	public ArrayList<Student> findByLastName(String theLastName) {
		// TODO Auto-generated method stub
		TypedQuery<Student> theQuery = (TypedQuery<Student>) em.createQuery("FROM Student WHERE lastName=:theData",Student.class);
		theQuery.setParameter("theData", theLastName);
		return (ArrayList<Student>)theQuery.getResultList();
	}
	@Override
	@Transactional
	public void update(Student theStudent) {
		// TODO Auto-generated method stub
		em.merge(theStudent);
		
	}
	/*@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		Student theStudent=em.find("Student.class",id);
		em.remove(theStudent);
		
	}*/
	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		int deletedRows=em.createQuery("DELETE FROM Student").executeUpdate();
		return deletedRows;
	}
}

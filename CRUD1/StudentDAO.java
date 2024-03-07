package com.CrudDemo.CrudDemo.Dao;

import java.util.ArrayList;
import com.CrudDemo.CrudDemo.entity.Student;

public interface StudentDAO {
	public void save(Student theStudent);
	public Student findById(int id);
	public ArrayList<Student> findAll();
	public ArrayList<Student> findByLastName(String lastName);
	public void update(Student theStudent);
	//public void delete(int id);
	public int deleteAll();

}

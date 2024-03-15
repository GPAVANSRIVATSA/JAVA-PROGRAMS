package com.Crud.RestApiCrudDemo2.Dao;

import java.util.List;

import com.Crud.RestApiCrudDemo2.Entity.Student;

public interface Dao {
	public List<Student> retriveAll();
	public Student retriveById(int id);
	public Student add(Student std);
	public void delete(Student std);

}

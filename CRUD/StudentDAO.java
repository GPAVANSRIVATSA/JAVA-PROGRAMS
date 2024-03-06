package com.CrudDemo.CrudDemo.Dao;

import com.CrudDemo.CrudDemo.entity.Student;

public interface StudentDAO {
	public void save(Student theStudent);
	public Student findById(int id);

}

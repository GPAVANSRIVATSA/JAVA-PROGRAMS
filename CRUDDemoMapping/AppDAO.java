package com.Mapping.CRUDDemoMapping.dao;

import com.Mapping.CRUDDemoMapping.Entity.Instructor;
import com.Mapping.CRUDDemoMapping.Entity.InstructorDetail;

public interface AppDAO {
	void save(Instructor theInstructor);
	Instructor findById(int id);
	void delete(int id);
	
	InstructorDetail findByIdInstructorDetail(int id);
	void deleteById(int id);
}

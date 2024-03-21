package com.MVCCRUD.MVCCRUDDemo2.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MVCCRUD.MVCCRUDDemo2.Entity.Employee;

public interface EmployeeRepository extends JpaRepository{
	public List<Employee> findAllByOrderByLastNameAsc();

}

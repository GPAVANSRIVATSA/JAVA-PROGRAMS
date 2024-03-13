package com.DataRest.DataRestDemo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DataRest.DataRestDemo.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}

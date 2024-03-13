package com.JpaRepository.JpaRepositoryDemo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JpaRepository.JpaRepositoryDemo.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}

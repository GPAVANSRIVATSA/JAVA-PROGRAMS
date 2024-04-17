package com.Example.ToDoListDemonstration.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Example.ToDoListDemonstration.Entity.ListOfThings;

public interface ThingsRepository extends JpaRepository<ListOfThings,Integer> {

}

package com.List.ToDoListDemo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.List.ToDoListDemo.Things.ToDoThings;

public interface ThingRepository extends JpaRepository<ToDoThings,Integer>{

}

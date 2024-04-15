package com.List.ToDoListDemo.Things;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="listofthings")
public class ToDoThings {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SrNo")
	public int srNo;
	@Column(name="Thing")
	public String thing;
	
	public ToDoThings()
	{
		
	}
	public ToDoThings(int srNo,String thing)
	{
		this.srNo=srNo;
		this.thing=thing;
	}
	public String getThing() {
		return thing;
	}
	public void setThing(String thing) {
		this.thing = thing;
	}
	
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		srNo = srNo;
	}
	@Override
	public String toString() {
		return "ToDoThings [SrNo=" + srNo + ", thing=" + thing + "]";
	}
	
}

package com.Exception.ExceptionHandler.Entity;

public class EmployeeFilter {
	public int id;
	public String firstName;
	public String lastName;
	public String email;
	public String status;
	public EmployeeFilter employee;
	
	public EmployeeFilter()
	{
		
	}

	public EmployeeFilter(int id,String firstName, String lastName, String email, String status) {
		super();
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.status = status;
	}
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public EmployeeFilter getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeFilter employee) {
		this.employee = employee;
	}
	

}

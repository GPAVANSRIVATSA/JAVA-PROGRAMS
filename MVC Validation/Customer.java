package com.Validation.ValidationDemo.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {
	public String firstName;
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	public String lastName;
	@NotNull(message="is required")
	@Min(value=0,message="must be greater than or equal to zero")
	@Max(value=10,message="must be less than or equal to ten")
	public Integer freePasses;
	@Pattern(regexp="^[a-zA-Z0-9]{5}",message="only 5 chars/digits")
	public String postalCode;
	

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	

	public Integer getFreePasses() {
		return freePasses;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}

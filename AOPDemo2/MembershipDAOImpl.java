package com.AOP.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

	@Override
	public boolean addMember() {
		System.out.println(getClass()+" Adding a Membership account");
		return true;
	}
	@Override
	public void goToDance()
	{
		System.out.println(getClass()+" Dancing");
	}
	

}

package com.AOP.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.AOP.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {
	private String name;
	private String serviceCode;
	@Override
	public void addAccount(Account theAccount,boolean vpFlag) {
		System.out.println(getClass()+" Adding an account");
		
	}

	@Override
	public boolean doWork() {
		System.out.println(getClass()+"doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass()+"inGetName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+"inSetName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+"inGetServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+"inSetServiceCode");
		this.serviceCode = serviceCode;
	}

	@Override
	public List<Account> findAccounts() {
		return findAccounts(false);
	}

	@Override
	public List<Account> findAccounts(boolean tripWire) {
		if(tripWire)
		{
			throw new RuntimeException("Error");
		}
		List<Account>li=new ArrayList<Account>();
		Account tempAccount1=new Account("Jim","level1");
		Account tempAccount2=new Account("Hop","level2");
		li.add(tempAccount1);
		li.add(tempAccount2);
		return li;
	}

}

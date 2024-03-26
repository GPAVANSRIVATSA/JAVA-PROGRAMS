package com.AOP.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.AOP.aopdemo.dao.AccountDAO;
import com.AOP.aopdemo.dao.MembershipDAO;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,MembershipDAO membershipDAO)
	{
		return runner->{
			demoTheBeforeAdvice(accountDAO,membershipDAO);
			demoAfterReturnAdvice(accountDAO);
			
		};
	}
	private void demoAfterReturnAdvice(AccountDAO accountDAO) {
		List<Account>li=accountDAO.findAccounts();		
		System.out.println(li);
	}
	private void demoTheBeforeAdvice(AccountDAO accountDAO,MembershipDAO membershipDAO) {
		Account theAccount=new Account("John","level1");
		accountDAO.addAccount(theAccount,true);
		System.out.println(accountDAO.doWork());
		
		accountDAO.setName("John");
		accountDAO.setServiceCode("silver");
		
		System.out.println(accountDAO.getName());
		System.out.println(accountDAO.getServiceCode());
		System.out.println(membershipDAO.addMember());
		membershipDAO.goToDance();
	}

}

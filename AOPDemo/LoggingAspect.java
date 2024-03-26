package com.AOP.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.AOP.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class LoggingAspect {
	@AfterReturning(
			pointcut="execution(*com.AOP.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint,List<Account>result)
	{
		String method=theJoinPoint.getSignature().toShortString();
		System.out.println(method);
		System.out.println(result);
		covertAccountNamesToUpperCase(result);
		System.out.println(result);
	}
	private void covertAccountNamesToUpperCase(List<Account> result) {
		for(Account temp:result)
		{
			String name=temp.getName();
			name=name.toUpperCase();
			temp.setName(name);
		}
	}
	@Before("/aopdemo/src/main/java/com/AOP/aopdemo/aspect/PointCutExpressions.java.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint)
	{
		MethodSignature methodSignature=(MethodSignature)theJoinPoint.getSignature();
		System.out.println(methodSignature);
		Object[]args=theJoinPoint.getArgs();
		for(Object temp:args)
		{
			System.out.println(temp);
			if(temp instanceof Account)
			{
				Account theAccount=(Account)temp;
				System.out.println(theAccount.getName());
				System.out.println(theAccount.getLevel());
			}
		}
		System.out.println("Executing @Before advice on method");
	}

}

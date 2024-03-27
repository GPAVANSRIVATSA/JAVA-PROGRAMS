package com.AOP.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	@Around("execution(*com.AOP.aopdemo.Service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint)throws Throwable
	{
		String name=theProceedingJoinPoint.getSignature().toShortString();
		System.out.println(name);
		long begin=System.currentTimeMillis();
		Object result=null;
		try
		{
		result=theProceedingJoinPoint.proceed();
		}
		catch(Exception exc)
		{
			throw exc;
		}
		long end=System.currentTimeMillis();
		long duration=end-begin;
		System.out.println(duration/1000);
		return result;
		
	}
	@After("execution(*com.AOP.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFindAccountsAdvice(JoinPoint theJoinPoint)
	{
		String method=theJoinPoint.getSignature().toShortString();
		System.out.println(method);
	}
	@AfterThrowing(
			pointcut="execution(*com.AOP.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint,Throwable theExc)
	{
		String method=theJoinPoint.getSignature().toShortString();
		System.out.println(method);
		System.out.println(theExc);
	}
	
	@AfterReturning(
			pointcut="execution(*com.AOP.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint,List<Account>result)
	{
		String method=theJoinPoint.getSignature().toShortString();
		System.out.println(method);
		System.out.println(result);
		convertAccountNamesToUpperCase(result);
		System.out.println(result);
	}
	private void convertAccountNamesToUpperCase(List<Account> result) {
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

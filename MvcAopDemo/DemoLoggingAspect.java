package com.MVCCrud.MVCCrudDemoApplication.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;

@Aspect
@Component
public class DemoLoggingAspect {
	private Logger theLogger=Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.MVCCrud.MVCCrudDemoApplication.Controller.*.*()")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.MVCCrud.MVCCrudDemoApplication.Service.*.*()")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.MVCCrud.MVCCrudDemoApplication.Dao.*.*()")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage()||forServicePackage()||forDaoPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow")
	private void before(JoinPoint theJoinPoint)
	{
		String name=theJoinPoint.getSignature().toShortString();
		theLogger.info(name);
		Object[]args=theJoinPoint.getArgs();
		for(Object temp:args)
		{
			theLogger.info((String) temp);
		}
	}
	@AfterReturning(
			pointcut="forAppFlow",
			returning="result")
	private void afterReturning(JoinPoint theJoinPoint,Object result)
	{
		String name=theJoinPoint.getSignature().toShortString();
		theLogger.info(name);
		theLogger.info((String) result);
	}

}

package com.AOP.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LoggingToCloud {
	@Pointcut("/aopdemo/src/main/java/com/AOP/aopdemo/aspect/PointCutExpressions.java.forDaoPackageNoGetterSetter()")
	public void logToCloud()
	{
		System.out.println("Logging into cloud");
	}
}

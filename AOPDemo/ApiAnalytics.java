package com.AOP.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ApiAnalytics {
	@Before("/aopdemo/src/main/java/com/AOP/aopdemo/aspect/PointCutExpressions.java.forDaoPackageNoGetterSetter()")
	public void performApiAnalytics()
	{
		System.out.println("Doing API analytics");
	}
	

}

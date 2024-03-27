package com.AOP.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCutExpressions {
	@Pointcut("execution(* com.AOP.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {};
	
	@Pointcut("execution(* com.AOP.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.AOP.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("forDaoPackage()&& !(getter()||setter())")
	public void forDaoPackageNoGetterSetter() {}


}

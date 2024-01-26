package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class PointCutExpressions 
{
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void reusabledeclaration() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("reusabledeclaration()&&!(getter()||setter()) ")
	public void forDaoPackageNogetterSetter() {}
}

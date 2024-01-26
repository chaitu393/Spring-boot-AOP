package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyApiAspect 
{
	@Before("com.luv2code.aopdemo.aspect.PointCutExpressions.forDaoPackageNogetterSetter()")
	public void ApiAnalytics()
	{
		System.out.println("\n=====>Performing API Anlaytics.....!");
	}

}

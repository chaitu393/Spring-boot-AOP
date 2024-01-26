package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Aspect
@Component
@Order(5)
public class MyCloudAspect
{

	@Before("com.luv2code.aopdemo.aspect.PointCutExpressions.forDaoPackageNogetterSetter()")
	public void cloudAspect()
	{
		System.out.println("\n=====>Store By Cloud.....!");
	}
	
}

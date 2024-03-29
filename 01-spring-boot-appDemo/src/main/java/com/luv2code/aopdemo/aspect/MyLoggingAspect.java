package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect 
{
//    @Before("execution(public void addAccount())")
//	 @Before("execution(public void com.luv2code.aopdemo.dao.AccountDao.addAccount())")
//	 @Before("execution(public void add*())")
//	 @Before("execution(* add*())")
//	@Before("execution(* add*(com.luv2code.aopdemo.Account,..))")
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice()
    {
    	System.out.println("\n====>Executing Before Advice on adding Account...!");
    }
	
}

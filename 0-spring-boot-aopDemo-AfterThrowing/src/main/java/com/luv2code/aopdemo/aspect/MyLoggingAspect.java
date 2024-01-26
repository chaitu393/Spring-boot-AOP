package com.luv2code.aopdemo.aspect;

import java.util.Iterator;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyLoggingAspect 
{
//    @Before("execution(public void addAccount())")
//	 @Before("execution(public void com.luv2code.aopdemo.dao.AccountDao.addAccount())")
//	 @Before("execution(public void add*())")
//	 @Before("execution(* add*())")
//	@Before("execution(* add*(com.luv2code.aopdemo.Account,..))")
//    @Before("com.luv2code.aopdemo.aspect.PointCutExpressions.forDaoPackageNogetterSetter()")
	
	
	
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint)
    {
		MethodSignature ms=(MethodSignature) theJoinPoint.getSignature();
    	System.out.println("Method:"+ms);
    	
    	Object[] args=theJoinPoint.getArgs();
    	
    	for(Object tempargs:args)
    	{
    		System.out.println(tempargs);
    		if (tempargs instanceof Account) 
    		{
				Account theAccount=(Account) tempargs;
				System.out.println("Account Name:"+theAccount.getName());
				System.out.println("Account Level:"+theAccount.getLevel());
			}
    	}
    }
    @AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDao.findAccount(..))",
	        returning = "result" )
    public void afterReturningFindAdvice(JoinPoint theJoinPoint,List<Account> result)
    {
    	String method=theJoinPoint.getSignature().toShortString();
    	
    	System.out.println("\n====>Method:"+method);
    	
    	convertAccountNameToUpperCase(result);
    	
    	System.out.println("\n====>Result:"+result);
    }
	private void convertAccountNameToUpperCase(List<Account> result) 
	{
		for (Account tempaccount : result) 
		{
			String uppercase=tempaccount.getName().toUpperCase();
			
			tempaccount.setName(uppercase);
		}
		
	}
	@AfterThrowing(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDao.findAccount(..))",
			throwing = "theExc"
			      )
	public void afterThrowingAdvice(JoinPoint theJoinPoint,Throwable theExc)
	{
		System.out.println("\n\n===>>>>The Exception is:"+theExc);
	}
	
	
}

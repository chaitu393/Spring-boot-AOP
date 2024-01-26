package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.dao.Membershipdao;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao,Membershipdao membershipdao)
	{
		return runner->
		{
//			demoBeforeAdvice(accountDao,membershipdao);
//			demoAfterReturningAdvice(accountDao);
			demoAfterThrowingAdvice(accountDao);
		};
	}
	private void demoAfterThrowingAdvice(AccountDao accountDao)
	{
		 List<Account> theAccount=null;
		try 
		{
			boolean tripwire=true;
			theAccount=accountDao.findAccount(tripwire);
		} 
		catch (Exception e) 
		{
			System.out.println("\n\n===>Main Program :...caught Exception");
		}
       
		//displayMethods
		System.out.println("\n\n Main Program:Demo After Throwing Advice");
		System.out.println("************");
		System.out.println(theAccount);
		System.out.println("\n");
		
	}
	private void demoAfterReturningAdvice(AccountDao accountDao) 
	{
		List<Account> theAccount=accountDao.findAccount();
		//displayMethods
		System.out.println("\n\n Main Program:Demo After Returning Advice");
		System.out.println("************");
		System.out.println(theAccount);
		System.out.println("\n");
		
	}
	private void demoBeforeAdvice(AccountDao accountDao,Membershipdao membershipdao) 
	{

		
		Account myAccount=new Account();
		myAccount.setName("kiran");
		myAccount.setLevel("platinum");
		accountDao.addAccount(myAccount,true);
		accountDao.sayhi();
		accountDao.setName("chay");
		accountDao.setServiceCode("silver");
		
		String name=accountDao.getName();
		
		String code=accountDao.getServiceCode();
		
		
		
		
		membershipdao.addMember();
		membershipdao.saybye();
		
	}

}

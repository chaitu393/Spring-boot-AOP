package com.luv2code.aopdemo;

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
			demoBeforeAdvice(accountDao,membershipdao);
		};
	}
	private void demoBeforeAdvice(AccountDao accountDao,Membershipdao membershipdao) 
	{
		membershipdao.addMember();
		membershipdao.saybye();
		
		Account myAccount=new Account();
		accountDao.addAccount(myAccount,true);
		accountDao.sayhi();
		
	}

}

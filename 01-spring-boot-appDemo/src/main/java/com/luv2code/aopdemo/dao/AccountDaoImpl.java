package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.luv2code.aopdemo.Account;

@Repository
public class AccountDaoImpl implements AccountDao
{

	@Override
	public void addAccount(Account theAccount,boolean vipflag) {
		
		System.out.println(getClass()+"Doing my DB work:Adding an account");
		
	}

	@Override
	public void sayhi() {
		System.out.println("Hello chay");
		
	}

}

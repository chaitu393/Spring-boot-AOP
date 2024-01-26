package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.luv2code.aopdemo.Account;

@Repository
public class AccountDaoImpl implements AccountDao
{

	
	private String name;
	
	
	private String ServiceCode;
	
	
	public String getName() {
		
		System.out.println(getClass()+"in getName");
		return name;
	}

	public void setName(String name) {
		
		System.out.println(getClass()+"in setName");
		
		this.name = name;
	}

	public String getServiceCode() {
		
		System.out.println(getClass()+"in getServiceCode");
		return ServiceCode;
	}

	public void setServiceCode(String serviceCode) {
		
		System.out.println(getClass()+"in setServiceCode");
		ServiceCode = serviceCode;
	}

	@Override
	public void addAccount(Account theAccount,boolean vipflag) {
		
		System.out.println(getClass()+"Doing my DB work:Adding an account");
		
	}

	@Override
	public void sayhi() {
		System.out.println("Hello chay");
		
	}

	@Override
	public List<Account> findAccount() {
		
		
		return findAccount(false);
	}

	@Override
	public List<Account> findAccount(boolean tripwire) {
        
		if (tripwire)
		{
			throw new RuntimeException("Exception is There....");
		}
		
		
		List<Account> myAccount=new ArrayList<Account>();
		
		Account temp1=new Account("chay","Gold");
		Account temp2=new Account("kiran","silver");
		Account temp3=new Account("chaitanya","platinum");
		
		myAccount.add(temp1);
		myAccount.add(temp2);
		myAccount.add(temp3);
		return myAccount;
	}

}

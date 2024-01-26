package com.luv2code.aopdemo.dao;

import java.util.List;

import com.luv2code.aopdemo.Account;

public interface AccountDao 
{
    void addAccount(Account theAccount,boolean vipflag);
    void sayhi();
    public String getName();
    public void setName(String name);
    public String getServiceCode();
    public void setServiceCode(String serviceCode);
    
    List<Account> findAccount();
    
	List<Account> findAccount(boolean tripwire);
}

package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberShipDaoImpl implements Membershipdao
{

	@Override
	public boolean addMember() {
		
		System.out.println(getClass()+"Doing my DB work:Adding an account By MemberShip");
		return true;
		
	}

	@Override
	public void saybye() {
		System.out.println("bye chay");
		
	}

}

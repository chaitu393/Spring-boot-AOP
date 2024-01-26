package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneImp implements TrafficFortuneService
{

	@Override
	public String getfortune() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			
			throw new RuntimeException(e);
		}
		return "Expecting heavy Traffic pls wait for sometime... ";
	}

	@Override
	public String getfortune(boolean tripwire) {
		if (tripwire) {
			throw new RuntimeException("Major Accident Highway is closed");
		}
		return getfortune();
	}

}

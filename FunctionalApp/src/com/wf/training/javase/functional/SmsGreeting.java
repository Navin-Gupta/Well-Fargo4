package com.wf.training.javase.functional;

public class SmsGreeting implements Greeting {

	
	
	@Override
	public void sendGreeting(String message) {
		// TODO Auto-generated method stub
		System.out.println("Send over SMS : " + message);
	}

}

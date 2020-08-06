package com.wf.training.threadapp;

class MThreadPro implements Runnable{

	Thread t;
	
	public MThreadPro() {
		t = new Thread(this);
	}
	
	@Override
	public void run() {
		for(int i=1; i<=1000; i++) {
			System.out.println("Run : " + i);
		}
	}
	
}


public class MyAppPro {
	public static void main(String[] args) {
		
		MThreadPro thread = new MThreadPro();
		//thread.start();
		thread.t.start();
		// thread.run();
		for(int i=1; i<=1000; i++) {
			System.out.println("Main : " + i);
		}
		System.out.println("Main Terminated");
	}
}

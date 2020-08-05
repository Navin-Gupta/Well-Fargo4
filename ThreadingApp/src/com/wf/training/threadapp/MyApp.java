package com.wf.training.threadapp;

class MThread extends Thread{
	@Override
	public void run() {
		// System.out.println("Run : " + Thread.currentThread());
		//Thread.currentThread().setName("");
		//Thread.currentThread().setPriority(7);
		/*for(int i=1; i<=1000; i++) {
			System.out.println("Run : " + i);
		}*/
		int i =1;
		while(true) {
			System.out.println("Run : " + i);
			i++;
		}
	}
}

public class MyApp {

	public static void main(String[] args) {
		// launched as thread
		// returns an instance of thread under which current method is running
		System.out.println("Main : " + Thread.currentThread());
		MThread thread = new MThread();
		thread.setDaemon(true); // terminate auto as soon as parent thread terminate
		thread.start();
		// thread.run();
		for(int i=1; i<=1000; i++) {
			System.out.println("Main : " + i);
		}
		System.out.println("Main Terminated");
	}

}

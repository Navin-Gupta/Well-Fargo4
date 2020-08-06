package com.wf.training.comm.pro;


class Box{
	
	private int count;
	public Box() {
		this.count = 0;
	}
	
	synchronized public void put() {
		if(this.count>0) {
			// wait for product to consumed
			try {
				// Object
				// wait(); // block the thread : releases the lock
				wait(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// logical check
		if(this.count > 0) {}
		this.count++; // put into box
		System.out.println("Produced :" + count);
		// send a comm message to other thread
		// notify();
		notifyAll();
	}
	
	synchronized public void get() {
		if(count == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.count--; // get the product
		System.out.println("Consumed :" + count);
		// send a comm message to other thread
		notify();
	}
	
}

class Producer extends Thread{
	
	private Box box;
	
	public Producer(Box box) {
		this.box = box;
	}
	
	@Override
	public void run() {
		while(true) {
			// produce a product
			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// put product into box
			this.box.put();
		}
	}
}

class Consumer extends Thread{
	
	private Box box;
	
	public Consumer(Box box) {
		this.box = box;
	}
	
	@Override
	public void run() {
		while(true) {
			// get product from box
			this.box.get();
			
			// consume a product
			try {
				Thread.sleep(120);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class MyAppPro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box box = new Box();
		Producer producer = new Producer(box);
		Consumer consumer = new Consumer(box);
		
		producer.start();
		consumer.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Done Testing....");
	}

}

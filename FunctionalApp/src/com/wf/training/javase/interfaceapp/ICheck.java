package com.wf.training.javase.interfaceapp;

public interface ICheck {
	public void fun();
	
	// default methods
	default public void test() {
		System.out.println("Default method of interface");
	}
	
	static void sfun() {
		System.out.println("Static function of interface");
	}

}

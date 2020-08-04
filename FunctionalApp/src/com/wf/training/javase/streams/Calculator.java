package com.wf.training.javase.streams;

public class Calculator {
	private int result;
	
	// addition
	public void performSum(int value) {
		result += value;
	}
	
	public int getResult() {
		return this.result;
	}
	public void setResult(int result) {
		this.result = result;
	}
}

package com.wf.training.javase.streams;

import java.util.stream.IntStream;

public class CalculatorClient {

	public static void main(String args[]) {
	
		Calculator calculator = new Calculator();
		/*
		// sequential stream
		IntStream.rangeClosed(1, 1000) // stream of number from 1 to 1000
			// passing each value of stream to calculator
			.forEach(value -> calculator.performSum(value));
		System.out.println("Sequential Sum : " + calculator.getResult());
		*/
		
		// parallel stream
		IntStream.rangeClosed(1, 1000).parallel() // stream of number from 1 to 1000
			// passing each value of stream to calculator
			.forEach(value -> calculator.performSum(value));
		System.out.println("Parallel Sum : " + calculator.getResult());
	}
}

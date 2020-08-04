package com.wf.training.javase.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InherentlyComplex {

	public static int sequentialSum(List<Integer> numbers) {
		
		long start = System.currentTimeMillis();
		
		int total = numbers.stream() // Stream<Integer>
				.reduce(0, (x,y) -> x+y);  // Integer -> int (unboxing)
		// initial value of x : 0
		// x , y (value coming from stream)
		// returned value : x
		
		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println("Sequential  :  " + diff);
		
		return total;
	}
	
	public static int parallelSum(List<Integer> numbers) {
		
		long start = System.currentTimeMillis();
		
		// parallel values coming : JVM places them into buffer
		// then uses in sequential 
		int total = numbers.parallelStream() 
				.reduce(0, (x,y) -> x+y);
		// initial value of x : 0
		// x , y (value coming from stream)
		// returned value : x
		
		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println("Parallel:  " + diff);
		
		return total;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// generate a collection of number from 1--1000
		List<Integer> numbers =  IntStream.rangeClosed(1, 1000)  // stream<int>
				.boxed()  // Stream <Integer>
				.collect(Collectors.toList());
			
		System.out.println("Sequential Sum : " + sequentialSum(numbers));
		System.out.println("Parallel Sum : " + parallelSum(numbers));
	}

}

package com.wf.training.javase.stylecomparision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Remove duplicates from list of int
		List<Integer> numbers = Arrays.asList(1,2,3,4,4,4,5,5,6,7,7,7,8,9,9);
		
		// imperative style
		List<Integer> uniqueNumbers = new ArrayList<Integer>();
		for(Integer num : numbers) {
			if(!uniqueNumbers.contains(num))
				uniqueNumbers.add(num);
		}
		
		// numbers.forEach(action);
		
		System.out.println("Unique Values : " + uniqueNumbers);
		
		// Declarative style
		List<Integer> uniqueNumbersPro = 
				numbers.stream().distinct().collect(Collectors.toList());
		
		System.out.println("Unique Values : " + uniqueNumbersPro);
		
		
	}

}

package com.wf.training.javase.functionalapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

class MyIntConsumer implements Consumer<Integer>{

	// void println(String)
	@Override
	public void accept(Integer name) {
		// TODO Auto-generated method stub
		System.out.println(name);
		fun();
	}
	
	public void fun() {
		
	}
}



class MyConsumer implements Consumer<String>{

	// void println(String)
	@Override
	public void accept(String name) {
		// TODO Auto-generated method stub
		System.out.println(name);
		fun();
	}
	
	public void fun() {
		
	}
}

public class MyApp {

	public static Consumer<String> nameConsumer= name -> System.out.println(name);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<String>();
		names.add("First");
		names.add("Second");
		names.add("Third");
		names.add("Fourth");
		
		// counter based looping
		/*for(int i=0;i<names.size();i++) {
			System.out.println(names.get(i));
		}*/
		
		// enhanced for loop based
		/*for(String name : names) {
			System.out.println(name);
		}*/
		
		// collection iterator way
		/*Iterator<String> iterator = names.iterator();
		while(iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);
		}*/
		
		
		
		// OO way
		// names.forEach(new MyConsumer());
		
		// Functional approach
		// lambda
		// names.forEach(nameConsumer);
		
		// inject lambda
		// names.forEach(name -> System.out.println(name));
		
		// method reference
		names.forEach(System.out::println); // 
		//names.forEach(new MyIntConsumer());;
	}

}

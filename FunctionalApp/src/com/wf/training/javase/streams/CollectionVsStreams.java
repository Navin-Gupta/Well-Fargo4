package com.wf.training.javase.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CollectionVsStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<String>();
		names.add("First");
		names.add("Second");
		names.add("Third");
		names.add("Fourth");
		
		// directly using a collection
		names.forEach(System.out::println);
		names.forEach(System.out::println);
		
		
		System.out.println("------------------------");
		// create a processing platform
		// tell the system to place the read-only content on platform
		Stream<String> namesStream = names.stream();
		namesStream.forEach(System.out::println);
		// not reusable...
		namesStream = names.stream();
		namesStream.forEach(System.out::println);
	}

}

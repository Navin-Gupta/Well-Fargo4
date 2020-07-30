package com.wf.training.javase.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.ws.training.javase.repository.Student;
import com.ws.training.javase.repository.StudentRepository;

public class ParallelStream {
	
	static Predicate<Student> gradePredicate =
			 student -> student.getGrade() > 2; // return is by default
			 
	static Predicate<Student> gpaPredicate =
			 student -> student.getGpa() >= 3.5; // return is by default	

	public static Map<String, List<String>>  sequentialStream() {
		long start = System.currentTimeMillis();
		
		Map<String, List<String>> studentMap =  StudentRepository.getStudents()
				.stream().peek(student->System.out.println("Initiated :" + student))
				// only that data that passes the predicate (return true)
				.filter(gradePredicate).peek(student->System.out.println("Ist Filter :" + student))
				.filter(gpaPredicate).peek(student->System.out.println("IInd Filter :" + student))
				.collect(Collectors.toMap(student-> student.getName() , student -> student.getActivities()));
		
		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println("Sequential : " + diff);
		
		return studentMap;
	}
	
	public static Map<String, List<String>>  parallelStream() {
		
		long start = System.currentTimeMillis();
		
		Map<String, List<String>> studentMap =  StudentRepository.getStudents()
				.parallelStream().peek(student->System.out.println("Initiated :" + student))
				// only that data that passes the predicate (return true)
				.filter(gradePredicate).peek(student->System.out.println("Ist Filter :" + student))
				.filter(gpaPredicate).peek(student->System.out.println("IInd Filter :" + student))
				.collect(Collectors.toMap(student-> student.getName() , student -> student.getActivities()));
		
		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println("Parallel : " + diff);
		
		
		return studentMap;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Sequential Stream : " + sequentialStream());
		
		System.out.println("\n\n-------------------------\n\n");
		System.out.println("Parallel Stream : " + parallelStream());
		

	}

}

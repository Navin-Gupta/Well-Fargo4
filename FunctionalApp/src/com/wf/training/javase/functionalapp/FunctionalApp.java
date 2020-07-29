package com.wf.training.javase.functionalapp;

import java.util.function.Consumer;

import com.ws.training.javase.repository.Student;
import com.ws.training.javase.repository.StudentRepository;

public class FunctionalApp {

	// void accept(Student)
	static Consumer<Student> nameDisplayLambda =
			 student -> System.out.println(student.getName());
			 
	static Consumer<Student> activityDisplayLambda =
					 student -> System.out.println(student.getActivities());			 
	
	// display names of all student
	public static void displayNames() {
		// StudentRepository.getStudents().forEach(System.out::println);
		StudentRepository.getStudents().forEach(nameDisplayLambda);
		// System.out.println(student.toString()); // default Student@<ref id>
	}
	
	// display activities of all student
	public static void displayActivities() {
		
		StudentRepository.getStudents().forEach(activityDisplayLambda);
	}
	
	// display name and activities of all student
	public static void displayNameAndActivities() {
		
		StudentRepository.getStudents().forEach(nameDisplayLambda.andThen(activityDisplayLambda));
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// displayNames();
		// displayActivities();
		displayNameAndActivities();
	}

}

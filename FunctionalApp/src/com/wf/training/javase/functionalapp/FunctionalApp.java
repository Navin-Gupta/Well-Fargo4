package com.wf.training.javase.functionalapp;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.ws.training.javase.repository.Student;
import com.ws.training.javase.repository.StudentRepository;

public class FunctionalApp {
	

	// void accept(Student)
	static Consumer<Student> nameDisplayLambda =
			 student -> System.out.println(student.getName());
			 
	static Consumer<Student> activityDisplayLambda =
					 student -> System.out.println(student.getActivities());			 
	
	static Predicate<Student> gradePredicate =
					 student -> student.getGrade() > 2; // return is by default
					 
	static Predicate<Student> gpaPredicate =
					 student -> student.getGpa() >= 3.5; // return is by default				 
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
	
	// display name and activities of those students who are in grade > 2
	public static void displayNameAndActivitiesConditional() {
		
		StudentRepository.getStudents().forEach(student->{
				// if(student.getGrade() > 2 && student.getGpa() >=3.5) {
				// if(gradePredicate.test(student)) {
				if(gradePredicate.and(gpaPredicate).test(student)) {
					// explicitly
					nameDisplayLambda.accept(student);
					activityDisplayLambda.accept(student);
					// nameDisplayLambda.andThen(activityDisplayLambda).accept(student);
					// <object>.<method>
				}
		});
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// displayNames();
		// displayActivities();
		// displayNameAndActivities();
		displayNameAndActivitiesConditional();
	}

}

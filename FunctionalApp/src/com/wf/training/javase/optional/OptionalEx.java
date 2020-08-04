package com.wf.training.javase.optional;

import java.util.Optional;

import com.ws.training.javase.repository.Student;

public class OptionalEx {

	public static Student getStudentData() {
		// some logic to return a student object
		Student student = null;
		return student;
	}
	
	public static  Optional<Student> getStudentDataOptional() {
		// some logic to return a student object
		Student student = null;
		// can hold null value as well
		Optional<Student> studentOptional = Optional.ofNullable(student);
		return studentOptional;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// expecting to get student data back
		Student student = getStudentData();
		if(student != null) {
			// display student name
			System.out.println("NAME : " + student.getName());
		}
		
		Optional<Student> studentOptional =  getStudentDataOptional();
		if(studentOptional.isPresent()) {
			// studentOptional.get();
			// Optional<String> name = studentOptional.map(stud-> stud.getName());
			// String name = studentOptional.map(stud-> stud.getName()).orElse("Default");
			// String name = studentOptional.map(stud-> stud.getName()).orElseGet(()-> "Default");
			String name = studentOptional.map(stud-> stud.getName()).orElseThrow(()-> new RuntimeException("No data found"));
		}
	}

}

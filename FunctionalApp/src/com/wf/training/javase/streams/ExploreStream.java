package com.wf.training.javase.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.activation.MailcapCommandMap;

import com.ws.training.javase.repository.Student;
import com.ws.training.javase.repository.StudentRepository;

public class ExploreStream {

	static Predicate<Student> gradePredicate =
			 student -> student.getGrade() > 2; // return is by default
			 
	static Predicate<Student> gpaPredicate =
			 student -> student.getGpa() >= 3.5; // return is by default	
			 
	static Consumer<Student> nameDisplayLambda =
			 student -> System.out.println(student.getName());
			 
	static Consumer<Student> activityDisplayLambda =
					 student -> System.out.println(student.getActivities());			 			 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*StudentRepository.getStudents()
				.stream()
				// only that data that passes the predicate (return true)
				// .filter(gradePredicate)
				.filter(gradePredicate.and(gpaPredicate))
				.forEach(nameDisplayLambda.andThen(activityDisplayLambda));
		*/
		/*List<Student> filteredStudent = StudentRepository.getStudents()
				.stream().peek(student->System.out.println("Initiated :" + student))
				// only that data that passes the predicate (return true)
				.filter(gradePredicate).peek(student->System.out.println("Ist Filter :" + student))
				.filter(gpaPredicate).peek(student->System.out.println("IInd Filter :" + student))
				.count();
				// .collect(Collectors.toList());
				
		System.out.println(filteredStudent);*/
		
		 Map<String, List<String>> studentMap =  StudentRepository.getStudents()
				.stream().peek(student->System.out.println("Initiated :" + student))
				// only that data that passes the predicate (return true)
				.filter(gradePredicate).peek(student->System.out.println("Ist Filter :" + student))
				.filter(gpaPredicate).peek(student->System.out.println("IInd Filter :" + student))
				.collect(Collectors.toMap(student-> student.getName() , student -> student.getActivities()));
				
		System.out.println(studentMap);
		
		
		System.out.println("-----------------------------------------");
		
		StudentRepository.getStudents()
				.stream().peek(student->System.out.println("Initiated :" + student))
				// only that data that passes the predicate (return true)
				.filter(gradePredicate).peek(student->System.out.println("Ist Filter :" + student))
				.filter(gpaPredicate).peek(student->System.out.println("IInd Filter :" + student));
				// .collect(Collectors.toList());
			
		
				
	}

}

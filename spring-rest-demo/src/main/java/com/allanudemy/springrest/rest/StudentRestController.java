package com.allanudemy.springrest.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allanudemy.springrest.entities.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	//define endpoint for "/students" - return list of students
	private List<Student> theStudents = new ArrayList<>();
	
	//called only once when the data is constructed
	@PostConstruct
	public void loadData() {
		List<Student> theStudents = new ArrayList<>();
		theStudents.add(new Student(1, "Susan","Boyle",true));
		theStudents.add(new Student(2, "Manik","Daree",true));
		theStudents.add(new Student(3, "Abran","Link",true));
		theStudents.add(new Student(4, "Trump","Orange",false));
	}

	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
	}
	
	@GetMapping("students/{studentId}")
	public Student getStudent (@PathVariable int studentId) {
		
		return theStudents.get(studentId-1);
	}
}

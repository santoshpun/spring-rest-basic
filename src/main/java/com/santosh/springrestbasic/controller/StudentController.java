package com.santosh.springrestbasic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santosh.springrestbasic.component.StudentStore;
import com.santosh.springrestbasic.dto.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentStore studentStore;

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> students = studentStore.getAllStudents();
		return new ResponseEntity<List<Student>>(students, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getEmployeeById(@PathVariable("id") int id) {
		Student student = studentStore.getStudentById(id);
		return new ResponseEntity<Student>(student, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student studentObj = studentStore.addStudent(student);
		return new ResponseEntity<Student>(studentObj, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("delete/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") int id) {
		studentStore.deleteStudent(id);
		return HttpStatus.OK;
	}

}

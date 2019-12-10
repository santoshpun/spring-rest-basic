package com.santosh.springrestbasic.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.santosh.springrestbasic.dto.Student;

@Component
public class StudentStore {

	private List<Student> students = new ArrayList<>();

	public List<Student> getAllStudents() {
		return this.students;
	}

	public Student addStudent(Student student) {
		boolean alreadyAdded = false;

		for (Student studentObj : students) {
			if (studentObj.getId() == student.getId()) {
				alreadyAdded = true;
			}
		}

		if (!alreadyAdded) {
			this.students.add(student);
		}

		return student;
	}

	public Student getStudentById(int id) {
		Student obtainedStudent = null;
		for (Student studentObj : students) {
			if (studentObj.getId() == id) {
				obtainedStudent = studentObj;
			}
		}
		return obtainedStudent;
	}

	public void deleteStudent(int id) {
		List<Student> studentList = new ArrayList<>();
		for (Student studentObj : students) {
			if (studentObj.getId() != id) {
				studentList.add(studentObj);
			}
		}

		this.students = studentList;
	}

}

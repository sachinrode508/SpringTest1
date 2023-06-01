package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {

	List<Student> getStudent();

	Student getStudentByRollNO(long rollno);

	Student addStudentDetails(Student student);

	void deleteStudentByRollNO(long parseLong);

}

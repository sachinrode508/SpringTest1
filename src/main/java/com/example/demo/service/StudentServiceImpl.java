package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.example.demo.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	List<Student> list;

	public StudentServiceImpl() {
		list = new ArrayList<Student>();
		list.add(new Student(101, "sachin", "pune"));
		list.add(new Student(102, "mahesh", "mumbai"));
	}

	@Override
	public List<Student> getStudent() {
		return list;
	}

	@Override
	public Student getStudentByRollNO(long rollno) {
		Student s = null;
		for (Student student : list) {
			if (student.getRollNo() == rollno) {
				s = student;
				break;
			}

		}
		return s;
	}

	@Override
	public Student addStudentDetails(Student student) {
		list.add(student); 
		return student;
	}

	@Override
	public void deleteStudentByRollNO(long parseLong) {
			list=this.list.stream().filter(e->e.getRollNo()!=parseLong).collect(Collectors.toList());
	}
		

}

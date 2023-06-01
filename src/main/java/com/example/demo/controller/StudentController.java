package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/test")
public class StudentController {

	@Autowired
	public StudentService studentService;

	// simple method
	// @RequestMapping(value = "/getData",method=RequestMethod.GET)
	@GetMapping("/test1")
	public String test1() {
		return "Hello Sachin";
	}

	// collection list
	@GetMapping("/test2")
	public List<String> test2() {
		List<String> l1 = new ArrayList<String>();
		l1.add("sachin");
		l1.add("mahesh");
		l1.add("akash");
		return l1;
	}

//	//user defined collection list
//	@GetMapping("/getStudentDetails")
//	public List<Student> getStudentDetails()
//	{
//		Student student1=new Student();
//		student1.setRollNo(11);
//		student1.setName("sachin");
//		student1.setCity("pune");
//		
//		Student student2=new Student();
//		student2.setRollNo(12);
//		student2.setName("mahesh");
//		student2.setCity("pune");
//	
//		List<Student> l1=new ArrayList<Student>();
//		l1.add(student1);
//		l1.add(student2);
//		return l1;
//	}

//================================================================================================
	// method for display student data(Get)
	@GetMapping("/getStudentDetails")
	public List<Student> getStudentDetails() {
		return this.studentService.getStudent();
	}

	// method for search student data by rollNo(Get)
	@GetMapping("/getStudentDetailsByRollNo/{rollno}")
	public Student getStudentDetailsByRollNo(@PathVariable String rollno) {
		return this.studentService.getStudentByRollNO(Long.parseLong(rollno));
	}

	// method for add student data(Post)
	// @PostMapping(path="/addStudentDetails",consumes="application/json")
	@PostMapping("/addStudentDetails")
	public Student addStudentDetails(@RequestBody Student student) {
		return this.studentService.addStudentDetails(student);
	}

	// method for delete student data(Delete)
	@DeleteMapping("deleteStudentDetailsByRollNo/{rollno}")
	public ResponseEntity<HttpStatus> deleteStudentDetailsByRollNo(@PathVariable String rollno) {
		try {
			this.studentService.deleteStudentByRollNO(Long.parseLong(rollno));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}

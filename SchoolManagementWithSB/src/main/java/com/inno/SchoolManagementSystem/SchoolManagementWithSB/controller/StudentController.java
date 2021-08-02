package com.inno.SchoolManagementSystem.SchoolManagementWithSB.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Student;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Teacher;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.service.StudentService;

@RestController
@RequestMapping("school/student")
public class StudentController {

	public StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@PostMapping(path = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> register(@RequestBody Map<String, String> map) {
		Student student = new Student();
		student.setRollNo(map.get("rollNo"));
		student.setGrade(Integer.parseInt(map.get("grade")));
		student.setSection(map.get("section"));
		student.setName(map.get("name"));
		student.setAge(Integer.parseInt(map.get("age")));
		student.setGender(map.get("gender"));
		student.setContactNo(map.get("contactNo"));
		student.setAddress(map.get("address"));
		if (studentService.registerStudent(student) == 1)
			return ResponseEntity.ok("Registered Successfully ");
		else
			return ResponseEntity.ok("Something Went wrong");
	}

	@PostMapping(path = "delete", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteStudent(@RequestBody Map<String, String> map) {
		Student student = new Student();
		student.setRollNo(map.get("rollNo"));

		if (studentService.deleteStudent(student) == 1)
			return ResponseEntity.ok("Deleted Student successfully");
		else
			return ResponseEntity.ok("Something Went Wrong");
	}

	@PostMapping(path = "updateGrade", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateGrade(@RequestBody Map<String, String> map) {
		if (studentService.updateGrade(map.get("rollNo"), Integer.parseInt(map.get("grade"))) == 1)
			return ResponseEntity.ok("Updated grade Successfully ");
		else
			return ResponseEntity.ok("Something Went Wrong");
	}

	@PostMapping(path = "updateSection", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateSection(@RequestBody Map<String, String> map) {
		if (studentService.updateSection(map.get("rollNo"), map.get("section")) == 1)
			return ResponseEntity.ok("Updated section Successfully ");
		else
			return ResponseEntity.ok("Something Went Wrong");
	}
	@PostMapping(path = "updateName", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateName(@RequestBody Map<String, String> map)
	{
		if(studentService.updateName(map.get("rollNo"), map.get("name"))==1)
			return ResponseEntity.ok("Updated name Successfully ");
		else
			return ResponseEntity.ok("Something Went Wrong");
	}
	@PostMapping(path = "updateAge", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateAge(@RequestBody Map<String, String> map)
	{
		if(studentService.updateAge(map.get("rollNo"), Integer.parseInt(map.get("age")))==1)
			return ResponseEntity.ok("Updated Age Successfully ");
		else
			return ResponseEntity.ok("Something Went Wrong");
	}
	@PostMapping(path = "updateAddress", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateAddress(@RequestBody Map<String, String> map)
	{
		if(studentService.updateAddress(map.get("rollNo"), map.get("address"))==1)
			return ResponseEntity.ok("Updated Address Successfully ");
		else
			return ResponseEntity.ok("Something Went Wrong");
	}
	@PostMapping(path = "updateContactNo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateContactNo(@RequestBody Map<String, String> map)
	{
		if(studentService.updateContactNo(map.get("rollNo"), map.get("contactNo"))==1)
			return ResponseEntity.ok("Updated contactNo Successfully ");
		else
			return ResponseEntity.ok("Something Went Wrong");
	}


}

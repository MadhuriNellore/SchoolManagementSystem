package com.inno.SchoolManagementSystem.SchoolManagementWithSB.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	@Autowired
	public StudentService studentService;
	@PostMapping(path = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String register(@RequestBody Map<String, String> map)
	{
		Student student = new Student();
		student.setRollNo(map.get("rollNo"));
		student.setGrade(Integer.parseInt(map.get("grade")));
		student.setSection(map.get("section"));
		student.setName(map.get("name"));
		student.setAge(Integer.parseInt(map.get("age")));
		student.setGender(map.get("gender"));
		student.setContactNo(map.get("contactNo"));
		student.setAddress(map.get("address"));
		if(studentService.registerStudent(student)==1)
			return "Registered Successfully ";
		else
			return "Something error";
	}
	@PostMapping(path = "delete", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public String deleteStudent(@RequestBody Map<String, String> map)
	{
		Student student = new Student();
		student.setRollNo(map.get("rollNo"));
		
		if(studentService.deleteStudent(student)==1)
			return "Deleted Student successfully"; 
		else
			return "Something Went Wrong";
	}
	@PostMapping(path = "updateGrade", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateGrade(@RequestBody Map<String, String> map)
	{
		if(studentService.updateGrade(map.get("rollNo"), Integer.parseInt(map.get("grade")))==1)
			return "Updated grade Successfully ";
		else
			return "Something error";
	}
	@PostMapping(path = "updateSection", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateSection(@RequestBody Map<String, String> map)
	{
		if(studentService.updateSection(map.get("rollNo"), map.get("section"))==1)
			return "Updated section Successfully ";
		else
			return "Something error";
	}
}

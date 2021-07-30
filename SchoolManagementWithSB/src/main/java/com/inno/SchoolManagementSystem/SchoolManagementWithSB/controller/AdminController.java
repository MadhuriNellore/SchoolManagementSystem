package com.inno.SchoolManagementSystem.SchoolManagementWithSB.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Employee;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.EmployeeAttendance;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.service.AdminService;

@RestController
@RequestMapping("school/admin")
public class AdminController {
	
	private final AdminService adminService;
	
	
	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	//jdbc Template
	@PostMapping(path = "studentDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Map<String, Object>> getStudents()
	{
		return adminService.viewStudents();
	}
	@PostMapping(path = "teacherDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Map<String, Object>> getTeachers()
	{
		return adminService.viewTeachers();
	}
	}

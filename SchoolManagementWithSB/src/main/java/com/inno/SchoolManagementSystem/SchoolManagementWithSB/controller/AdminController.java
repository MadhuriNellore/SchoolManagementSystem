package com.inno.SchoolManagementSystem.SchoolManagementWithSB.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Employee;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.EmployeeAttendance;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.StudentsAccounts;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.service.AdminService;

@RestController
@RequestMapping("school/admin")
public class AdminController {
	private final AdminService adminService;

	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}

	// jdbc Template
	@PostMapping(path = "studentDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Map<String, Object>> getStudents() {
		return adminService.viewStudents();
	}

	@PostMapping(path = "teacherDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Map<String, Object>> getTeachers() {
		return adminService.viewTeachers();
	}

	@PostMapping(path = "empAttendance", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeAttendance> getEmployeeAttendance() {
		return adminService.getEmployeeAttendance();
	}

	@GetMapping(path = "attendance/date", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Collection<EmployeeAttendance> getAttendanceByDate(@RequestParam String entryDate) {
		return adminService.getAttendanceByDate(entryDate);
	}

	@GetMapping(path = "attendance/id", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Collection<EmployeeAttendance> getAttendanceByID(@RequestParam String empId) {
		return adminService.findByID(empId);
	}

	@GetMapping(path = "attendance/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteAttendanceById(@RequestParam long empAttendanceId) {
		try {
			adminService.deleteAttendanceById(empAttendanceId);
			return ResponseEntity.ok("Deleted attendance record Successfully");
		} catch (RuntimeException re) {
			System.out.println(re);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(re.getMessage());
		}
	}
	@PostMapping(path = "studentsAccounts", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<StudentsAccounts> getStudentsAccounts() {
		return adminService.getStudentsAccounts();
	}
	@GetMapping(path = "accounts/id", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Optional<StudentsAccounts> getAccountsByID(@RequestParam String rollNo) {
		return adminService.findByRollNo(rollNo);
	}
}

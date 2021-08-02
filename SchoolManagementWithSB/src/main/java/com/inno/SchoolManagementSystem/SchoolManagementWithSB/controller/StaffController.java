package com.inno.SchoolManagementSystem.SchoolManagementWithSB.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.EmployeeAttendance;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Staff;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.service.StaffService;

@RestController
@RequestMapping("school/staff")
public class StaffController {
	private final StaffService staffService;

	public StaffController(StaffService staffService) {
		super();
		this.staffService = staffService;
	}
	
	@PostMapping(path = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> registerStaff(@RequestBody Map<String, String> map) {
		Staff staff = new Staff();
		staff.setEmpID(Long.parseLong(map.get("empId")));
		staff.setDepartment(map.get("department"));
		staff.setSalary(Long.parseLong(map.get("salary")));
		try {
			Date joinDate = new SimpleDateFormat("dd/mm/yyyy").parse(map.get("joinDate"));
			staff.setJoinDate(joinDate);
		} catch (Exception e) {
			System.out.println(e);
		}
		staff.setDesignation(map.get("designation"));
		staff.setWorktype(map.get("workType"));
		staff.setName(map.get("name"));
		staff.setAge(Integer.parseInt(map.get("age")));
		staff.setGender(map.get("gender"));
		staff.setContactNo(map.get("contactNo"));
		staff.setAddress(map.get("address"));
		if (staffService.registerStaff(staff) == 1)
			return ResponseEntity.ok("Staff Registered Successfully ");
		else
			return ResponseEntity.ok("Something went Wrong");
	}

	@PostMapping(path = "delete", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteStaff(@RequestBody Map<String, String> map) {
		Staff staff = new Staff();
		staff.setEmpID(Long.parseLong(map.get("empId")));
		if (staffService.deleteStaff(staff) == 1)
			return ResponseEntity.ok("Deleted successfully");
		else
			return ResponseEntity.ok("Something Went Wrong");
	}

	@PostMapping(path = "updateSalary", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateSalary(@RequestBody Map<String, String> map) {
		if (staffService.updateSalary(Long.parseLong(map.get("empId")), Long.parseLong(map.get("salary"))) == 1)
			return ResponseEntity.ok("updated Salary Successfully");
		else
			return ResponseEntity.ok("Something went wrong");
	}

	@PostMapping(path = "updateName", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateName(@RequestBody Map<String, String> map)
	{
		if(staffService.updateName(Long.parseLong(map.get("empId")), map.get("name"))==1)
			return ResponseEntity.ok("Updated name Successfully ");
		else
			return ResponseEntity.ok("Something Went Wrong");
	}
	@PostMapping(path = "updateAge", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateAge(@RequestBody Map<String, String> map)
	{
		if(staffService.updateAge(Long.parseLong(map.get("empId")), Integer.parseInt(map.get("age")))==1)
			return ResponseEntity.ok("Updated Age Successfully ");
		else
			return ResponseEntity.ok("Something Went Wrong");
	}
	@PostMapping(path = "updateAddress", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateAddress(@RequestBody Map<String, String> map)
	{
		if(staffService.updateAddress(Long.parseLong(map.get("empId")), map.get("address"))==1)
			return ResponseEntity.ok("Updated Address Successfully ");
		else
			return ResponseEntity.ok("Something Went Wrong");
	}
	@PostMapping(path = "updateContactNo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateContactNo(@RequestBody Map<String, String> map)
	{
		if(staffService.updateContactNo(Long.parseLong(map.get("empId")), map.get("contactNo"))==1)
			return ResponseEntity.ok("Updated contactNo Successfully ");
		else
			return ResponseEntity.ok("Something Went Wrong");
	}

}

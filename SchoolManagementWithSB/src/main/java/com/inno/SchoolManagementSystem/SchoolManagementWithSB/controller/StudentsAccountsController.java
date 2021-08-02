package com.inno.SchoolManagementSystem.SchoolManagementWithSB.controller;

import java.sql.Time;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.EmployeeAttendance;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.StudentsAccounts;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.service.StudentsAccountsService;

@RestController
@RequestMapping("school/accounts")
public class StudentsAccountsController {
	private final StudentsAccountsService studentsAccountsService;

	public StudentsAccountsController(StudentsAccountsService studentsAccountsService) {
		super();
		this.studentsAccountsService = studentsAccountsService;
	}
	@PostMapping(path = "feeStructure", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> setFeeStructure(@RequestBody StudentsAccounts studentsAccounts) {
	studentsAccountsService.setfeeStructure(studentsAccounts);
	return ResponseEntity.ok("Fee Structure Updated Successful");
	}
	@PostMapping(path = "feepaid", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateFeePaid(@RequestBody StudentsAccounts studentsAccounts) {
		studentsAccountsService.updateFeePaid(studentsAccounts);
		return ResponseEntity.ok("Updated fee paid Successfully");
	}
}

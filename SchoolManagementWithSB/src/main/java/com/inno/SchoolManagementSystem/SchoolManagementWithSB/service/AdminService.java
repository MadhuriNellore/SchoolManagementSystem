package com.inno.SchoolManagementSystem.SchoolManagementWithSB.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Employee;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.EmployeeAttendance;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository.AdminRepository;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository.EmployeeAttendanceRepository;

@Service
public class AdminService {
	
	private final AdminRepository adminRepository;
		
	public AdminService(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	//jdbcTemplate
	public List<Map<String, Object>> viewStudents()
	{
		return adminRepository.getStudentRecords();
	}
	
	public List<Map<String, Object>> viewTeachers()
	{
		return adminRepository.getTeacherRecords();
	}
		
}

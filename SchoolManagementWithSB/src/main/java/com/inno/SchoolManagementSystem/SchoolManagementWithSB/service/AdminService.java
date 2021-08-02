package com.inno.SchoolManagementSystem.SchoolManagementWithSB.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Employee;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.EmployeeAttendance;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.StudentsAccounts;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository.AdminRepository;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository.EmployeeAttendanceRepository;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository.StudentsAccountsRepository;

@Service
public class AdminService {

	private final AdminRepository adminRepository;
	private final EmployeeAttendanceRepository employeeAttendanceRepository;
private final StudentsAccountsRepository studentsAccountsRepository;

	public AdminService(AdminRepository adminRepository, EmployeeAttendanceRepository employeeAttendanceRepository,
		StudentsAccountsRepository studentsAccountsRepository) {
	super();
	this.adminRepository = adminRepository;
	this.employeeAttendanceRepository = employeeAttendanceRepository;
	this.studentsAccountsRepository = studentsAccountsRepository;
}

	// jdbcTemplate
	public List<Map<String, Object>> viewStudents() {
		return adminRepository.getStudentRecords();
	}

	public List<Map<String, Object>> viewTeachers() {
		return adminRepository.getTeacherRecords();
	}

	public List<EmployeeAttendance> getEmployeeAttendance() {
		List<EmployeeAttendance> list = new ArrayList<EmployeeAttendance>();
		employeeAttendanceRepository.findAll().forEach(list::add);
		return list;
	}
	// get attendance by date
		public Collection<EmployeeAttendance> getAttendanceByDate(String entryDate) {
			return employeeAttendanceRepository.getAttendanceByDate(entryDate);
		}

	//attendance by id
		public Collection<EmployeeAttendance> findByID(String empID) {
			return employeeAttendanceRepository.getByID(empID);
		}
		public void deleteAttendanceById(long empAttendanceId)
		{
			employeeAttendanceRepository.deleteById(empAttendanceId);
		}
		//view students accounts
		public List<StudentsAccounts> getStudentsAccounts() {
			List<StudentsAccounts> list = new ArrayList<StudentsAccounts>();
			studentsAccountsRepository.findAll().forEach(list::add);
			return list;
		}
		//students fee accounts by id
		//attendance by id
		public Optional<StudentsAccounts> findByRollNo(String rollNo) {
			return studentsAccountsRepository.getByID(rollNo);
		}
}

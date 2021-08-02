package com.inno.SchoolManagementSystem.SchoolManagementWithSB.service;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.EmployeeAttendance;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Student;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Teacher;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository.EmployeeAttendanceRepository;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository.StudentRepository;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository.TeacherRepository;

@Service
public class TeacherService {
	private final TeacherRepository teacherRepository;
	private final RestTemplate restTemplate;
	private final EmployeeAttendanceRepository employeeAttendanceRepository;

	public TeacherService(TeacherRepository teacherRepository, RestTemplate restTemplate,
			EmployeeAttendanceRepository employeeAttendanceRepository) {
		super();
		this.teacherRepository = teacherRepository;
		this.restTemplate = restTemplate;
		this.employeeAttendanceRepository = employeeAttendanceRepository;
	}

	// JPA
	// save the login details
	public void login(EmployeeAttendance employeeAttendance) throws RuntimeException {
		System.out.println(
				"EmployeeID: " + employeeAttendance.getEmpId() + "\nLogin Time: " + employeeAttendance.getLoginTime());
		
		 ResponseEntity<String> entity =
		 restTemplate.postForEntity("http://localhost:8083/school/teacher/login",
		  employeeAttendance, String.class);
		  System.out.println("Making a call to service running on 8083");
		  System.out.println(entity.getBody());
		 
		employeeAttendanceRepository.save(employeeAttendance);
	}

	// save the logout details
	@Transactional
	public void logout(EmployeeAttendance employeeAttendance) {

		employeeAttendanceRepository.updateLogoutTime(employeeAttendance.getLogoutTime(), employeeAttendance.getEmpId(),
				employeeAttendance.getEntryDate());
	}

	// Registering teacher records
	public int registerTeacher(Teacher teacher) {
		return teacherRepository.addTeacher(teacher);
	}

	// Deleting teacher records
	public int deleteTeacher(Teacher teacher) {
		return teacherRepository.deleteTeacher(teacher);
	}

	public int updateSalary(long empId, long salary) {
		Teacher teacher = new Teacher();
		teacher.setSalary(salary);
		System.out.println("Emp id : " + empId + "Updated Salary: " + teacher.getSalary());
		return teacherRepository.updateSalary(empId, salary);
	}

	public int updateSpecialization(long empId, String Specialization) {
		Teacher teacher = new Teacher();
		teacher.setSpecialization(Specialization);
		System.out.println("Emp id : " + empId + " Updated Specialization: " + teacher.getSpecialization());
		return teacherRepository.updateSpecialization(empId, Specialization);
	}
	public int updateName(long empId, String name) {
		Teacher teacher = new Teacher();
		teacher.setName(name);
		return teacherRepository.updateName(empId, name);
	}
	public int updateAge(long empId, int age)  {
		Teacher teacher = new Teacher();
		teacher.setAge(age);
		return teacherRepository.updateAge(empId, age);
	}
	public int updateAddress(long empId, String address)  {
		Teacher teacher = new Teacher();
		teacher.setAddress(address);
		return teacherRepository.updateAddress(empId, address);
	}
	public int updateContactNo(long empId, String contactNo) {
		Teacher teacher = new Teacher();
		teacher.setContactNo(contactNo);	
		return teacherRepository.updateContactNo(empId, contactNo);
	}

}

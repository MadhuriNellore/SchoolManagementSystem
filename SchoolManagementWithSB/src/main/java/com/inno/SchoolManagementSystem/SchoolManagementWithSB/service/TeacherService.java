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

import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.EmployeeAttendance;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Student;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Teacher;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository.EmployeeAttendanceRepository;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository.StudentRepository;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository.TeacherRepository;

@Service
public class TeacherService {
	@Autowired
	public TeacherRepository teacherRepository;
	@Autowired
	public EmployeeAttendanceRepository employeeAttendanceRepository;

	// JPA
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
	    public Optional<EmployeeAttendance> findByID(String empID) {
	        return employeeAttendanceRepository.getByID(empID);
	    }

	// JPA
	// save the login details
	 public void login(EmployeeAttendance employeeAttendance) {
	        System.out.println("EmployeeID: " + employeeAttendance.getEmpId() + "\nLogin Time: " + employeeAttendance.getLoginTime());
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
}

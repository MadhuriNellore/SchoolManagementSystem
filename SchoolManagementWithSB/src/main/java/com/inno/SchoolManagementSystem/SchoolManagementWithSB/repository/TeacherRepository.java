package com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Student;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Teacher;

@Repository
public class TeacherRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addTeacher(Teacher teacher) {

		String query = "Insert into Teachers values(?,?,?,?,?,?,?,?,?,?,?)";
		int insert = jdbcTemplate.update(query, teacher.getEmpID(), teacher.getDepartment(), teacher.getSalary(),
				teacher.getJoinDate(), teacher.getDesignation(), teacher.getSpecialization(), teacher.getName(),
				teacher.getAge(), teacher.getGender(), teacher.getContactNo(), teacher.getAddress());
		return insert;
	}

	// updating specialization
	public int updateSpecialization(long empId, String specialization) {
		String query = "Update Teachers set specialization = ? where empId = ?";
		int insert = jdbcTemplate.update(query, specialization, empId);
		return insert;
	}

	// updating salary
	public int updateSalary(long empId, long salary) {
		String query = "Update Teachers set salary = ? where empId = ?";
		int insert = jdbcTemplate.update(query, salary, empId);
		return insert;
	}
	//deleting Teacher Record
	public int deleteTeacher(Teacher teacher)
	{
		String query = "delete from Teachers  where empId = ?";
		int insert = jdbcTemplate.update(query, teacher.getEmpID());
		return insert;
	}
}

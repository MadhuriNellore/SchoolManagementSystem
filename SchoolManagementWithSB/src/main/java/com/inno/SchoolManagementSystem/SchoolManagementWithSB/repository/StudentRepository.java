package com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Student;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Teacher;

@Repository
public class StudentRepository {
	
	private final JdbcTemplate jdbcTemplate;

	public StudentRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addStudent(Student student) {
		String query = "Insert into Students values(?,?,?,?,?,?,?,?)";
		int insert = jdbcTemplate.update(query, student.getRollNo(), student.getGrade(), student.getSection(),
				student.getName(), student.getAge(), student.getGender(), student.getContactNo(), student.getAddress());
		return insert;
	}

//deleting Student Record
	public int deleteStudent(Student student) {
		String query = "delete from Students where rollNo = ?";
		int insert = jdbcTemplate.update(query, student.getRollNo());
		return insert;
	}

	public int updateGrade(String rollNo, int grade) {
		String query = "Update Students set grade = ? where rollNo = ?";
		int insert = jdbcTemplate.update(query, grade, rollNo);
		return insert;

	}

	public int updateSection(String rollNo, String section) {
		String query = "Update Students set section = ? where rollNo = ?";
		int insert = jdbcTemplate.update(query, section, rollNo);
		return insert;
	}
	public int updateName(String rollNo, String name) {
		String query = "Update Students set name = ? where rollNo = ?";
		int insert = jdbcTemplate.update(query, name, rollNo);
		return insert;
	}
	public int updateAge(String rollNo, int age) {
		String query = "Update Students set age = ? where rollNo = ?";
		int insert = jdbcTemplate.update(query, age, rollNo);
		return insert;
	}
	public int updateAddress(String rollNo, String address) {
		String query = "Update Students set address = ? where rollNo = ?";
		int insert = jdbcTemplate.update(query, address, rollNo);
		return insert;
	}
	public int updateContactNo(String rollNo, String contactNo) {
		String query = "Update Students set contactNo = ? where rollNo = ?";
		int insert = jdbcTemplate.update(query, contactNo, rollNo);
		return insert;
	}
}

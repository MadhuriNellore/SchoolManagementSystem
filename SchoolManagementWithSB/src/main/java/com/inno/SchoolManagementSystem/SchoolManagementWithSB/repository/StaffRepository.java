package com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Staff;


@Repository
public class StaffRepository {
	private final JdbcTemplate jdbcTemplate;

	public StaffRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addStaff(Staff staff) {

		String query = "Insert into Staff values(?,?,?,?,?,?,?,?,?,?,?)";
		int insert = jdbcTemplate.update(query, staff.getEmpID(), staff.getAddress(), staff.getAge(),
				staff.getContactNo(), staff.getGender(), staff.getName(), staff.getDepartment(), staff.getDesignation(),
				staff.getJoinDate(), staff.getSalary(), staff.getWorktype());
		return insert;
	}
	
	// updating salary
	public int updateSalary(long empId, long salary) {
		String query = "Update Staff set salary = ? where empid = ?";
		int insert = jdbcTemplate.update(query, salary, empId);
		return insert;
	}

	// deleting Teacher Record
	public int deleteStaff(Staff staff) {
		String query = "delete from Staff  where empid = ?";
		int insert = jdbcTemplate.update(query, staff.getEmpID());
		return insert;
	}

	public int updateName(long empId, String name) {
		String query = "Update Staff set name = ? where empid = ?";
		int insert = jdbcTemplate.update(query, name, empId);
		return insert;
	}

	public int updateAge(long empId, int age) {
		String query = "Update Staff set age = ? where empid = ?";
		int insert = jdbcTemplate.update(query, age, empId);
		return insert;
	}

	public int updateAddress(long empId, String address) {
		String query = "Update Staff set address = ? where empid = ?";
		int insert = jdbcTemplate.update(query, address, empId);
		return insert;
	}

	public int updateContactNo(long empId, String contactNo) {
		String query = "Update Staff set contact_no = ? where empid = ?";
		int insert = jdbcTemplate.update(query, contactNo, empId);
		return insert;
	}

}

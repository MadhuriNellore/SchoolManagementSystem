package com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class AdminRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<Map<String, Object>> getStudentRecords()
	{
		List<Map<String, Object>> details= jdbcTemplate.queryForList("select * from students");
		System.out.println(details);
		return details;
	}
	public List<Map<String, Object>> getTeacherRecords()
	{
		List<Map<String, Object>> details= jdbcTemplate.queryForList("select * from teachers");
		System.out.println(details);
		return details;
	}
}

package com.inno.SchoolManagementSystem.SchoolManagementWithSB.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.mapping.MetadataSource;

@Entity(name = "employee_attendance")
public class EmployeeAttendance {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeAttendanceId;
	@Column
	private String empId;
	@Column
	private String entryDate;
	@Column
	private String loginTime;
	@Column
	private String logoutTime;

	public EmployeeAttendance() {
		
		this.empId = null;
		this.entryDate = null;
		this.loginTime = null;
		this.logoutTime = null;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public EmployeeAttendance(long employeeAttendanceId, String empId, String entryDate, String loginTime,
			String logoutTime) {
		super();
		this.employeeAttendanceId = employeeAttendanceId;
		this.empId = empId;
		this.entryDate = entryDate;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
	}

	public long getEmployeeAttendanceId() {
		return employeeAttendanceId;
	}

	public void setEmployeeAttendanceId(long employeeAttendanceId) {
		this.employeeAttendanceId = employeeAttendanceId;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}

}
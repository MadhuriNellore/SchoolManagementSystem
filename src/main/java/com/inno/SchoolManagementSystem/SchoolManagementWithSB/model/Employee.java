package com.inno.SchoolManagementSystem.SchoolManagementWithSB.model;

import java.util.Date;

public class Employee  extends Person{
	private long empID;
    private String department;
    private long salary;
    private Date joinDate;
    private String designation;
	public long getEmpID() {
		return empID;
	}
	public void setEmpID(long empID) {
		this.empID = empID;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
    
}

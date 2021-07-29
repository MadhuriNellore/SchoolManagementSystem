package com.inno.SchoolManagementSystem.SchoolManagementWithSB.model;

import org.springframework.stereotype.Component;


public class Student extends Person{
	private String rollNo;
    private int grade;
    private String section;
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
    
}

package com.inno.SchoolManagementSystem.SchoolManagementWithSB.model;

import org.springframework.stereotype.Component;


public class Teacher extends Employee{
	 private String specialization;

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	 
}

package com.inno.SchoolManagementSystem.SchoolManagementWithSB.model;

import javax.persistence.Entity;


public class Staff extends Employee
{

private String WorkType;

public String getWorktype() {
	return WorkType;
}

public void setWorktype(String workType) {
	this.WorkType = workType;
}
}

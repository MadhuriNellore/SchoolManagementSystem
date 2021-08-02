package com.inno.SchoolManagementSystem.SchoolManagementWithSB.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentsAccounts {
	@Id
	@Column
private String rollNo;
	@Column
private int grade;
	@Column
private long feePaid;
	@Column
private long totalFee;
	public StudentsAccounts()
	{
		this.rollNo=null;
		this.feePaid=0;
		this.grade=0;
		this.totalFee=0;
	}
	
	public StudentsAccounts(String rollNo, int grade, long feePaid, long totalFee) {
		super();
		this.rollNo = rollNo;
		this.grade = grade;
		this.feePaid = feePaid;
		this.totalFee = totalFee;
	}

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
	public long getFeePaid() {
		return feePaid;
	}
	public void setFeePaid(long feePaid) {
		this.feePaid = feePaid;
	}
	public long getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(long totalFee) {
		this.totalFee = totalFee;
	}
	

}

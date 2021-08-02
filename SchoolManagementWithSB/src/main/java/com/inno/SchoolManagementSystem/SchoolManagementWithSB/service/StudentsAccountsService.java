package com.inno.SchoolManagementSystem.SchoolManagementWithSB.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.EmployeeAttendance;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.StudentsAccounts;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository.StudentsAccountsRepository;

@Service
public class StudentsAccountsService {
	private final StudentsAccountsRepository studentsAccountsRepository;

	public StudentsAccountsService(StudentsAccountsRepository studentsAccountsRepository) {
		super();
		this.studentsAccountsRepository = studentsAccountsRepository;
	}
	//Setting fee structure for grade
	public void setfeeStructure(StudentsAccounts studentsAccounts)
	{
		studentsAccountsRepository.save(studentsAccounts);
	}
	//fee paid updated
	@Transactional
	public void updateFeePaid(StudentsAccounts studentsAccounts) {
System.out.println("rollNo : "+ studentsAccounts.getRollNo() + "\nFee paid" + studentsAccounts.getFeePaid());
		studentsAccountsRepository.updateFeepaid(studentsAccounts.getFeePaid(), studentsAccounts.getRollNo());
	}

}

package com.inno.SchoolManagementSystem.SchoolManagementWithSB.service;

import org.springframework.stereotype.Service;

import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Staff;

import com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository.StaffRepository;

@Service
public class StaffService {
	private final StaffRepository staffRepository;

	public StaffService(StaffRepository staffRepository) {
		super();
		this.staffRepository = staffRepository;
	}
		// Registering Staff records
		public int registerStaff(Staff staff) {
			return staffRepository.addStaff(staff);
		}

		// Deleting teacher records
		public int deleteStaff(Staff staff) {
			return staffRepository.deleteStaff(staff);
		}

		public int updateSalary(long empId, long salary) {
			Staff staff = new Staff();
			staff.setSalary(salary);
			System.out.println("Emp id : " + empId + "Updated Salary: " + staff.getSalary());
			return staffRepository.updateSalary(empId, salary);
		}
		public int updateName(long empId, String name) {
			Staff staff = new Staff();
			staff.setName(name);
			return staffRepository.updateName(empId, name);
					}
		public int updateAge(long empId, int age)  {
			Staff staff = new Staff();
			staff.setAge(age);
			return staffRepository.updateAge(empId, age);
		}
		public int updateAddress(long empId, String address)  {
			Staff staff = new Staff();
			staff.setAddress(address);
			return staffRepository.updateAddress(empId, address);
		}
		public int updateContactNo(long empId, String contactNo) {
			Staff staff = new Staff();
			staff.setContactNo(contactNo);	
			return staffRepository.updateContactNo(empId, contactNo);
		}

}

package com.inno.SchoolManagementSystem.SchoolManagementWithSB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Student;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Teacher;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository.StudentRepository;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

		public int registerStudent(Student student) {
		return studentRepository.addStudent(student);
	}
	public int updateGrade(String rollNo, int grade) {
		Student student = new Student();
		student.setGrade(grade);
		student.setRollNo(rollNo);
		return studentRepository.updateGrade(rollNo, grade);
	}
	public int deleteStudent(Student student) {
		return studentRepository.deleteStudent(student);
	}

	public int updateSection(String rollNo, String section) {
		Student student = new Student();
		student.setSection(section);
		return studentRepository.updateSection(rollNo, section);
	}
	public int updateName(String rollNo, String name) {
		Student student = new Student();
		student.setName(name);
		return studentRepository.updateName(rollNo, name);
	}
	public int updateAge(String rollNo, int age)  {
		Student student = new Student();
		student.setAge(age);
		return studentRepository.updateAge(rollNo, age);
	}
	public int updateAddress(String rollNo, String address)  {
		Student student = new Student();
		student.setAddress(address);
		return studentRepository.updateAddress(rollNo, address);
	}
	public int updateContactNo(String rollNo, String contactNo) {
		Student student = new Student();
		student.setContactNo(contactNo);
		return studentRepository.updateContactNo(rollNo, contactNo);
	}
}

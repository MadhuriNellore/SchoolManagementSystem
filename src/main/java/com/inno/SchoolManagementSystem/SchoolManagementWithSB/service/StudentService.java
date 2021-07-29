package com.inno.SchoolManagementSystem.SchoolManagementWithSB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Student;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Teacher;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

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
}

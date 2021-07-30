package com.inno.SchoolManagementSystem.SchoolManagementWithSB.controller;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.EmployeeAttendance;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.Teacher;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.service.TeacherService;

@RestController
@RequestMapping("school/teacher")
public class TeacherController {
	
	private final TeacherService teacherService;
	
	public TeacherController(TeacherService teacherService) {
		super();
		this.teacherService = teacherService;
	}
	//JPA
		@PostMapping(path = "empAttendance", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
		public List<EmployeeAttendance> getEmployeeAttendance()   
		{  
			return teacherService.getEmployeeAttendance();
		}
	@PostMapping(path = "login", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> login(@RequestBody EmployeeAttendance employeeAttendance) {
		Time time = new Time(System.currentTimeMillis());
		employeeAttendance.setLoginTime(String.valueOf(time));
		try {
			//int x=10/0;
		teacherService.login(employeeAttendance);
		return ResponseEntity.ok("Login successful");
		}
		catch(RuntimeException re)
		{
			System.out.println(re);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(re.getMessage());
		}
		
	}
	@PostMapping(path = "logout", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String logout(@RequestBody EmployeeAttendance employeeAttendance) {
		Time time = new Time(System.currentTimeMillis());
		employeeAttendance.setLogoutTime(String.valueOf(time));
		teacherService.logout(employeeAttendance);
		return "logout successful";
	}
	@GetMapping(path = "attendance", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Collection<EmployeeAttendance> getAttendanceByDate(@RequestParam String entryDate) {
        return teacherService.getAttendanceByDate(entryDate);
    }

    @GetMapping(path = "attendance/id", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Collection<EmployeeAttendance> getAttendanceByID(@RequestParam String empId) {
      return teacherService.findByID(empId);
        
    }
	@PostMapping(path = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String registerTeacher(@RequestBody Map<String, String> map) {
		Teacher teacher = new Teacher();
		teacher.setEmpID(Long.parseLong(map.get("empId")));
		teacher.setDepartment(map.get("department"));
		teacher.setSalary(Long.parseLong(map.get("salary")));
		try {
			Date joinDate = new SimpleDateFormat("dd/mm/yyyy").parse(map.get("joinDate"));
			teacher.setJoinDate(joinDate);
		} catch (Exception e) {
			System.out.println(e);
		}

		teacher.setDesignation(map.get("designation"));
		teacher.setSpecialization(map.get("specialization"));
		teacher.setName(map.get("name"));
		teacher.setAge(Integer.parseInt(map.get("age")));
		teacher.setGender(map.get("gender"));
		teacher.setContactNo(map.get("contactNo"));
		teacher.setAddress(map.get("address"));
		if (teacherService.registerTeacher(teacher) == 1)
			return "Teacher Registered Successfully ";
		else
			return "Something went Wrong";
	}

	
	
	@PostMapping(path = "delete", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteTeacher(@RequestBody Map<String, String> map)
	{
		Teacher teacher= new Teacher();
		teacher.setEmpID(Long.parseLong(map.get("empId")));
		if(teacherService.deleteTeacher(teacher)==1)
			return "Deleted successfully"; 
		else
			return "Something Went Wrong";
	}
		@PostMapping(path = "updateSalary", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateSalary(@RequestBody Map<String, String> map) {
		if(teacherService.updateSalary(Long.parseLong(map.get("empId")), Long.parseLong(map.get("salary")))==1)
		return "updated Salary Successfully";
		else
			return "Something went wrong";
	}

	@PostMapping(path = "updateSpecialization", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateSpecialization(@RequestBody Map<String, String> map)
	{
		if(teacherService.updateSpecialization(Long.parseLong(map.get("empId")), map.get("specialization"))==1)
			return "Updated specialization Successfully ";
		else
			return "Something went Wrong";
	}
	@GetMapping(path = "teacher")
	public Map<String, String> getTeacherInfo(@RequestParam String empId) {
		System.out.println("GET endpoint");
		return new HashMap<>();
	}

	@PostMapping(path = "teacher")
	public Map<String, String> postTeacherInfo(@RequestBody Map<String, String> teacher) {
		System.out.println("POST endpoint");
		return teacher;
	}

	@PutMapping(path = "teacher")
	public Map<String, String> putTeacherinfo(@RequestBody Map<String, String> teacher) {
		System.out.println("PUT endpoint");
		return teacher;
	}

	@DeleteMapping(path = "teacher")
	public Map<String, String> deleteTeacherInfo(@RequestParam String empId) {
		System.out.println("DELETE endpoint");
		return new HashMap<>();
	}


}

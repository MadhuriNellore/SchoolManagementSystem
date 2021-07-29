package com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.EmployeeAttendance;
@Repository
public interface EmployeeAttendanceRepository extends CrudRepository<EmployeeAttendance, String> {

	@Query("UPDATE employee_attendance set logout_time=?1 where emp_id=?2 and entry_date=?3")
	@Transactional
	@Modifying
	int updateLogoutTime(String logoutTime, String empId, String entryDate);
	@Query("SELECT e FROM employee_attendance e WHERE e.entryDate = ?1")
    Collection<EmployeeAttendance> getAttendanceByDate(String entryDate);

    @Query("SELECT e FROM employee_attendance e WHERE e.empId = ?1")
    Optional<EmployeeAttendance> getByID(String empID);
}

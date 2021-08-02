package com.inno.SchoolManagementSystem.SchoolManagementWithSB.repository;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.EmployeeAttendance;
import com.inno.SchoolManagementSystem.SchoolManagementWithSB.model.StudentsAccounts;

@Repository
public interface StudentsAccountsRepository extends CrudRepository<StudentsAccounts, String>
{
	@Query("UPDATE StudentsAccounts e set e.feePaid = ?1 where e.rollNo = ?2")
	@Transactional
	@Modifying
	int updateFeepaid(long feePaid, String rollNo);
	@Query("SELECT e FROM StudentsAccounts e")
    Collection<StudentsAccounts> getStudentsAccounts();
	@Query("SELECT e FROM StudentsAccounts e WHERE e.rollNo = ?1")
   Optional<StudentsAccounts> getByID(String rollNo);

}

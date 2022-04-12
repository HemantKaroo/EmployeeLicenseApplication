package com.employeelicense.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employeelicense.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
 
	public List<String> findByEmail(String email);
	@Query(value="Select * FROM employee WHERE employee_id  = ?1", nativeQuery = true)
	public Employee findByEmployeeId(int  employee_id);
}

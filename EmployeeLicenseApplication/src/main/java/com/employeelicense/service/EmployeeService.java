package com.employeelicense.service;

import java.util.List;

import com.employeelicense.dto.EmployeeDTO;
import com.employeelicense.model.Employee;


public interface EmployeeService {

	public Employee saveEmployee(EmployeeDTO employee);
	public Employee getEmployeeById(int employeeId);
	public List<Employee> getAllEmployees();
	public Employee updateEmployee(EmployeeDTO employeeDTO,int employeeId);
	public void deleteEmployeeById(int employeeId);
	
}

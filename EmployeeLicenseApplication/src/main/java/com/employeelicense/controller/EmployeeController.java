package com.employeelicense.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeelicense.dto.EmployeeDTO;
import com.employeelicense.model.Employee;
import com.employeelicense.service.EmployeeService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/employeeLicense")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/saveEmployee")
	@ResponseBody
	public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
		Employee employee = employeeService.saveEmployee(employeeDTO);
		if (employee != null) {
			return new ResponseEntity<>(new Gson().toJson(employee), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getEmployeeById/{employeeId}")
	public ResponseEntity<String> getEmployeeById(@PathVariable(value = "employeeId") int employeeId) {

		Employee employee = employeeService.getEmployeeById(employeeId);

		return new ResponseEntity<>(new Gson().toJson(employee), HttpStatus.OK);
	}

	@GetMapping("/getAllEmployees")
	public ResponseEntity<String> getAllEmployees() {

		List<Employee> employeeList = employeeService.getAllEmployees();

		return new ResponseEntity<>(new Gson().toJson(employeeList), HttpStatus.OK);
	}

	@PutMapping("/employeeUpdate/{employeeId}")
	@ResponseBody
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO employeeDTO,
			@PathVariable(value = "employeeId") int employeeId) {
		Employee employee = employeeService.updateEmployee(employeeDTO, employeeId);
		if (employee != null) {
			return new ResponseEntity<>(new Gson().toJson(employee), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Do Not Try To Change Email-ID", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteEmployeeById/{employeeId}")
	public void deleteEmployee(@PathVariable(value = "employeeId") int employeeId) {
		employeeService.deleteEmployeeById(employeeId);
	}

}

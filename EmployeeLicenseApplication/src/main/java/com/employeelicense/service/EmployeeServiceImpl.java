package com.employeelicense.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeelicense.dto.EmployeeDTO;
import com.employeelicense.dto.LicenseDTO;
import com.employeelicense.model.AuditLog;
import com.employeelicense.model.Employee;
import com.employeelicense.model.License;
import com.employeelicense.repository.AuditLogRepository;
import com.employeelicense.repository.EmployeeRepository;
import com.employeelicense.repository.LicenseRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	AuditLogRepository auditLogRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	LicenseRepository licenseRepository;
	

	@Override
	public Employee saveEmployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		List<License> licenseList = licenseRepository.findAll();
		List<String> employeeExistEmail=employeeRepository.findByEmail(employeeDTO.getEmail());
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setEmail(employeeDTO.getEmail());
		if(!employeeExistEmail.isEmpty()) {
		employee.setPhoneNumber(employeeDTO.getPhoneNumber());
		employee.setOrgId(employeeDTO.getOrgId());
		Set<License> licenseSet = new HashSet<>();
		for (LicenseDTO licensesDTO : employeeDTO.getLicenses()) {
			License license = new License();
			license.setSkuId(licensesDTO.getSkuId());
			licenseSet.add(license);
		}
		for (License licenses : licenseList ) {
			if(!licenseSet.contains(licenses)) {
			License license=new License();
			license.setSkuId(licenses.getSkuId());
			licenseSet.add(license);
			}
		}
		employee.setLicenses(licenseSet);
		Date date = new Date();
		employee.setCreateDate(date);
		employee.setUpdateDate(date);
		employee = employeeRepository.save(employee);
		AuditLog auditLog = new AuditLog();
		String event = "Save";
		auditLog.setEvent(event);
		auditLog.setCreateById(employee.getEmployeeId());
		auditLog.setUpdateById(employee.getEmployeeId());
		auditLog.setCreateDate(date);
		auditLog.setAuditDate(date);
		auditLog.setUpdateDate(date);
		auditLogRepository.save(auditLog);
		}
		return employee;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		return employeeRepository.findById(employeeId).orElse(null);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public void deleteEmployeeById(int employeeId) {

		employeeRepository.deleteById(employeeId);
	}

	@Override
	public Employee updateEmployee(EmployeeDTO employeeDTOUpdate, int employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		Set<License> licenseSet = new HashSet<>();
		for (License licenses : employee.get().getLicenses()) {
			License license = new License();
			license.setSkuId(licenses.getSkuId());
			licenseSet.add(license);
		}
		if (employee.isPresent()) {
			String email = employee.get().getEmail();
			Employee employeeExist = employee.get();
			employeeExist.setFirstName(employeeDTOUpdate.getFirstName());
			employeeExist.setLastName(employeeDTOUpdate.getLastName());
			employeeExist.setEmail(employeeDTOUpdate.getEmail());
			employeeExist.setPhoneNumber(employeeDTOUpdate.getPhoneNumber());
			employeeExist.setOrgId(employeeDTOUpdate.getOrgId());
			for (LicenseDTO licenceDTO : employeeDTOUpdate.getLicenses()) {
				License license = new License();
				license.setSkuId(licenceDTO.getSkuId());
				licenseSet.add(license);
			}
			employeeExist.setLicenses(licenseSet);
			Date date = new Date();
			employeeExist.setUpdateDate(date);
			if (employeeDTOUpdate.getEmail().equals(email)) {
				Employee result = employeeRepository.save(employeeExist);
				AuditLog auditLog = new AuditLog();
				String event = "Update";
				auditLog.setEvent(event);
				auditLog.setUpdateById(employeeExist.getEmployeeId());
				auditLog.setAuditDate(date);
				auditLog.setUpdateDate(date);
				auditLog.setCreateDate(employeeExist.getCreateDate());
				auditLogRepository.save(auditLog);
				return result;
			} else {
				return null;
			}
		}
		return null;
	}

}

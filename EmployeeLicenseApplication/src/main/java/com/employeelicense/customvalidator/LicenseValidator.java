package com.employeelicense.customvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.employeelicense.dto.EmployeeDTO;

public class LicenseValidator implements ConstraintValidator<InvalidLicense, EmployeeDTO> {

	@Override
	public boolean isValid(EmployeeDTO employeeDTO, ConstraintValidatorContext context) {
		
		return (null != employeeDTO && null != employeeDTO.getLicenses() && 
				employeeDTO.getLicenses().size() > 0) ? true : false;
	}

}

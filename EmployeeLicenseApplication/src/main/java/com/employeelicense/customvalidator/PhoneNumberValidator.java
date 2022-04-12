package com.employeelicense.customvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.employeelicense.dto.EmployeeDTO;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, EmployeeDTO> {

	@Override
	public boolean isValid(EmployeeDTO employeeDTO, ConstraintValidatorContext context) {

		String phoneNumber = employeeDTO.getPhoneNumber();
		return ((phoneNumber != null) && (phoneNumber.matches("[0-9]+")) && (phoneNumber.length() == 10)) ? true : false;
	}

}

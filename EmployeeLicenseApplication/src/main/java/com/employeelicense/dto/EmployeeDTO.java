package com.employeelicense.dto;

import java.util.Date;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.employeelicense.customvalidator.InvalidLicense;
import com.employeelicense.customvalidator.PhoneNumber;

@PhoneNumber
@InvalidLicense
public class EmployeeDTO {

	private int employeeId;
	private String firstName;
	private String lastName;
	@NotEmpty
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z.-]+\\.[a-z]{2,6}$", message = "Enter A Valid Email")
	private String email;
	@Valid
	private String phoneNumber;
	private int orgId;
	@Valid
	private Set<LicenseDTO> licenses;
	private Date createDate;
	private Date updateDate;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public Set<LicenseDTO> getLicenses() {
		return licenses;
	}

	public void setLicenses(Set<LicenseDTO> licenses) {
		this.licenses = licenses;
	}

}

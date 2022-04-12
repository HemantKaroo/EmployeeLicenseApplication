package com.employeelicense.dto;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class LicenseDTO {

	
	@NotEmpty(message = "Sku-Id Is Not Empty")
	@Pattern(regexp = "^GJ27[A-Z,0-9]{6}$",message = "Enter Valid Sku-Id")
	private String skuId;

	public String getSkuId() {
		return skuId;
	}
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	@Override
	public String toString() {
		return "LicenseDTO [skuId=" + skuId + "]";
	}
	@Override
	public int hashCode() {
		 return this.skuId.length()%10;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LicenseDTO other = (LicenseDTO) obj;
		return  Objects.equals(skuId, other.skuId);
	}
	
	
}

package com.employeelicense.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "license")
public class License {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int licenseId;

	private String skuId;

	public int getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(int licenseId) {
		this.licenseId = licenseId;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	@Override
	public String toString() {
		return "License [licenseId=" + licenseId + ", skuId=" + skuId + "]";
	}

	@Override
	public int hashCode() {
		return this.skuId.length() % 10;
	}

	public boolean equals(License license) {
		if (this == license)
			if (license == null || getClass() != license.getClass())
				return false;

		License other = (License) license;
		return this.skuId.equals(other.skuId);
	}

}

package com.employeelicense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeelicense.model.License;

public interface LicenseRepository extends JpaRepository<License, Long> {

}

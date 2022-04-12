package com.employeelicense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeelicense.model.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long>{

}

package com.employeelicense.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="auditlog")
public class AuditLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long auditId;
	private String event;
	private Date auditDate;
	private long createById;
	private long updateById;
	private Date createDate;
	private Date updateDate;
	
	public Date getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	public long getAuditId() {
		return auditId;
	}
	public void setAuditId(long auditId) {
		this.auditId = auditId;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public long getCreateById() {
		return createById;
	}
	public void setCreateById(long createById) {
		this.createById = createById;
	}
	public long getUpdateById() {
		return updateById;
	}
	public void setUpdateById(long updateById) {
		this.updateById = updateById;
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
	@Override
	public String toString() {
		return "AuditLog [auditId=" + auditId + ", event=" + event + ", auditDate=" + auditDate + ", createById="
				+ createById + ", updateById=" + updateById + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}
	
	
}

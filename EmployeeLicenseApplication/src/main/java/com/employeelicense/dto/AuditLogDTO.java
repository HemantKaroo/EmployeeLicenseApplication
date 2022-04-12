package com.employeelicense.dto;

import java.util.Date;

public class AuditLogDTO {

	
	private String event;
	private Date auditDate;
	private long createById;
	private long updateById;
	private Date createDate;
	private Date updateDate;
	
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public Date getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
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
	public void setUpdateById(int updateById) {
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
		return "AuditLogDTO [ event=" + event + ", auditDate=" + auditDate + ", createById="
				+ createById + ", updateById=" + updateById + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}
	
	
	
}

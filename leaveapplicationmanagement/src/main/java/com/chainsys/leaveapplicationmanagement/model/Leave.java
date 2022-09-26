package com.chainsys.leaveapplicationmanagement.model;

import java.sql.Date;

public class Leave {
	
	private int leaveId;
	private String leaveType;
	private Date fromDate;
	private Date toDate;
	private long noOfDays;
	private int id;
	
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public long getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(long noOfDays) {
		this.noOfDays = noOfDays;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}

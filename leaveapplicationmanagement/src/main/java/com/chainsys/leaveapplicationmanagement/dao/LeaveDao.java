package com.chainsys.leaveapplicationmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.leaveapplicationmanagement.mapper.LeaveMapper;
import com.chainsys.leaveapplicationmanagement.model.Leave;

@Repository
public class LeaveDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
//Insert	
	public int applyLeave(Leave leave) {
		String query ="insert into leave(LEAVE_ID,LEAVE_TYPE,FROM_DATE,TO_DATE,NO_OF_DAYS,ID)values(?,?,?,?,?,?)";
		int details = 0;
		Object[] data = { leave.getLeaveId(), leave.getLeaveType(),leave.getFromDate(),leave.getToDate(),leave.getNoOfDays(),leave.getId()};
          details = jdbcTemplate.update(query,data);
          return details;
	
	    }
	public List<Leave> listLeave(){
		 String q ="select LEAVE_ID,LEAVE_TYPE,FROM_DATE,TO_DATE,NO_OF_DAYS,ID from leave";
		 List<Leave> listLeave = null;
		 listLeave = jdbcTemplate.query(q,new LeaveMapper());
		 return listLeave; 
	 }
//Update
	public int updateLeave(Leave leave) {
		String query = "update leave set LEAVE_TYPE=?,FROM_DATE=?,TO_DATE=?,NO_OF_DAYS=?,ID=? where leave_id=?";
		int details = 0;
		Object[] datas = {leave.getLeaveType(),leave.getFromDate(),leave.getToDate(),leave.getNoOfDays(),leave.getId(),leave.getLeaveId()};
		details=jdbcTemplate.update(query,datas);
		return details;
	}
//Delete 
	public int deleteLeave(int leaveId) {
		String query = "delete from leave where LEAVE_ID=?";
		int detail = 0;
		detail = jdbcTemplate.update(query,leaveId);
		return detail;
	}
//FindById
	public Leave findByLeaveId(int leaveId) {
		String select = "select LEAVE_ID,LEAVE_TYPE,FROM_DATE,TO_DATE,NO_OF_DAYS,ID from leave where leave_id=?";
		Leave  findById=null;
		findById = jdbcTemplate.queryForObject(select, new LeaveMapper(),leaveId);
		return findById;
	}
	}
	
	

	

package com.chainsys.leaveapplicationmanagement.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.leaveapplicationmanagement.model.Leave;

public class LeaveMapper implements RowMapper<Leave>{
	
	@Override
	public Leave mapRow(ResultSet rs,int rowNum)throws SQLException{
		
		int leaveId = rs.getInt(1);
		String leaveType = rs.getString(2);
		Date fromDate = rs.getDate(3);
		Date toDate = rs.getDate(4);
	    long noOfDays = rs.getInt(5);
	    int id = rs.getInt(6);
	    
	   Leave leave = new Leave();
	   leave.setLeaveId(leaveId);
	   leave.setLeaveType(leaveType);
	   leave.setFromDate(fromDate);
	   leave.setToDate(toDate);
	   leave.setNoOfDays(noOfDays);
	   leave.setId(id);
	   
	   return leave;
		
	}

	
}

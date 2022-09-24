package com.chainsys.leaveapplicationmanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.leaveapplicationmanagement.model.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	
			int id = rs.getInt(1);
			String name = rs.getString(2);	
			String email = rs.getString(3);	
			String password = rs.getString(4);
			
	       User user = new User();
	
		     user.setId(id); 
		     user.setName(name); 
		     user.setEmail(email);
		     user.setPassword(password); 
		  
		return user;
	}
	

}

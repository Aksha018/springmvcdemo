package com.chainsys.moviebooking.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.moviebooking.model.UserData;

public class UserMapper implements RowMapper<UserData>{
	@Override
	public UserData mapRow(ResultSet rs,int rowNum)throws SQLException{
		int userId=rs.getInt(1);
		String name = rs.getString(2);
		String password = rs.getString(3);
		
		UserData user = new UserData();
		
		user.setUserId(userId);
		user.setName(name);
		user.setPassword(password);
		
		return user;
		
	}

}

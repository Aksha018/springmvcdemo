package com.chainsys.GroceryShop.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.GroceryShop.model.User;

public class UserMapper implements RowMapper<User> {
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException{
		int userId = rs.getInt(1);
	    String name = rs.getString(2);
	    String password = rs.getString(3);
	    long mobileNo = rs.getLong(4);
	    
	    User user = new User();
	     user.setUserId(userId);
	     user.setName(name);
	     user.setPassword(password);
	     user.setMobileNo(mobileNo);
	     
	     return user;
	}
	

}

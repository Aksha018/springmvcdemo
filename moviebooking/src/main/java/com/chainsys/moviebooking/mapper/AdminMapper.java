package com.chainsys.moviebooking.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.moviebooking.model.Admin;

public class AdminMapper implements RowMapper<Admin> {
	@Override
	public Admin mapRow(ResultSet rs, int rowNum)throws SQLException{
		String name = rs.getString(1);
		String password = rs.getString(2);
		
		Admin admin = new Admin();
		admin.setName(name);
		admin.setPassword(password);
		
		return admin;
	}

}

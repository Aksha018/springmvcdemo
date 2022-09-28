package com.chainsys.moviebooking.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.moviebooking.mapper.AdminMapper;
import com.chainsys.moviebooking.model.Admin;

@Repository
public class AdminDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Admin findByName(String name) {
		String query ="select NAME,PASSWORD from ADMIN1 where NAME=?"; 
		Admin findByName = null;
		findByName = jdbcTemplate.queryForObject(query, new AdminMapper(),name);
		return findByName;
		
		
	}

}

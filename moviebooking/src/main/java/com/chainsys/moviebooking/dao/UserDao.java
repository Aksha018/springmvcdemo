package com.chainsys.moviebooking.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.moviebooking.exception.UserException;
import com.chainsys.moviebooking.mapper.UserMapper;
import com.chainsys.moviebooking.model.UserData;
import com.chainsys.moviebooking.validation.UserValidation;

@Repository
public class UserDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	UserValidation userValidation;
	
//Insert 
	public int addUser(UserData user) {
		String query ="insert into USERSDATA(USER_ID,NAME,PASSWORD)values(?,?,?)";
		int details = 0;
		Object[] userDetails = {user.getUserId(),user.getName(),user.getPassword()};
		details=jdbcTemplate.update(query,userDetails);
		return details;
		
	}
//View user
	public List<UserData> listUser(){
		String select = "select USER_ID,NAME,PASSWORD from USERSDATA";
		List<UserData> listUser = null;
		listUser = jdbcTemplate.query(select, new UserMapper());
		return listUser;
		
	}
//Update 
	public int updateUser(UserData user) {
		String query ="update USERSDATA set NAME=?,PASSWORD=? where USER_ID=?";
		int details=0;
		Object[] userDetails = {user.getName(),user.getPassword(),user.getUserId()};
		details = jdbcTemplate.update(query,userDetails);
		return details;
	}
//delete
	public int deleteUser(int userId) {
		String query ="delete from USERSDATA where USER_ID=?";
		int details=0;
		details = jdbcTemplate.update(query,userId);
		return details;
				
	}
//FindByUserId 
	public UserData findByUserId(int userid) throws UserException{
		if(!userValidation.chechUserId(userid)) {
			throw new UserException("Invalid UserId or Id should be greater than 0");
		}
		String select = "select USER_ID,NAME,PASSWORD from USERSDATA where USER_ID=?";
		UserData findByUserId = null;
		findByUserId = jdbcTemplate.queryForObject(select,new UserMapper(),userid);
		
		if(!userValidation.checkUser(findByUserId)) {
			throw new UserException("Data not found");
		}
		return findByUserId;
	}
}

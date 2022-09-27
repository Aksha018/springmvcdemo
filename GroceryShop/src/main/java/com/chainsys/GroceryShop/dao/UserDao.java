package com.chainsys.GroceryShop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.GroceryShop.Exception.UserException;
import com.chainsys.GroceryShop.mapper.UserMapper;
import com.chainsys.GroceryShop.model.User;
import com.chainsys.GroceryShop.validation.GroceryValidation;
import com.chainsys.GroceryShop.validation.UserValidation;

@Repository
public class UserDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	UserValidation userValidation;
	
// Insert 
	
	public int addUser(User user) {
		String query = "insert into USERDETAILS (USER_ID,NAME,PASSWORD,MOBILE_NO) values (?,?,?,?)";
		int details = 0;
		Object[] userDetails = {user.getUserId(),user.getName(),user.getPassword(),user.getMobileNo()};
		details = jdbcTemplate.update(query,userDetails);
		return details;
	}
//UserList 
	public List<User> listUser(){
		String select = "select USER_ID,NAME,PASSWORD,MOBILE_NO from USERDETAILS";
		List<User> listUser= null;
		listUser = jdbcTemplate.query(select, new UserMapper());
		return listUser;
	}
//Update
	public int updateUser(User user) {
		String query = "update USERDETAILS set NAME=?,PASSWORD=?,MOBILE_NO=? where USER_ID=?";
		int details=0;
		Object[] userDetails = {user.getName(),user.getPassword(),user.getMobileNo(),user.getUserId()};
		details= jdbcTemplate.update(query,userDetails);
		return details;
		
		
	}
//Delete
	public int deleteUser(int userId) {
		String query ="delete from USERDETAILS where USER_ID=?";
		int details=0;
		details=jdbcTemplate.update(query,userId);
		return details;
	}
//FindByUserId
	public User findByUserId(int userId) throws UserException {
		
		if(!userValidation.checkUserId(userId)) {
			throw new UserException("Invalid userId or id should be greater than 0");
		}
		
		String select = "select USER_ID,NAME,PASSWORD,MOBILE_NO from USERDETAILS where USER_ID=?";
		User findById = null;
		findById = jdbcTemplate.queryForObject(select, new UserMapper(),userId);
		if(!userValidation.checkUser(findById)) {
			throw new UserException("Data not found");
		}
		return findById;
	
	}
	

}

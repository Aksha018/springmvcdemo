package com.chainsys.leaveapplicationmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.leaveapplicationmanagement.mapper.UserMapper;
import com.chainsys.leaveapplicationmanagement.model.User;

@Repository
public class UserDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	                            
// Insert
	public int addUser(User user) {
		String q = "insert into user1(id,name,email,password) values (?,?,?,?)";
		int details = 0;
		Object[] userDetail = { user.getId(), user.getName(), user.getEmail(), user.getPassword() };
		details = jdbcTemplate.update(q, userDetail);
		return details;
	}
// View User List 	
	public List<User> listUser() {
		
		String select = "select id,name,email,password from user1";
		 List<User> listUser = null;
		 listUser = jdbcTemplate.query(select,new UserMapper());
		 return listUser;
		
	}
//Update
	public int updateUser(User user) {
		String q = "update user1 set name=?,email=?,password=? where id=?";
		int details = 0;
		Object[] userDetail = { user.getName(), user.getEmail(), user.getPassword() ,user.getId()};
		details = jdbcTemplate.update(q, userDetail);
		return details;
	}
//Delete 
	public int deleteUser(int id) {
		String q ="delete from user1 where id=?";
		int detail = 0;
		detail = jdbcTemplate.update(q, id);
		return detail;
	}
//FindById	
public User findByUserId(int id ) {

		String select = "select id,name,email,password from user1 where id=?";
		 User findById = null;
		 findById = jdbcTemplate.queryForObject(select,new UserMapper(),id);
		 return findById;
		
	}
}

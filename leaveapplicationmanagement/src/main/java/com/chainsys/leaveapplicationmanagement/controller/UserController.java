package com.chainsys.leaveapplicationmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.leaveapplicationmanagement.dao.UserDao;
import com.chainsys.leaveapplicationmanagement.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserDao userDao;
	
	@GetMapping("/indexpage")
		public String index() {
			return "/index.jsp";
		}
	
	@GetMapping("/addform")
	public String add() {
		return "/add-user.jsp";

	}

@GetMapping("adduser") 
 public String insertUser(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password,Model model){
	  
	  User user = new User();
	  
	  user.setId(id); 
	  user.setName(name); 
	  user.setEmail(email);
	  user.setPassword(password); 
	  
	  int addUser = userDao.addUser(user); 
	  List<User> userList =userDao.listUser();
	  model.addAttribute(userList);
	  return "/list-user.jsp";
	  
	  }
 @GetMapping("/updateform")
 public String update() {
		return "/update-user.jsp";
 }
 @GetMapping("update")
	 public String updateUser(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password,Model model){
		  
		  User user = new User();
		  
		  user.setId(id); 
		  user.setName(name); 
		  user.setEmail(email);
		  user.setPassword(password); 
		  
		  int updateUser = userDao.updateUser(user); 
		  List<User> userList =userDao.listUser();
		  model.addAttribute(userList);
		  return "/list-user.jsp";
		  
		  }
 @GetMapping("/deleteform")
 public String delete() {
		return "/delete-user.jsp";
 }
 @GetMapping("delete")
	 public String deleteUser(@RequestParam("id") int id,Model model){
		 int deleteUser = userDao.deleteUser(id); 
		 
		  List<User> userList =userDao.listUser();
		  model.addAttribute(userList);
		  return "/list-user.jsp";
		  
		  }
 
 @GetMapping("/findbyidform")
 public String findbyids() {
		return "/findby_userid.jsp";
 }
 @GetMapping("/findbyid")
 public String findbyuserid(@RequestParam("id") int id,Model model) {
	 User userid =userDao.findByUserId(id);
	 List<User> userList =new ArrayList<>();
	 userList.add(userid);
	  model.addAttribute(userList);
	  return "/list-user.jsp";
 }
 }
	    


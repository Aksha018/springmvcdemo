package com.chainsys.GroceryShop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.GroceryShop.dao.UserDao;
import com.chainsys.GroceryShop.model.User;
import com.chainsys.GroceryShop.validation.UserValidation;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserDao userDao;
@Autowired
UserValidation userValidation;

	
	@GetMapping("/adduser")
	public String add() {
		return "/add-user.jsp";
	}

	@GetMapping("add")
	public String insertUser(@RequestParam("userId") int userId, @RequestParam("name") String name,
			@RequestParam("password") String password, @RequestParam("mobileNo") long mobileNo, Model model) {
     if(userValidation.checkUserId(userId)) {
    	 if(userValidation.checkUsername(name)) {
    	  if(userValidation.checkPassword(password)) {	 
    	 if(userValidation.checkMobileNo(mobileNo)) {
    	 
    	 User user = new User();
 		user.setUserId(userId);
 		user.setName(name);
 		user.setPassword(password);
 		user.setMobileNo(mobileNo);
 		
 		int addUser = userDao.addUser(user);
 		List<User> listUser = userDao.listUser();
 		model.addAttribute("listUser",listUser);
 		return "/list-user.jsp"; 
     }
    	 
    	 else {
    	 String mobileNum = "Please enter valid number";
			model.addAttribute("check", mobileNum);
			return "/add-user.jsp";
     }
    	  }else {
    		  String addpassword = "Please enter valid password";
   			model.addAttribute("check", addpassword);
   			return "/add-user.jsp";
    	  }
    	 }else {
    		String userName = "Please enter alphabets only";
 			model.addAttribute("check", userName);
 			return "/add-user.jsp";
    	 }
     }
     else {
    	 String adduserId = "Please enter valid id";
			model.addAttribute("check", adduserId);
			return "/add-user.jsp";
     }
     
	}

	@GetMapping("/updateuser")
	public String update() {
		return "/update-user.jsp";
	}

	@GetMapping("update")
	public String updateUser(@RequestParam("userId") int userId, @RequestParam("name") String name,
			@RequestParam("password") String password, @RequestParam("mobileNo") long mobileNo, Model model) {

		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setMobileNo(mobileNo);
		user.setUserId(userId);

		int update = userDao.updateUser(user);
		List<User> listUser = userDao.listUser();
		System.out.println("To list the values");
		model.addAttribute("listUser",listUser);
		return "/list-user.jsp";

	}

	@GetMapping("/deleteuser")
	public String delete() {
		return "/delete-user.jsp";
	}

	@GetMapping("delete")

	public String deleteUser(@RequestParam("userId") int userId, Model model) {
		int deleteUser = userDao.deleteUser(userId);
		List<User> listUser = userDao.listUser();
		model.addAttribute("listUser",listUser);
		return "/list-user.jsp";
	}

	@GetMapping("/findbyid")
	public String findbyid() {
		return "/findby-userid.jsp";
	}

	@GetMapping("findbyuserid")
	public String findById(@RequestParam("userId") int userId, Model model) {
		User findByUserId = userDao.findByUserId(userId);
		List<User> listUser = new ArrayList<User>();
		listUser.add(findByUserId);
		model.addAttribute("listUser",listUser);
		return "/list-user.jsp";
	}

}

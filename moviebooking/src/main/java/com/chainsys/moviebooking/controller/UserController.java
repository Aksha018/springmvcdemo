package com.chainsys.moviebooking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.moviebooking.dao.MovieDao;
import com.chainsys.moviebooking.dao.UserDao;
import com.chainsys.moviebooking.exception.UserException;
import com.chainsys.moviebooking.model.Movie;
import com.chainsys.moviebooking.model.UserData;
import com.chainsys.moviebooking.validation.UserValidation;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserDao userDao;
    @Autowired
    UserValidation userValidation;
    @Autowired
    MovieDao movieDao;
    
    @GetMapping("/adduserdetails")
	public String add() {
		return "/add-user.jsp";
	}

    @GetMapping("add")
    public String insertUser(@RequestParam("userId")int userId,@RequestParam("name")String name,@RequestParam("password")String password,Model model) {
    	if(userValidation.chechUserId(userId)) {
    		if(userValidation.checkUserName(name)) {
    			if(userValidation.checkPassword(password)) {
    			
    		UserData user = new UserData();
        	user.setUserId(userId);
        	user.setName(name);
        	user.setPassword(password);
        	
        	int addUser = userDao.addUser(user);
        	
        	 List<Movie> movieList = movieDao.listMovie();
    		 model.addAttribute("listMovie", movieList);
    		 return "/user-movie-list.jsp";
    		 
    		 
    	}else {
    		String addPassword = "Please enter valid password";
    		model.addAttribute("check", addPassword);
    		return "/add-user.jsp";
    	}
    		}else {
    		String addUserName = "Please enter Alphabets only";
    		model.addAttribute("check", addUserName);
    		return "/add-user.jsp";
    	}
    		}else {
    		String addUserId ="Please enter valid id";
    		model.addAttribute("check", addUserId);
    		return "/add-user.jsp";
    	}
    }
    
    @GetMapping("/updateuserdetails")
    public String update() {
    	return "/update-user.jsp";
    }
    
    @GetMapping("update")
    public String updateUserData(@RequestParam("userId")int userId,@RequestParam("name")String name,@RequestParam("password")String password,Model model) {
    	if(userValidation.chechUserId(userId)) {
    		if(userValidation.checkUserName(name)) {
    			if(userValidation.checkPassword(password)) {
    			
    	UserData user = new UserData();
    	user.setName(name);
    	user.setPassword(password);
    	user.setUserId(userId);
    	
    	int updateUser = userDao.updateUser(user);
    	List<UserData> userList = userDao.listUser();
    	model.addAttribute("userList", userList);
    	return "/list-user.jsp";
    	
    			}else {
    	    		String addPassword = "Please enter valid password";
    	    		model.addAttribute("check", addPassword);
    	    		return "/update-user.jsp";
    	    	}
    	    		}else {
    	    		String addUserName = "Please enter Alphabets only";
    	    		model.addAttribute("check", addUserName);
    	    		return "/update-user.jsp";
    	    	}
    	    		}else {
    	    		String addUserId ="Please enter valid id";
    	    		model.addAttribute("check", addUserId);
    	    		return "/update-user.jsp";
    	    	}
    	    }
    
    @GetMapping("deleteuserdetails")
    public String delete() {
    	return "/delete-user.jsp";
    }
    @GetMapping("delete")
    public String deleteUserData(@RequestParam("userId")int userId,Model model) {
    	if(userValidation.chechUserId(userId)) {
    	int deleteUser = userDao.deleteUser(userId);
    	List<UserData> userList = userDao.listUser();
    	model.addAttribute("userList", userList);
    	return "/list-user.jsp";
    	
    }else {
		String addUserId ="Please enter valid id";
		model.addAttribute("check", addUserId);
		return "/delete-user.jsp";
	}
    }
    
    @GetMapping("/findByUserId")
    public String find() {
    	return "/findby-userid.jsp";
    }
    
    @GetMapping("findbyid")
    public String findByUserIds(@RequestParam("userId")int userId,Model model) {
    	 UserData findByUserId;
    try {
    	UserData user = userDao.findByUserId(userId);
    	List<UserData> userList = new ArrayList<>();
    	userList.add(user);
    	model.addAttribute("userList", userList);
    	return "/list-user.jsp";
    }catch(UserException e) {
    	return null;
    }
    
    
    }
    
    }

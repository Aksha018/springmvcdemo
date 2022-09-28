package com.chainsys.moviebooking.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Repository;

import com.chainsys.moviebooking.model.UserData;

@Repository
public class UserValidation {
	
	public boolean chechUserId(int userId) {
		if((userId<=0)) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean checkUser(UserData user) {
		if(user==null) {
			return false;
			
		}
		else {
			return true;
		}
	}

	 public boolean checkUserName(String name) {
		 String regex = "^[a-z A-Z]+$";
		 Pattern p = Pattern.compile(regex);
		 if(name==null) {
			 return false;
		 }
		 Matcher m = p.matcher(name);
		 return m.matches();
	 }
	 public boolean checkPassword(String password) {
		 if((password.length()==10)) {
			 return true;
		 }
		 else {
			 return false;
		 }
	 }
}

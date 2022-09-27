package com.chainsys.GroceryShop.validation;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Repository;

import com.chainsys.GroceryShop.model.User;

@Repository
public class UserValidation {
	
	
	public boolean checkUserId(int userId) {
		if(userId<=0) {
			return false;
		}
		else {
			return true;
		}
			}
	public boolean checkUser(User user) {
		if(user==null) {
			return false;
		}
		else {
			return true;
		}
			}
		
	
	public boolean checkUsername(String name){
		  
        String regex = "^[a-z A-Z]+$";
        Pattern p = Pattern.compile(regex);
        if (name == null) {
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
	
	public boolean checkMobileNo(long mobileNo) {
		String mobileNo1 = Long.toString(mobileNo);
		if((mobileNo1.length()==10)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
}

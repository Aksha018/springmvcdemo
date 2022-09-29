package com.chainsys.GroceryShop.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chainsys.GroceryShop.dao.UserDao;
import com.chainsys.GroceryShop.model.User;

@Repository
public class GroceryValidation {
	@Autowired
	UserDao userDao;
	
	public boolean checkProductname(String productName){
		  
        String regex = "^[a-z A-Z]+$";
        Pattern p = Pattern.compile(regex);
        if (productName == null) {
            return false;
        }
        Matcher m = p.matcher(productName);
        return m.matches();
    }
	
	public boolean checkQuantity(int quantity) {
		
		if(quantity<=0) {
			return false;
		}
		else {
			return true;
		}
	}
public boolean checkPrice(int price) {
		
		if(price<=0) {
			return false;
		}
		else {
			return true;
		}
	}
public boolean checkProductId(int productId) {
	if(productId<=0) {
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

}

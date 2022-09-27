package com.chainsys.GroceryShop.Exception;

public class UserException extends Exception {
	    public UserException()
	    {  
	        super("There is some issue, please try again");
	    }
	    public UserException(String s)
	    {  
	        super(s);
	    }
	}


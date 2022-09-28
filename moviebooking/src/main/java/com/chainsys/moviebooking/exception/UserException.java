package com.chainsys.moviebooking.exception;

public class UserException extends Exception {
	public UserException() {
		super("There is some issues ,please try again");
	}
	public UserException(String s) {
		super(s);
	}

}

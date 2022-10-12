package com.chainsys.bookmanagement.exception;

public class BookException extends Exception{
	
	public BookException() {
		super("There is some issues ,please try again");
	}
	public BookException(String s) {
		super(s);
	}

}




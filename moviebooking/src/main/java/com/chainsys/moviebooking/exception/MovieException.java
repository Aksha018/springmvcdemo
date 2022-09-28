package com.chainsys.moviebooking.exception;

public class MovieException extends Exception{
	
	public MovieException() {
		super("There is some issues , please try again");
	}
	public MovieException(String s) {
		super(s);
	}

}

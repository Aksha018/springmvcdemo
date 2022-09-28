package com.chainsys.moviebooking.model;

import java.sql.Date;

public class Movie {
	private int movieId;
	private String movieName;
	private Date movieDate;
	private int price;
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Date getMovieDate() {
		return movieDate;
	}
	public void setMovieDate(Date movieDate) {
		this.movieDate = movieDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	 

}

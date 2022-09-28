package com.chainsys.moviebooking.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Repository;

import com.chainsys.moviebooking.model.Movie;

@Repository
public class MovieValidation {
   public boolean checkMovieId(int movieId) {
	   if((movieId<=0)) {
		   return false;
	   }
	   else {
		   return true;
	   }
   }
   public boolean checkMovie(Movie movie) {
	   if(movie==null) {
		   return false;
	   }
	   else {
		   return true;
	   }
   }
   
   public boolean checkMovieName(String movieName) {
	   String regex = "^[a-z A-Z]+$";
	   Pattern p = Pattern.compile(regex);
	   if(movieName==null) {
		   return false;
	   }
	   Matcher m = p.matcher(movieName);
	   return m.matches();
   }
   
   public boolean checkPrice(int price) {
	   if((price<=0)) {
		   return false;
	   }
	   else {
		   return true;
	   }
   }
   
}

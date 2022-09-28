package com.chainsys.moviebooking.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.moviebooking.exception.MovieException;
import com.chainsys.moviebooking.mapper.MovieMapper;
import com.chainsys.moviebooking.model.Movie;
import com.chainsys.moviebooking.validation.MovieValidation;

@Repository
public class MovieDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired 
	MovieValidation movieValidation;
	
//Insert
	public int addMovieDetails(Movie movie) {
		String query = "insert into MOVIE(MOVIE_ID,MOVIE_NAME,MOVIE_DATE,PRICE)values(?,?,?,?)";
		int data = 0;
		Object[] moviedetails = {movie.getMovieId(),movie.getMovieName(),movie.getMovieDate(),movie.getPrice()};
		data = jdbcTemplate.update(query,moviedetails);
		return data;
	}
//View Movie List
	public List<Movie> listMovie(){
		String select = "select MOVIE_ID,MOVIE_NAME,MOVIE_DATE,PRICE from MOVIE";
		List<Movie> listMovie = null;
		listMovie = jdbcTemplate.query(select,new MovieMapper());
		return listMovie;
				
	}
//Update 
	public int updateMovieDetails(Movie movie) {
		String query ="update MOVIE set MOVIE_NAME=?,MOVIE_DATE=?,PRICE=? where MOVIE_ID=?";
		int data =0;
		Object[] moviedetails = {movie.getMovieName(),movie.getMovieDate(),movie.getPrice(),movie.getMovieId()};
		data = jdbcTemplate.update(query,moviedetails);
		return data;
	}
//Delete 
	public int removeMovieDetails(int movieId) {
		String query = "delete from MOVIE where MOVIE_ID=?";
		int data = 0;
		data = jdbcTemplate.update(query,movieId);
		return data;
	}
//findByMovieId
	public Movie findByMovieId(int movieId)  throws MovieException {
		if(!movieValidation.checkMovieId(movieId)){
			throw new MovieException("Invalid Movie Id");
		}
		String select = "select MOVIE_ID,MOVIE_NAME,MOVIE_DATE,PRICE from MOVIE where MOVIE_ID=?";
	     Movie findByMovieId = null;
	     findByMovieId=jdbcTemplate.queryForObject(select, new MovieMapper(),movieId);
	     if(!movieValidation.checkMovie(findByMovieId)) {
	    	 throw new MovieException("Data not Found");
	     }
	     return findByMovieId;
	}
}

package com.chainsys.moviebooking.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.moviebooking.model.Movie;
import com.chainsys.moviebooking.model.UserData;

public class MovieMapper implements RowMapper<Movie>{

	public Movie mapRow(ResultSet rs,int rowNum)throws SQLException{
		int movieId =rs.getInt(1);
		String movieName = rs.getString(2);
		Date movieDate = rs.getDate(3);
		int price = rs.getInt(4);
		
		Movie movie = new Movie();
		
		movie.setMovieId(movieId);
		movie.setMovieName(movieName);
		movie.setMovieDate(movieDate);
		movie.setPrice(price);
		return movie;
	}

}

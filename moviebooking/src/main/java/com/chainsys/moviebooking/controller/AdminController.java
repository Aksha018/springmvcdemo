package com.chainsys.moviebooking.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.moviebooking.dao.AdminDao;
import com.chainsys.moviebooking.dao.MovieDao;
import com.chainsys.moviebooking.model.Admin;
import com.chainsys.moviebooking.model.Movie;
import com.chainsys.moviebooking.validation.MovieValidation;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminDao adminDao;
	@Autowired
	MovieValidation movieValidation;
	@Autowired
	MovieDao movieDao;

	@GetMapping("/findByName")
	public String find() {
		return "/find-by-name.jsp";
	}

	@GetMapping("find")
	public String findName(@RequestParam("name") String name, Model model) {
		Admin adminName = adminDao.findByName(name);
		List<Admin> adminList = new ArrayList<>();
		adminList.add(adminName);
		model.addAttribute("adminList", adminList);
		return "/add-movie-details.jsp";

	}

	@GetMapping("add")
	public String insertMovieDetails(@RequestParam("movieId") int movieId, @RequestParam("movieName") String movieName,
			@RequestParam("movieDate") String movieDate, @RequestParam("price") int price, Model model) {
		if (movieValidation.checkMovieId(movieId)) {
			if (movieValidation.checkMovieName(movieName)) {
				if (movieValidation.checkPrice(price)) {

					LocalDate date = LocalDate.parse(movieDate);
					Date movieDate1 = Date.valueOf(date);

					Movie movie = new Movie();
					movie.setMovieId(movieId);
					movie.setMovieName(movieName);
					movie.setMovieDate(movieDate1);
					movie.setPrice(price);
					int addDetails = movieDao.addMovieDetails(movie);
					List<Movie> movieList = movieDao.listMovie();
					model.addAttribute("movieList", movieList);
					return "/movie-list.jsp";
				} else {
					String addPrice = "Please enter valid number";
					model.addAttribute("check", addPrice);
					return "/add-movie-details";
				}
			} else {
				String addMovieName = "Please enter Alphabets only";
				model.addAttribute("check", addMovieName);
				return "/add-movie-details.jsp";
			}
		} else {
			String addMovieId = "Please enter valid id";
			model.addAttribute("check", addMovieId);
			return "/add-movie-details.jsp";
		}

	}

	@GetMapping("/updatemoviedetails")
	public String update() {
		return "/update-movie-details.jsp";
	}

	@GetMapping("update")
	public String updateMovieDetails(@RequestParam("movieId") int movieId, @RequestParam("movieName") String movieName,
			@RequestParam("movieDate") String movieDate, @RequestParam("price") int price, Model model) {
		if (movieValidation.checkMovieId(movieId)) {
			if (movieValidation.checkMovieName(movieName)) {
				if (movieValidation.checkPrice(price)) {

					LocalDate date = LocalDate.parse(movieDate);
					Date movieDate1 = Date.valueOf(date);
					Movie movie = new Movie();
					movie.setMovieName(movieName);
					movie.setMovieDate(movieDate1);
					movie.setPrice(price);
					movie.setMovieId(movieId);

					int update = movieDao.updateMovieDetails(movie);
					List<Movie> movieList = movieDao.listMovie();
					model.addAttribute("movieList", movieList);
					return "/movie-list.jsp";
				} else {
					String addPrice = "Please enter valid number";
					model.addAttribute("check", addPrice);
					return "/update-movie-details";
				}
			} else {
				String addMovieName = "Please enter Alphabets only";
				model.addAttribute("check", addMovieName);
				return "/update-movie-details.jsp";
			}
		} else {
			String addMovieId = "Please enter valid id";
			model.addAttribute("check", addMovieId);
			return "/update-movie-details.jsp";
		}
	}

	@GetMapping("/removemoviedetails")
	public String delete() {
		return "/remove-movie-details.jsp";
	}

	@GetMapping("remove")
	public String removeDetails(@RequestParam("movieId") int movieId, Model model) {
		int deleteMovieDetails = movieDao.removeMovieDetails(movieId);
		List<Movie> movieList = movieDao.listMovie();
		model.addAttribute("movieList", movieList);
		return "/movie-list.jsp";
	}

}

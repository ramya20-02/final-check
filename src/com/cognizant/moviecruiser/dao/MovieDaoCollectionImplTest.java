package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieDaoCollectionImplTest {

	public static void main(String[] args) {

		try {
			System.out.println("Admin Movie List");
			testGetMovieListAdmin();

			System.out.println("Customer Movie List");
			testGetMovieListCustomer();
			testEditMovie();

			System.out.println("Edit Movie List");
			testGetMovieListAdmin();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void testGetMovieListAdmin() throws ParseException {
		MovieDao movieDao = new MovieDaoCollectionImpl();
		List<Movie> movieList = movieDao.getMovieListAdmin();

		for (Movie x : movieList) {
			System.out.println(x);
		}
	}

	public static void testGetMovieListCustomer() throws ParseException {
		MovieDao movieDao = new MovieDaoCollectionImpl();
		List<Movie> movieList = movieDao.getMovieListCustomer();

		for (Movie x : movieList) {
			System.out.println(x);
		}
	}

	public static void testEditMovie() throws ParseException {
		Movie m = new Movie(3, "Transformers", 145412456, true, DateUtil.convertToDate("18/12/2022"), "Action", true);
		MovieDao movieDao = new MovieDaoCollectionImpl();
		movieDao.editMovies(m);
	}

}

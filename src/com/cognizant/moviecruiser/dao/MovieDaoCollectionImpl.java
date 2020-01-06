package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieDaoCollectionImpl implements MovieDao {
	private static List<Movie> MovieList;

	public MovieDaoCollectionImpl() throws ParseException {
		super();
		if (MovieList == null) {
			MovieList = new ArrayList<>();
			MovieList.add(new Movie(1, "Avatar", 278796508, true, DateUtil.convertToDate("15/03/2017"),
					"Science Fiction", true));
			MovieList.add(new Movie(2, "The Avengers", 1518812988, true, DateUtil.convertToDate("23/12/2017"),
					"Superhero", false));
			MovieList.add(
					new Movie(3, "Titanic", 218746394, true, DateUtil.convertToDate("21/08/2017"), "Romance", false));
			MovieList.add(new Movie(4, "Jurrasic Park", 1671713208, false, DateUtil.convertToDate("02/07/2017"),
					"Science Fiction", true));
			MovieList.add(new Movie(5, "Avengers:End Game", 275076034, true, DateUtil.convertToDate("02/11/2022"),
					"Superhero", true));

		}
	}

	@Override
	public List<Movie> getMovieListAdmin() {
		return MovieList;
	}

	@Override
	public List<Movie> getMovieListCustomer() {
		List<Movie> customerList = new ArrayList<>();
		Date today = new Date();
		for (Movie x : MovieList) {
			if (x.isActive() && x.getDateOfLaunch().before(today)) {
				customerList.add(x);
			}
		}
		return customerList;
	}

	@Override
	public void editMovies(Movie movie) {
		for (int i = 0; i < MovieList.size(); i++) {
			
			if (MovieList.get(i).getId() == movie.getId()) {
				
				MovieList.set(i, movie);
				break;
			}
		}

	}

	@Override
	public Movie getMovie(long movieId) {
		for (Movie movie : MovieList) {
			if (movie.getId() == movieId) {
				return movie;
			}
		}
		return null;
	}

}

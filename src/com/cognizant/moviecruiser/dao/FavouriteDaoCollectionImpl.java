package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.model.Favourite;
import com.cognizant.moviecruiser.model.Movie;

public class FavouriteDaoCollectionImpl implements FavouritesDao {

	private static HashMap<Long, Favourite> userFavourites;

	public FavouriteDaoCollectionImpl() {

		if (userFavourites == null) {
			userFavourites = new HashMap<>();
			userFavourites.put(1l, new Favourite());
		}

	}

	@Override
	public void addFavourites(long userId, long movieId) {
		try {
			MovieDao movieDao = new MovieDaoCollectionImpl();
			Movie movie = movieDao.getMovie(movieId);
			if (userFavourites.containsKey(userId)) {
				Favourite favourite = userFavourites.get(userId);
				favourite.getMovieList().add(movie);
			} else {
				Favourite Favourite = new Favourite();
				Favourite.getMovieList().add(movie);
				userFavourites.put(userId, Favourite);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Movie> getAllFavourites(long userId) throws FavouritesEmptyException {
		List<Movie> movieList = userFavourites.get(userId).getMovieList();
		Favourite favourite = userFavourites.get(userId);
		double total = 0.0;
		if (favourite == null || favourite.getMovieList() == null || movieList.isEmpty()) {
			throw new FavouritesEmptyException();
		} else {
			for (Movie movie : movieList) {
				total += movie.getBoxOffice();
			}
		}
		favourite.setTotal(total);
		return movieList;
	}

	@Override
	public void removeFavourites(long userId, long MovieId) {
		List<Movie> movieList = userFavourites.get(userId).getMovieList();
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == MovieId) {
				movieList.remove(i);
				break;
			}

		}

	}

}

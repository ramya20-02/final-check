package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public interface FavouritesDao {
    public default void addFavourites(long userId,long movieId) {
		// TODO Auto-generated method stub
		
	}
    
    public List<Movie> getAllFavourites(long userId) throws FavouritesEmptyException;
    
    public void removeFavourites(long userId,long MovieId);

		
	}

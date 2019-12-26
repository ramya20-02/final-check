package com.cognizant.moviecruiser.dao;

public class FavouritesEmptyException extends Exception {
	public FavouritesEmptyException() {
		super("Favourites is empty");
		// TODO Auto-generated constructor stub
	}

	public FavouritesEmptyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}

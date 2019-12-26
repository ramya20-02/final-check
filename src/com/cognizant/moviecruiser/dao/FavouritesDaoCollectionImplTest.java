package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;



public class FavouritesDaoCollectionImplTest {

	public static void main(String[] args) throws FavouritesEmptyException {
		System.out.println("Favourites");
		testGetAllFavouriteItems();
		testAddFavouriteItem();
		System.out.println("Favourites after add");
		testGetAllFavouriteItems();
		testRemoveFavouriteItem();
		System.out.println("Favourites after removal");
		testGetAllFavouriteItems();
	}

	public static void testGetAllFavouriteItems() {
		FavouritesDao favouritesDao = new FavouriteDaoCollectionImpl();
		try {
		List<Movie> movieListCustomer = favouritesDao.getAllFavourites(1);
		
		for (Movie movie : movieListCustomer) {
			System.out.println(movie);
		}
		System.out.println("No of favourites :" +movieListCustomer.size() +"\n");
		}
		catch (FavouritesEmptyException e) {
				System.out.println(e.getMessage());
			}
		}
	

	public static void testAddFavouriteItem() throws FavouritesEmptyException {
		FavouritesDao favouritesDao = new FavouriteDaoCollectionImpl();
		favouritesDao.addFavourites(1, 2l);
		favouritesDao.addFavourites(1, 5l);
	}

	public static void testRemoveFavouriteItem() throws FavouritesEmptyException {
		FavouritesDao favouritesDao = new FavouriteDaoCollectionImpl();
			//favouritesDao.removeFavourites(1, 2l);
			favouritesDao.removeFavourites(1, 5l);
			
		} 
	}

		

	



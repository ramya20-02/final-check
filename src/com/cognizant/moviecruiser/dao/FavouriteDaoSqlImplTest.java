package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public class FavouriteDaoSqlImplTest {

	public static void main(String[] args) throws FavouritesEmptyException{
		
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
			FavouritesDao favouritesDao = new FavouriteDaoSqlImpl();
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
			FavouritesDao favouritesDao = new FavouriteDaoSqlImpl();
			favouritesDao.addFavourites(1, 2l);
			favouritesDao.addFavourites(1, 5l);
		}

		public static void testRemoveFavouriteItem() throws FavouritesEmptyException {
			FavouritesDao favouritesDao = new FavouriteDaoSqlImpl();
				favouritesDao.removeFavourites(1, 2l);
				//favouritesDao.removeFavourites(1, 5l);
				
			} 
	}



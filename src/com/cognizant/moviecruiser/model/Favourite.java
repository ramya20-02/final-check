package com.cognizant.moviecruiser.model;

import java.util.ArrayList;
import java.util.List;

public class Favourite {

	private List<Movie> movieList;
	private double total;
	
	public Favourite() {
		super();
		movieList=new ArrayList<>();
		total=0;
	}
	
	public Favourite(List<Movie> movieList, double total) {
		super();
		this.movieList = movieList;
		this.total = total;
	}
	
	
	
	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}

	public List<Movie> getMovieList() {
	return movieList;
	}
      
}

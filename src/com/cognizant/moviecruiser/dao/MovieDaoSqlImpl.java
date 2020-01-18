package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public class MovieDaoSqlImpl implements MovieDao {

	@Override
	public List<Movie> getMovieListAdmin() {
		
		List<Movie> movieList = new ArrayList<>();

		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "select mo_id ,mo_title ,mo_box_office ,mo_active,mo_date_of_launch ,mo_genre,mo_has_teaser "
					+ "from movie_list";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Movie m = new Movie();
				m.setId(rs.getLong(1));
				m.setTitle(rs.getString(2));
				m.setBoxOffice(rs.getLong(3));
				m.setActive(rs.getString(4).equalsIgnoreCase("yes"));
				m.setDateOfLaunch(rs.getDate(5));
				m.setGenre(rs.getString(6));
				m.setHasTeaser(rs.getString(7).equalsIgnoreCase("yes"));

				movieList.add(m);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return movieList;
	}

	@Override
	public List<Movie> getMovieListCustomer() {
		List<Movie> customerList = new ArrayList<>();
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "select * from movie_list WHERE mo_active=? AND mo_date_of_launch < ?"; 
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "Yes");
			java.util.Date d = new java.util.Date();
			ps.setDate(2, new java.sql.Date(d.getTime()));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Movie m = new Movie();
				m.setId(rs.getLong(1));
				m.setTitle(rs.getString(2));
				m.setBoxOffice(rs.getLong(3));
				m.setActive(rs.getString(4).equalsIgnoreCase("yes"));
				m.setDateOfLaunch(rs.getDate(5));
				m.setGenre(rs.getString(6));
				m.setHasTeaser(rs.getString(7).equalsIgnoreCase("yes"));

				customerList.add(m);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customerList;
	}

	@Override
	public void editMovies(Movie movie) {
		String sql = "UPDATE movie_list SET mo_title=?,mo_box_office=?,mo_active=?,mo_date_of_launch=?,mo_genre=?,mo_has_teaser=? WHERE mo_id=?";
		Connection con = ConnectionHandler.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, movie.getTitle());
			ps.setLong(2, movie.getBoxOffice());
			ps.setString(3, movie.isActive()?"Yes" : "No");
			ps.setDate(4, new java.sql.Date(movie.getDateOfLaunch().getTime()));
			ps.setString(5, movie.getGenre());
			ps.setString(6, movie.isHasTeaser()?"Yes" : "No");
			ps.setLong(7, movie.getId());
			int result = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Movie getMovie(long movieId) {
		Movie movie=new Movie();
		Connection con=ConnectionHandler.getConnection();
		try {
			String sql="SELECT *FROM movie_list WHERE mo_id=?" ;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Movie m = new Movie();
				m.setId(rs.getLong(1));
				m.setTitle(rs.getString(2));
				m.setBoxOffice(rs.getLong(3));
				m.setActive(rs.getString(4).equalsIgnoreCase("yes"));
				m.setDateOfLaunch(rs.getDate(5));
				m.setGenre(rs.getString(6));
				m.setHasTeaser(rs.getString(7).equalsIgnoreCase("yes"));
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return movie;
	}
         
}

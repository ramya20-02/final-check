package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Favourite;
import com.cognizant.moviecruiser.model.Movie;

public class FavouriteDaoSqlImpl  implements FavouritesDao {

	@Override
	public void addFavourites(long userId, long movieId) {
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "INSERT INTO favorite(ft_us_id,ft_pr_id)\r\n" + 
					"VALUES (?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, movieId);
			int result = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Movie> getAllFavourites(long userId) throws FavouritesEmptyException {
		Connection con = ConnectionHandler.getConnection();
		List<Movie> favouriteList = new ArrayList<>();
		Favourite favourite=new Favourite();
		try {
			String sql = "SELECT  mo_id ,mo_title,mo_box_office ,mo_active ,mo_date_of_launch,mo_genre,mo_has_teaser"
					+ " FROM movie_list INNER JOIN favorite ON ft_pr_id=mo_id WHERE ft_us_id=?";
;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
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

				favouriteList.add(m);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return favouriteList;
	}

	@Override
	public void removeFavourites(long userId, long MovieId) {
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "DELETE FROM favorite \r\n" + 
					"WHERE ft_us_id=? AND ft_pr_id=? limit 1";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, MovieId);
			int result = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}

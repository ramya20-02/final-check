package com.cognizant.movie.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavouriteDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.FavouritesDao;
import com.cognizant.moviecruiser.model.Movie;

/**
 * Servlet implementation class ShowFavouriteServlet
 */
@WebServlet({ "/ShowFavouriteServlet", "/ShowFavourite" })
public class ShowFavouriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFavouriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FavouritesDao favouritesDao = new FavouriteDaoCollectionImpl();
		try {
			List<Movie> favouriteItem = favouritesDao.getAllFavourites(1);
			double total = 0;
			for (Movie movie : favouriteItem) {
				total += movie.getBoxOffice();
			}
			request.setAttribute("movieList", favouriteItem);
			RequestDispatcher rd = request.getRequestDispatcher("favorites.jsp");
			rd.forward(request, response);
		} catch (Exception ex) {
			RequestDispatcher rd = request.getRequestDispatcher("favorites-empty.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

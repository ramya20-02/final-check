package com.cognizant.movie.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavouriteDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.FavouritesDao;

/**
 * Servlet implementation class AddToFavouriteServlet
 */
@WebServlet({ "/AddToFavouriteServlet", "/AddToFavourite" })
public class AddToFavouriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToFavouriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			FavouritesDao favouritesDao = new FavouriteDaoCollectionImpl();
			long movieId = Long.parseLong(request.getParameter("movieId"));
			favouritesDao.addFavourites(1,movieId);
			request.setAttribute("msg", "Items added to Favourites Successfully");
			RequestDispatcher rd = request.getRequestDispatcher("ShowMovieListCustomer");
			rd.forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

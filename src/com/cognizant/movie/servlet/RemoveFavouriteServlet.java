package com.cognizant.movie.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavouriteDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.FavouriteDaoSqlImpl;
import com.cognizant.moviecruiser.dao.FavouritesDao;

/**
 * Servlet implementation class RemoveFavouriteServlet
 */
@WebServlet({ "/RemoveFavouriteServlet", "/RemoveFavourite" })
public class RemoveFavouriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFavouriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			FavouritesDao favouritesDao = new FavouriteDaoSqlImpl();
			long movieId = Long.parseLong(request.getParameter("movieId"));
			favouritesDao.removeFavourites(1,movieId);
			request.setAttribute("msg", "Items removed from Favourites Successfully");
			RequestDispatcher rd = request.getRequestDispatcher("ShowFavourite");
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

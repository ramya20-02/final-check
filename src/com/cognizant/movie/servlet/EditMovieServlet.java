package com.cognizant.movie.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.dao.MovieDaoCollectionImpl;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet({ "/EditMovieServlet", "/EditMovie" })
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			long id=Long.parseLong(request.getParameter("movieId"));
		    String title=request.getParameter("txtTitle");
		    int boxOffice=Integer.parseInt(request.getParameter("txtGross"));
			boolean active=request.getParameter("active").equalsIgnoreCase("yes");
			String dateoflaunch=request.getParameter("txtDoL");
			String genre=request.getParameter("genre");
			boolean hasteaser=request.getParameter("hasTeaser").equalsIgnoreCase("yes");
			
			Movie m = new Movie(id,title,boxOffice,active,DateUtil.convertToDate(dateoflaunch),genre,hasteaser);
			MovieDao movieDao=new MovieDaoCollectionImpl();
			
			movieDao.editMovies(m);
			
	        request.setAttribute("msg", "Movies item details saved Successfully" );
	        RequestDispatcher rd=request.getRequestDispatcher("edit-movie-status.jsp");
	        rd.forward(request, response);
			
		} catch (Exception ex) {
			ex.printStackTrace();
	}

	}
}

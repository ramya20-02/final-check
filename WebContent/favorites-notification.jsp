<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Favorites notification</title>
    <link rel="stylesheet" type="text/css" href="./style/style.css">
</head>
<body>
    <header>
	   <span>Movie Cruiser</span>
	   <img src="./images/logo.png"/>
	   <a id="favorites" href="ShowFavourite">Favorites</a>
	   <a id="movies" href="ShowMovieListCustomer">Movies</a>
	</header>
 <div>
   <h1 class="cont">Favorites</h1>
   <h3>Movie removed from Favorites successfully</h3>
   <table class="cont">
	 <tr>
	  <th class="text-left">Title</th>
	  <th class="text-right">Box Office</th>
	  <th class="text-center">Genre</th>
	  <th></th>
	 </tr>
	 <c:forEach items="${movieList}" var="movie">
    <tr>
	  <td class="text-left">${movie.title}</td>
	  <td class="text-right">${movie.boxOffice}</td>
      <td class="text-center">${movie.genre}</td>
	  <td class="text-center"><a href="RemoveFavourite?movieId=${movie.id}" target="_blank">Delete</a></td>
	</tr>
	</c:forEach>
	 <tr>
	  <th class="text-left">No.of Favorites:2</th>
	 </tr>
	 </table>
</div>
	<footer>
      <span>Copyright@2019</span>
	</footer>  
</body>
</html>
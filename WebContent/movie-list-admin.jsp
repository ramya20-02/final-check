<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>movie list admin</title>
    <link rel="stylesheet" type="text/css" href="./style/style.css">
</head>
<body>
    <header>
	   <span>Movie Cruiser</span>
	   <img src="./images/logo.png"/>
	   <a id="movies" href="ShowMovieListAdmin">Movies</a>
	</header>
 <div>
   <h1 class="cont">Movies</h1>
	<table class="cont">
	<tr>
	  <th class="text-left">Title</th>
	  <th class="text-right">Box Office</th>
	  <th class="text-center">Active</th>
	  <th class="text-center">Date of Launch</th>
	  <th class="text-center">Genre</th>
	  <th class="text-center">Has Teaser</th>
	  <th class="text-center">Action</th>	
	</tr>
	<c:forEach items="${movieList}" var="movie">
    <tr>
	  <td class="text-left">${movie.title}</td>
	  <td class="text-right">${movie.boxOffice}</td>
	  <td class="text-center"><c:if test="${movie.active}">Yes </c:if>
			     <c:if test="${!movie.active}"> No </c:if></td>
      <td class="text-center"><fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${movie.dateOfLaunch}" var="format"/>${format}</td>
      <td class="text-center">${movie.genre}</td>
	  <td class="text-center"><c:if test="${movie.hasTeaser}">Yes </c:if>
			     <c:if test="${!movie.hasTeaser}"> No </c:if></td>
	  <td class="text-center"><a href="ShowEditMovie?movieId=${movie.id}">Edit</a></td>
	</tr>
	</c:forEach>
   </table>
 </div>
	<footer>
      <span>Copyright@2019</span>
	</footer>  
</body>
</html>
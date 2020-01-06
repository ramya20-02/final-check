<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>edit movie</title>
    <link rel="stylesheet" type="text/css" href="./style/style.css">
	<script src="./js/script.js" type="text/javascript"></script>
</head>
<body>
    <header>
	   <span>Movie Cruiser</span>
	   <img src="./images/logo.png"/>
	   <a id="movies" href="ShowMovieListAdmin">Movies</a>
	</header>
 <div>
   <h1 class="cont">Edit Movie</h1>
   
   <form class="cont" name="form" onSubmit="return validation()" method="post" action="EditMovie?movieId=${movie.id}">
            <table>
                <tr>
                       <td colspan="4">
				         <label for="txtTitle">Title</label>
					   </td>
                </tr>
                <tr>
				       <td colspan="4"><input type="text" id="txtTitle" name="txtTitle" size="80" value="${movie.title }"></td>
                </tr>
                <tr>
                       <td><label for="txtGross">Gross($)</label></td>
                       <td>Active</td>
                       <td><label for="txtDateofLaunch">Date of Launch</label></td>
                       <td><label for="Genre">Genre</label></td>
                </tr>
                <tr>
                       <td>
					      <input type="textbox"  id="txtGross" name="txtGross" value="${movie.boxOffice }">
					   </td>
                       <td>
					     <label><input type="radio" id="rdYes" name="active" value="Yes" <c:if test="${movie.active eq 'true'}"> checked="checked"</c:if>>Yes</label> 
						<label for="rdNo"><input type="radio" id="rdNo" name="active" value="No" <c:if test="${movie.active eq 'false'}"> checked="checked" </c:if>>No</label>
					   </td>
                       <td><fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${movie.dateOfLaunch}" var="format"/>
					      <input type="text" id="txtDoL" name="txtDoL" value="${format}"/>
					   </td>
                       <td><select name="genre" id="txtGenre" value="${movie.genre}">
                           <option value=ScienceFiction>Science Fiction</option>
                           <option value=Superhero>Superhero</option>
                           <option value=Romance>Romance</option>
                           <option value=Comedy>Comedy</option>
						   <option value=Adventure>Adventure</option>
						   <option value=Thriller>Thriller</option>
						    <option value=Superhero>Superhero</option></select>
					   </td>
                </tr>
                <tr>
                       <td colspan="5"><input type="checkbox" id="cbhasTeaser" name="hasTeaser" value="Yes"
                                <c:if test="${movie.hasTeaser eq 'true'}"> checked="checked"</c:if>
                                <c:if test="${movie.hasTeaser eq 'false'}"> </c:if>/>Has Teaser</td>
                </tr>
                <tr>
                       <td  colspan="2"><input class="color" type="submit" value="Save" onclick="validation()"/></td>
                </tr>
            </table>
    </form>
 </div>   
   <footer>
                <span>Copyright@2019</span>
   </footer>
    </body>
</html>

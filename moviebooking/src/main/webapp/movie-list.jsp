<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie List</title>
</head>
<body>
<div id="root">
		<table>
			<thead>
				<tr>
					<th>Movie Id</th>
					<th>Movie Name</th>
					<th>Movie Date</th>
					<th>Price</th>
					<th>Update</th>
					<th>Remove</th>
					<!-- <th>Book</th> -->
				</tr>
			</thead>
			<tbody>
		
				<c:forEach var="movie" items="${movieList}">
					<tr>
						<td>${movie.movieId}</td>
						<td>${movie.movieName}</td>
						<td>${movie.movieDate}</td>
						<td>${movie.price}</td>
						<td><a href = "/admin/updatemoviedetails"><button>Update</button></a>
						<td><a href = "/admin/removemoviedetails"><button>Delete</button></a>
						<!-- <td><a href=""><button>Book</button></a> -->
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
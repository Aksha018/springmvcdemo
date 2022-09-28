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
				</tr>
			</thead>
			<tbody>
		
				<c:forEach var="movie" items="${bookingList}">
					<tr>
						<td>${movie.movieId}</td>
						<td>${movie.movieName}</td>
						<td>${movie.movieDate}</td>
						<td>${movie.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Adding Movie Details</h1>
<form action = "add" method="get">
<table>
<tr><td>MovieId:</td>
<td><input type="text" name="movieId"/></td></tr>
<tr><td>Movie Name:</td>
<td><input type="text" name="movieName"/></td></tr>
<tr><td>Movie Date:</td>
<td><input type="date" name="movieDate"/></td></tr>
<tr><td>Price:</td>
<td><input type="text" name="price"/></td></tr>

<tr><td colspan="2"><input type="submit" value="Add"/></td></tr>
</table>
</form>
</body>
</html>
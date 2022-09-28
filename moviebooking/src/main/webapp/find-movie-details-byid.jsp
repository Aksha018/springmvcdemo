<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find by Id</title>
</head>
<body>
<h1>Finding Movie Details</h1>
<form action = "find" method="get">
<table>
<tr><td>MovieId:</td>
<td><input type="text" name="movieId" value="${movieId}" readonly/></td></tr>
<tr><td colspan="2"><input type="submit" value="Find"/></td></tr>
</table>
</form>
</body>
</html>
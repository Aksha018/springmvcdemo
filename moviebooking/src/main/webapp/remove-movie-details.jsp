<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
<h1>Removing Movie Details</h1>
<form action = "remove" method="get">
<table>
<tr><td>MovieId:</td>
<td><input type="text" name="movieId"/></td></tr>
<tr><td colspan="2"><input type="submit" value="Delete"/></td></tr>
</table>
</form>
</body>
</html>
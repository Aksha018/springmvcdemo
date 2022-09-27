<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
<form action="delete" method="get">
<table>
<h1>Delete User</h1>
<tr><td>UserId:</td>
<td><input type="text" name="userId" required="true"/></td></tr>
<tr><td colspan="2">
<input type="submit" value="Delete"/></td></tr>
</table>
</form>
</body>
</html>
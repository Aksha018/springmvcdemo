<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add user</title>
</head>
<body>
<h1>Add User</h1>
<form action = "add" method="get">
<table>
<tr><td>UserId:</td>
<td><input type="text" name="userId"/></td></tr>
<tr><td>User Name:</td>
<td><input type="text" name="name"/></td></tr>
<tr><td>Password:</td>
<td><input type="password" name="password"/></td></tr>

<tr><td colspan="2"><input type="submit" value="Add"/></td></tr>
</table>

</form>
</body>
</html>
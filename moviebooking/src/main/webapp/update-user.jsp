<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
</head>
<body>
<h1>Update User</h1>
<form action = "update" method="get">
<table>
<tr><td>UserId:</td>
<td><input type="text" name="userId"/></td></tr>
<tr><td>User Name:</td>
<td><input type="text" name="name"/></td></tr>
<tr><td>Password:</td>
<td><input type="password" name="password"/></td></tr>

<tr><td colspan="2"><input type="submit" value="Update"/></td></tr>
</table>

</form>
</body>
</html>
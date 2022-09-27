<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add user</title>
</head>
<body>
<form action="add" method="get">
<table>
<h1>Add User</h1>
<tr><td>UserId:</td>
<td><input type="text" name="userId" required="true"/></td></tr>
<tr><td>User Name:</td>
<td><input type="text" name="name" pattern="^[a-z A-Z]+$" title="Please Enter Alphabtes Only"  placeholder = "Enter Your Name" required="true"/></td></tr>
<tr><td>Password:</td>
<td><input type="password" name="password" required="true"/></td></tr>
<tr><td>Mobile Number:</td>
<td><input type="text" name="mobileNo" required="true"/></td></tr>

<tr><td colspan="2">
<input type="submit" value="Add"/></td></tr>
</table>

</form>
</body>
</html>
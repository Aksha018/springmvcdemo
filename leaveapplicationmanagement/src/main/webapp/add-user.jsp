<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang ="en">
<head>
<meta charset="ISO-8859-1">
<title>Add New User</title>
</head>
<body>
<h1>Add User</h1>
<form action="adduser" method="get">  
<table>  
<tr><td>UserId:</td>
<td><input type="text" name="id"/></td></tr>  
<tr><td>Name:</td>
<td><input type="text" name="name"/></td></tr>  
<tr><td>Email:</td>
<td><input type="email" name="email" /></td></tr> 
<tr><td>Password:</td>
<td><input type="password" name="password"/></td></tr>  

<tr><td colspan="2"><input type="submit" value="Add"/></td></tr> 
 
</table>  
</form>  
</body>
</html>

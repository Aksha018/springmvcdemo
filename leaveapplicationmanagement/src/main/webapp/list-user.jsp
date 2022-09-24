<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>List User</title>
</head>
<body>
<h1>User List</h1>
<div id="root">
	<table>
		<thead>
			<tr>
				<th>User Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Password</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.password}</td>
				
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>


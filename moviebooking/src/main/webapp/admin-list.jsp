<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>
<div id="root">
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Password</th>
				</tr>
			</thead>
			<tbody>
		
				<c:forEach var="admin" items="${adminList}">
					<tr>
						<td>${admin.name}</td>
						<td>${admin.password}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
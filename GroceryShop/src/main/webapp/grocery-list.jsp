<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Grocery List</title>
</head>
<body>
<div id="root">
		<table>
			<thead>
				<tr>
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>User Id</th>
				</tr>
			</thead>
			<tbody>
		
				<c:forEach var="grocery" items="${groceryList}">
					<tr>
						<td>${grocery.productId}</td>
						<td>${grocery.productName}</td>
						<td>${grocery.quantity}</td>
						<td>${grocery.price}</td>
						<td>${grocery.userId}</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
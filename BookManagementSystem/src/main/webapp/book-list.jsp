<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BooksList</title>
</head>
<body>
	<div id="root">
		<table>
			<thead>
				<tr>
					<th>Book Id</th>
					<th>Book Name</th>
					<th>Author</th>
					<th>Year of Publishing</th>
					<th>Price</th>
					<th>Selling Date</th>
				</tr>
			</thead>
			<tbody>
		
				<c:forEach var="book" items="${bookList}">
					<tr>
						<td>${book.bookId}</td>
						<td>${book.bookName}</td>
						<td>${book.author}</td>
						<td>${book.publishingYear}</td>
						<td>${book.price}</td>
						<td>${book.sellingDate}</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
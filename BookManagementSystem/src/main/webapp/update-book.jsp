<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Books</title>
</head>
<body>
<h1>Update Book Details</h1>
<form action ="update" method="get">
<table>
<tr><td>Book Id:</td>
<td><input type="text" name="bookId"/></td></tr>
<tr><td>Book Name:</td>
<td><input type="text" name="bookName"/></td></tr>
<tr><td>Author :</td>
<td><input type="text" name="author"/></td></tr>
<tr><td>Year of publishing :</td>
<td><input type="text" name="publishingYear"/></td></tr>
<tr><td>Price:</td>
<td><input type="text" name="price"/></td></tr>
<tr><td>Selling Date:</td>
<td><input type="date" name="sellingDate"/></td></tr>

<tr><td colspan="2"><input type="submit" value="Update"/></td></tr>
</table>
</form>
</body>
</html>
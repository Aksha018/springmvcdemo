<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Grocery</title>
</head>
<body>
<form action="delete" method="get">
<table>
<h1>Delete product</h1>
<tr><td>Product Id:</td>
<td><input type="text" name="productId" required="true"/></td></tr>
<tr><td colspan="2">
<input type="submit" value="delete"/></td></tr>
</table>

</form>
</body>
</html>
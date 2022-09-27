<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update product</title>
</head>
<body>
<form action="update" method="get">
<table>
<h1>Update Product</h1>
<tr><td>Product Id:</td>
<td><input type="text" name="productId" required="true"/></td></tr>
<tr><td>Product Name:</td>
<td><input type="text" name="productName"  required="true"/></td></tr>
<tr><td>Quantity:</td>
<td><input type="text" name="quantity" required="true"/></td></tr>
<tr><td>Price:</td>
<td><input type="text" name="price" required="true"/></td></tr>
<tr><td>User Id:</td>
<td><input type="text" name="userId" required="true"/></td></tr>

<tr><td colspan="2">
<input type="submit" value="Update"/></td></tr>
</table>

</form>

</body>
</html>
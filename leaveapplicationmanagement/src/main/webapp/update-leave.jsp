<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leave update</title>
</head>
<body>
<form action=update method="get">
<table>
<tr><td>Leave Id:</td>
<td><input type="text" name="leaveId"/></td></tr>
<tr><td>Leave Type:</td>
<td><input type="text" name="leaveType"/></td></tr>
<tr><td>From Date:</td>
<td><input type="date" name="fromDate"/></td></tr>
<tr><td>To Date:</td>
<td><input type="date" name="toDate"/></td></tr>
<tr><td>No of Days:</td>
<td><input type="text" name="noOfDays"/></td></tr>
<tr><td>User Id</td>
<td><input type="text" name="id"/></td></tr>

<tr><td colspan="2"><input type ="submit" value="update"/></td></tr>
</table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
<h1>Add Employee</h1>
<form action="addemployee" method="get">  
<table>  
<tr><td>Employee Id:</td>
<td><input type="text" name="empId"/></td></tr>  
<tr><td>Employee Name:</td>
<td><input type="text" name="empName"/></td></tr>  
<tr><td>Salary:</td>
<td><input type="text" name="salary" /></td></tr> 
<tr><td>Designation:</td>
<td><input type="text" name="designation"/></td></tr>  

<tr><td colspan="2"><input type="submit" value="Add"/></td></tr> 
 </table>
 </form>
</body>
</html>
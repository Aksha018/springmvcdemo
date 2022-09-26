<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
</head>
<body>
	<h1>Employee List</h1>
	<div id="root">
		<table>
			<thead>
				<tr>
					<th>Employee Id</th>
					<th>Employee Name</th>
					<th>Salary</th>
					<th>Designation</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="employee" items="${employeeList}">
					<tr>
						<td>${employee.empId}</td>
						<td>${employee.empName}</td>
						<td>${employee.salary}</td>
						<td>${employee.designation}</td>
				</c:forEach>
				<tr>
					<td>${findbyempid.empId }</td>
					<td>${findbyempid.empName}</td>
					<td>${findbyempid.salary}</td>
					<td>${findbyempid.designation}</td>
				</tr>
			</tbody>
		</table>
</div>
</body>
</html>
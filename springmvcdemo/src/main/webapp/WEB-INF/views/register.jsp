<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<div id="root">
		<form:form action="addemployee" method="post" modelAttribute="add">
	        <div>
				<label for="empName">Employee Name</label>
				<form:input id="empName" path="empName" pattern="^[a-z A-Z]+$" title="Please Enter Alphabtes Only"  placeholder = "Enter Your Name" required="true"/>
	
			</div>
			<div>
				<label for="email">Email</label>
				<form:input id="email" path="email" pattern="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$" title ="Enter a valid email welcome03@gmail.com" placeholder = "Enter a Email" required="true"/>
			</div>
			<div>
				<label for="password">Password</label>
				<form:input id="password" path="password" type="password" required="true"/>
			</div>
			<div>
				<label for="phoneNumber">Phone Number</label>
				<form:input id="phoneNumber" path="phoneNumber" pattern="[0-9]{3}[0-9]{3}[0-9]{4}" title="Enter 10 digits number" placeholder = "Enter Phone Number" required="true"/>
			</div>
			
			<form:button id="log">Submit</form:button>
		</form:form>
		</div>
</body>
</html>
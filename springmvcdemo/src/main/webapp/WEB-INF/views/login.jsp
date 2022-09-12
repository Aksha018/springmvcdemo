<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="root">
		<form:form action="loginPage" method="post" modelAttribute="login">
			<div>
				<label for="email">Email</label>
				<form:input id="email" path="email"
					pattern="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"
					title="Enter a valid email welcome03@gmail.com"
					placeholder="Enter a Email" required="true" />
			</div>
			<br>
			<div>
				<label for="password">Password</label>
				<form:input id="password" path="password" type="password"
					required="true" />
			</div>
			<br>
			<form:button id="log">Login</form:button>
	</form:form>
	</div>
</body>
</html>
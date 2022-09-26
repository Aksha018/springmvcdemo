<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List User</title>
</head>
<body>
<div id ="root">
<table>
<thead>
   <tr>
       <th>Leave Id</th>
       <th>Leave Type</th>
       <th>From Date</th>
       <th>To Date</th>
       <th>No.of.Days</th>
       <th>User Id</th>
       </tr>
       </thead>
       <tbody>
       
       <c:forEach var="leave" items="${leaveList}">
     <tr>  <td>${leave.leaveId}</td>
       <td>${leave.leaveType}</td>
       <td>${leave.fromDate}</td>
       <td>${leave.toDate}</td>
       <td>${leave.noOfDays}</td>
       <td>${leave.id}</td></tr>
       
    </c:forEach>
       </tbody>

</table>
</div>
</body>
</html>
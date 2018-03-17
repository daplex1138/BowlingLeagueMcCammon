<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body>
<form method="post" action="editPlayerServlet">
<table>
<tr>
 <th>Select</th>
   <th>First Name</th>
   <th>Last Name</th>
   <th>Phone #</th>
   <th>Screen Name</th>  
   <th>Team</th>      
 </tr>
<c:forEach items="${requestScope.allPlayers}" var="currentitem">
<tr>
	<td><input type="radio" name="id" value="${currentitem.playerId}"></td>
	<td>${currentitem.firstName}</td>
	<td>${currentitem.lastName}</td>
	<td>${currentitem.phoneNumber}</td>
	<td>${currentitem.screenName}</td>
	<td>${currentitem.team.teamName}</td>
	</tr>
</c:forEach>
</table>
<div style="margin-top: .5em">
<!-- <input type="submit" value="Edit Selected Item" name="doThisToItem"> -->
<input type="submit" value="Delete Selected Player" name="doThisToItem">
<input type="submit" value="Add New Player" name="doThisToItem">
</div>
</form>
</body>
</html>
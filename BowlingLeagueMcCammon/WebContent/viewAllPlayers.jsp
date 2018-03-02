<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="viewAllPlayersServlet">
<table>
<c:forEach items="${requestScope.allPlayers}" var="currentitem">
<tr>
	<td><input type="radio" name="id" value="${currentitem.ID}"></td>
	<td>${currentitem.firstName}</td>
	<td>${currentitem.lastName}</td>
	<td>${currentitem.phoneNumber}</td>
	<td>${currentitem.screenName}</td>
</c:forEach>
<input type="submit" value="Edit Selected Item" name="doThisToItem">
<input type="submit" value="Delete Selected Item" name="doThisToItem">
<input type="submit" value="Add New Item" name="doThisToItem">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Team List McCammon</title>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body>
<form method ="post" action="editTeamServlet">
<table>
 <tr>
 <th>Select</th>
   <th>Team Name</th>
   <th>Team Type</th>
   <th>Preferred Night</th>   
 </tr>
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
<td><input type="radio" name="id" value="${currentitem.id}"></td>
<td>${currentitem.teamName}</td>
<td>${currentitem.teamType}</td>
<td>${currentitem.preferredNight}</td>
</tr>
</c:forEach>
</table>
<!-- <input type="submit" value="Edit Selected Team" name="doThisToItem"> -->
<div style="margin-top: .5em">
<input type="submit" value="Delete Selected Team" name="doThisToItem">
<input type="submit" value="Add New Team" name="doThisToItem">
</div>
</form>

</body>
</html>
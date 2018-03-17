<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="insertPlayerServlet" method="post">
		First Name: <input type="text" name="firstName"> <br /> 
		Last Name: <input type="text" name="lastName"> <br /> 
		Phone Number: <input type="text" name="phoneNumber"> <br /> 
		Screen Name: <input type="text" name="screenName"> <br /> 
		Select Team: 
		<select name="teamId">			
			<c:forEach items="${requestScope.allTeams}" var="currentitem">
				<option value="${currentitem.id}">${currentitem.teamName}</option>
			</c:forEach>
		</select>  <br />
		<input type="submit" value="Add Player"> <br />
	</form>
</body>
<a href="index.html">Home</a>
</html>
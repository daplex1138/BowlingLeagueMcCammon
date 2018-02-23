<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "editArtPieceServlet" method="post">
<h4>Title: <input type ="text" name= "title" value="${galleryArtPieceToEdit.title}"></h4>
<h4>Artist Name: <input type = "text" name= "artist_name" value= "${galleryArtPieceToEdit.artistName}"></h4>
<h4>Media: <input type ="text" name= "media" value= "${galleryArtPieceToEdit.media}"></h4> 
<h4>Year: <input type ="text" name= "year" value= "${galleryArtPieceToEdit.year}"></h4> 
<h4>Value: <input type = "text" name= "value" value= "${galleryArtPieceToEdit.value}"></h4> 
<input type = "hidden" name = "id" value= "${galleryArtPieceToEdit.id}">
<input type = "submit" value="Save Edited Art Piece">
</form>
<a href = "index.html"> Back to List</a><br />
<a href = "viewAllArtPiecesServlet">View complete list</a>
</body>
</html>
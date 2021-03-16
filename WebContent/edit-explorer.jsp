<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit Explorer</title>
	</head>
	<body>
		<form action = "editExplorerServlet" method="post">
		Gear: <input type ="text" name = "explorerName" value=
		"${explorerToEdit.explorerName}">
		<input type = "hidden" name = "explorerId" value="${explorerToEdit.explorerId}">
		<input type = "submit" value="Save Edited Explorer">
		</form>
	</body>
</html>
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
		Explorer to edit: <input type ="text" name = "explorerName" value=
		"${explorerToEdit.explorerName}">
		<input type = "hidden" name = "explorerId" value="${explorerToEdit.explorerId}"><br/>
			Available Gear:<br />
			<select name="allGearToAdd" multiple size="6">
			<c:forEach items="${requestScope.allGear}" var="currentitem">
			<option value = "${currentitem.gearId}">${currentitem.gearName}</option>
			</c:forEach>
			</select>
			<br />
			<input type = "submit" value="Save Edited Explorer">
		</form>
	</body>
</html>
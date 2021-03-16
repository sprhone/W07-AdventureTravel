<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Explorers List</title>
	</head>
	<body>
		<form method = "post" action = "explorerNavigationServlet">
			<table>
				<c:forEach items="${requestScope.allExplorers}" var="currentitem">
					<tr>
						<td><input type="radio" name="explorerId" value="${currentitem.explorerId}"></td>
						<td>${currentitem.explorerName}</td>
					<tr>
						<td></td><td colspan="3">Gear List:</td>
					</tr>
				<c:forEach var = "listVal" items = "${currentitem.listOfGear}">
					<tr><td></td><td colspan="3"> ${listVal.gearName}</td></tr>
				</c:forEach>
				</c:forEach>
			</table>
		<input type = "submit" value = "edit" name="doThisToItem">
		<input type = "submit" value = "delete" name="doThisToItem">
		<input type="submit" value = "add" name = "doThisToItem">
		</form>
	</body>
</html>
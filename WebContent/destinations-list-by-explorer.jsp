<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Destination Lists</title>
	</head>
	<body>
		<form method = "post" action = "listNavigationServlet">
			<table>
				<c:forEach items="${requestScope.allDestinations}" var="currentdest">
				<tr>
				<td><input type="radio" name="tripId" value="${currentdest.tripId}"></td>
				<td><h2>${currentdest.destinationName}</h2></td></tr>
				<tr><td colspan="3">Trip Date: ${currentdest.tripDate}</td></tr>
				<tr><td colspan="3">Explorer:
				${currentdest.explorers.explorerName}</td></tr>
				<c:forEach var = "listVal" items = "${currentdest.listOfExplorers}">
				<tr><td></td><td colspan="3">
				${listVal.explorerName}
				</td>
				</tr>
				</c:forEach>
				</c:forEach>
			</table>
		<input type = "submit" value = "edit" name="doThisToList">
		<input type = "submit" value = "delete" name="doThisToList">
		<input type="submit" value = "add" name = "doThisToList">
		</form>
		<a href="addItemsForListServlet">Create a new List</a>
		<a href="index.jsp">Add new gear</a>
	</body>
</html>
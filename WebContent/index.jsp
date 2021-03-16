<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Adventure Travel</title>
	</head>
	<body>
		<form action = "addGearServlet" method="post">
			Add new Gear: <input type ="text" name = "gear">
			<input type = "submit" value="Add Gear">
		</form> <br />
		<a href = "viewAllGearServlet">View the complete gear list</a> <br/>
		<a href = "viewAllDestinationsServlet">View all Destinations lists</a> <br/>
		<a href = "addItemsForListServlet">Create a new list</a>
	</body>
</html>
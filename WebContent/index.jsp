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
		<form action = "addExplorerServlet" method="post">
			Add new Explorer: <input type ="text" name = "explorer">
			<input type = "submit" value="Add Explorer">
		</form> <br />
		<form action = "addDestinationServlet" method="post">
			Add new Destination: <input type ="text" name = "destination">
			<input type = "submit" value="Add Destination">
		</form> <br />
		<a href = "viewAllGearServlet">View the gear list</a> <br/>
		<a href = "viewAllExplorersServlet">View the explorers list</a> <br/>
		<a href = "viewAllDestinationsServlet">View all destinations lists</a> <br/>
	</body>
</html>
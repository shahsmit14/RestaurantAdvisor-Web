<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>ADD A NE ITEM TO THE LIST</h1>
	<form action="addTheItemToMenu" method="POST">
		<table>
			<tr>
				<td>ITEM NAME:</td>
				<td><input type="text" name="item" placeholder="Enter Item Name" required="required" 
				pattern=".{4,25}" title="Please enter 4 - 25 characters" ></td>
			</tr>
			<tr>
				<td>ITEM DESCRIPTION:</td>
				<td><input type="text" name="description" placeholder="Enter Item Description" required="required" 
				pattern=".{4,25}" title="Please enter 4 - 25 characters" ></td>
			</tr>
			<tr>
				<td>PRICE:</td>
				<td><input type="text" name="price" placeholder="Amount of the item" required="required" 
				pattern="\d+(\.\d{1})?" title="Enter decimal value. eg. 25.4" ></td>
			</tr>
			<tr>
				<td><input type="submit" name="Submit" value="ADD ITEM"></td>
				<td><input type="submit" name="Submit" value="BACK"></td>
				<td><input type="hidden" name="status" value="AVAILABLE"></td>
			</tr>
		</table>
	</form>
</body>
</html>
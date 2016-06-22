<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>WELCOME AND REGISTER YOURSELF!!!</h1>

	<form action="newAdminRegisteration2" method="POST">
		<table>
			<tr>
				<td>USERNAME:</td>
				<td><input type="text" name="userName" placeholder="Enter an UserName" 
				required="required" pattern=".{6,12}" title="Please enter 6 - 12 characters"></td>
			</tr>
			<tr>
				<td>PASSWORD:</td>
				<td><input type="password" name="password" placeholder="Enter a Password" 
				required="required" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" ></td>
			
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="NEXT PAGE"></td>
				<td><input type="hidden" name="status" value="ACTIVE"></td>
			</tr>
		</table>
	</form>
</body>
</html>
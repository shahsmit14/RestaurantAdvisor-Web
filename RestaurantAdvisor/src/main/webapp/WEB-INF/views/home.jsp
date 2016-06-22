<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<!DOCTYPE html>

<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>LOGIN PAGE</title>
</head>
<body>
	<h1>Welcome to Restaurant Advisor</h1>

	<br />
	<br />
	<br />
	
	<form:form method="POST" action="login"  commandName="loginDetails">
		<table>
			<tr>
				<td>Enter Your Name:</td>
				<td><form:input type="text" path="userName" class="form-control"  placeholder="Enter a valid UserName" required="required" pattern=".{6,12}" title="Please enter 6 - 12 characters" />
				<td><form:errors path="userName" />
			</tr>
			<tr>
				<td>Enter Your Password:</td>
				<td><form:input type="password" path="password" class="form-control" placeholder="Enter a valid Password" required="required" pattern=".{6,12}" title="Please enter 6 - 12 characters" />
				<td><form:errors path="password" />
			</tr>

			<tr>
				<td><input type="submit" class="btn btn-default" name="submit" value="Submit" /></td>
				<td><a href= "newUserRegistration1">NEW USER SIGNUP</a></td>
			</tr>
			<tr>
				<td></td>
				<td><a href= "newHotelRegistration1">NEW HOTEL SIGNUP</a></td>
			</tr>

		</table>
	</form:form>
	
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details of ${loginDetails.userDetails.firstName}</title>
</head>
<body>
	<form method="GET" action="adminactdeactback">
		<table>
			<tr>
				<td><b>ADMIN INFORMATION:</b></td>
			</tr>
			<tr>
				<td>ADMIN NAME:</td>
				<td>${loginDetails.userDetails.firstName} , ${loginDetails.userDetails.lastName}</td>
			</tr>
			<tr>
				<td>E-MAIL:</td>
				<td>${loginDetails.userDetails.email}</td>
			</tr>
			<tr>
				<td>USERNAME:</td>
				<td>${loginDetails.userName}</td>
			</tr>
			<tr>
				<td>STATUS:</td>
				<td>${loginDetails.status}</td>
			</tr>
				<tr>
				<td><input type="submit" name="adminStatusChange"
					value="ACTIVE"></td>
				<td><input type="submit" name="adminStatusChange"
					value="DE-ACTIVE"></td>
				<td><input type="submit" name="adminStatusChange" value="BACK"></td>
			</tr>
		</table>
	</form>
</body>
</html>
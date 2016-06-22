<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>There are ${adminLoginDetailsSize} administrator registered</h1>

	<form>
	
		<a href="newAdminRegisteration1">Add New Administrator</a>
		
		<table>
			<tr>
				<th>User ID</th>
				<th>Username</th>
				<th>First Name, Last Name</th>
				<th>Status</th>
			</tr>

			<c:forEach var="row" items="${requestScope.adminLoginDetails}">
				<tr>
					<td><input type="text" readonly="readonly" name="userID"
						value="${row.userID}" /></td>

					<td><input type="text" readonly="readonly" name="userName"
						value="${row.userName}" /></td>

					<td><input type="text" readonly="readonly" name="hotelName"
						value="${row.userDetails.firstName} , ${row.userDetails.lastName}" /></td>

					<td><input type="text" readonly="readonly" name="status"
						value="${row.status}" /></td>

					<td><a href="manageAdministratorSelected?selectedAdmin=${row.userName}">Details</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>
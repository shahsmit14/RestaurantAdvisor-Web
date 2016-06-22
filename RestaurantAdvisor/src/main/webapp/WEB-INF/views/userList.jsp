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
	<h1>There are ${userListSize} Customers registered</h1>

	<form action="userSelected">
		<table>

			<tr>
				<th>Customer Username</th>
				<th>Customer Name</th>
				<th>Status</th>
				<th>Details</th>
			</tr>

			<c:forEach var="row" items="${requestScope.allUsers}">
				<tr>
					<td><input type="text" readonly="readonly" name="userName"
						value="${row.userName}" /></td>

					<td><input type="text" readonly="readonly" name="hotelName"
						value="${row.userDetails.firstName}" /></td>

					<td><input type="text" readonly="readonly" name="hotelName"
						value="${row.status}" /></td>
					<td><a
						href="userSelected?selectedUser=${row.userID}">Details</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>
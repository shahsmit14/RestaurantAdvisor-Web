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
	<h1>There are ${menuListSize} Items on the Menu</h1>
	<form>
		<a href="addNewMenuItem">Add NEW ITEM TO MENU LIST</a>
		<table>
			<tr>
				<th>ITEM NAME</th>
				<th>DESCRIPTION</th>
				<th>PRICE</th>
				<th>STATUS</th>
				<th>TOGGLE STATUS</th>
			</tr>
			<c:forEach var="row" items="${requestScope.menuList}">
				<tr>
					<td><input type="text" readonly="readonly" name="ITEM NAME"
						value="${row.item}" /></td>

					<td><input type="text" readonly="readonly" name="DESCRIPTION"
						value="${row.description}" /></td>

					<td><input type="text" readonly="readonly" name="PRICE"
						value="${row.price}" /></td>

					<td><input type="text" readonly="readonly" name="status"
						value="${row.status}" /></td>

					<td><a href="toggleStatus?selectedItem=${row.menuDetailsId}">ToggleStatus</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>
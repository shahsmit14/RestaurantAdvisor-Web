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
	<h1>ORDER COMPRISES OF A TOTAL OF ${OrderdetailSize} ITEMS</h1>

	<form action="viewHotelOrders">
		<table>
			<tr>
				<th>ITEM NAME</th>
				<th>PRICE</th>
				<th>QUANTITY</th>
			</tr>
			<c:forEach var="row" items="${requestScope.OrderDetail}">
				<tr>
					<td><input type="text" readonly="readonly" name="ITEM NAME"
						value="${row.menuDetails.item}" /></td>

					<td><input type="text" readonly="readonly" name="PRICE"
						value="${row.menuDetails.price}" /></td>

					<td><input type="text" readonly="readonly" name="QUANTITY"
						value="${row.quantity}" /></td>
			</c:forEach>
			<tr>
				<td><input type="submit" name="submit" value="SUBMIT"></td>
			</tr>

		</table>
	</form>

</body>
</html>
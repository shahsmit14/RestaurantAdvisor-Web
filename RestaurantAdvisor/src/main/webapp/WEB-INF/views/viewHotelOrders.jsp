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
	<h1>TOTAL NUMBER ORDERS ARE ${OrderListSize}</h1>

	<form>
		<table>
			<tr>
				<th>CUSTOMER NAME</th>
				<th>TIME-DATE</th>
				<th>STATUS</th>
				<th>TOTALCOST</th>
			</tr>

			<c:forEach var="row" items="${requestScope.OrderList}">
				<tr>
					<td><input type="text" readonly="readonly"
						name="CUSTOMER NAME"
						value="${row.customerLoginDetails.userDetails.firstName},${row.customerLoginDetails.userDetails.lastName} " /></td>

					<td><input type="text" readonly="readonly" name="TIME-DATE"
						value="${row.orderTimeStamp}" /></td>

					<td><input type="text" readonly="readonly" name="STATUS"
						value="${row.orderStatus}" /></td>

					<td><input type="text" readonly="readonly" name="TOTALCOST"
						value="${row.totalCost}" /></td>

					<td><a
						href="viewCompleteOrder?SelectedOrder=${row.orderId}">Details</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>ITEMS AT PRESENT AVAILABLE:</h1>
	<h2>A TOTAL ${MenuListSize}:</h2>

	<form action="placeOrder">
		<table>
			<tr>
				<th>ITEM ID</th>
				<th>ITEM NAME</th>
				<th>DESCRIPTION</th>
				<th>PRICE</th>
				<th>ORDER QTY</th>
			</tr>


			<c:forEach var="row" items="${requestScope.MenuList}">
				<tr>
					<td><input type="text" readonly="readonly"
						name="menuDetailsId" value="${row.menuDetailsId}" /></td>

					<td><input type="text" readonly="readonly" name="item"
						value="${row.item}" /></td>

					<td><input type="text" readonly="readonly" name="description"
						value="${row.description}" /></td>

					<td><input type="text" readonly="readonly" name="price"
						value="${row.price}" /></td>

					<td><input type="text"  name="orderQuantity" value="0" 
							required="required" pattern="[0-9]{1,2}" placeholder="Enter a Quantity" title="Please enter a quantity"/></td>
				</tr>
			</c:forEach>
		</table>
		
		<input type="hidden" value="${hotelID}" name="hotelID">
		<input type="submit" value="PLACE ORDER">
	</form>

</body>
</html>